package jdhe.iyibank.com.iyimeal.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.loopj.android.http.AsyncHttpClient;

import org.apache.http.conn.ssl.SSLSocketFactory;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import jdhe.iyibank.com.iyimeal.MainActivity;
import jdhe.iyibank.com.iyimeal.util.LogTool;
import jdhe.iyibank.com.iyimeal.util.SessionIdUtils;
import jdhe.iyibank.com.iyimeal.util.SharePreferenceUtil;
import jdhe.iyibank.com.iyimeal.util.ToastUtils;

/**
 * Created by Administrator on 2017/5/5.
 */

public class MyAppLication extends Application {

    private static SharePreferenceUtil sharePreferenceUtil;
    private static MyAppLication instance;
    public static AsyncHttpClient client;
    public static int screenW, screenH;
    private List<Activity> activityList;
    private List<Activity> buyActivityList;
    public int imageNub = 0;
    public static String[] iyishop = new String[3];

    /**
     * 获取Context
     * @return 返回Context的对象
     */
    public static Context getContext(){
        return instance.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sharePreferenceUtil = new SharePreferenceUtil(this);
        instance = this;
        initClient();
        activityList = new LinkedList<Activity>();
        buyActivityList = new LinkedList<Activity>();

    }

    public static SharePreferenceUtil getSharePreferenceUtil() {
        return sharePreferenceUtil;
    }

    public static MyAppLication getInstance() {
        return instance;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
        LogTool.i("当前activity开启数量：" + activityList.size());
    }

    public void addBuyActivity(Activity activity) {
        buyActivityList.add(activity);
        LogTool.i("当前activity开启数量：" + buyActivityList.size());
    }

    public ArrayList<Activity> mainActivity = new ArrayList<Activity>();

    public void startMainActivity(Activity activity) {
        mainActivity.add(activity);
        LogTool.i("当前主页启动次数：" + mainActivity.size());
    }

    public void closeMainActivity() {
        LogTool.i("当前主页关闭次数：" + mainActivity.size());
        for (Activity activity : mainActivity) {
            activity.finish();
            LogTool.i("当前主页关闭次数：" + mainActivity.size());
        }
    }

    public void removeActivity(Activity activity) {
        activityList.remove(activity);
        LogTool.i("当前activity开启数量：" + activityList.size());
    }

    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

    public void clearClass() {
        for (Activity activity : buyActivityList) {
            if (activity != null) {
                String classNmae = activity.getPackageName() + "." + activity.getLocalClassName();
                if (!classNmae.equals("com.iyibank.IyibankMianActivity")) {
                    activity.finish();
                }
            }
        }
        buyActivityList.clear();
    }

    public void initClient() {
        client = new AsyncHttpClient();
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore
                    .getDefaultType());
            SSLSocketFactory sf = new SSLSocketFactoryEx(trustStore);
            client.setSSLSocketFactory(sf);
            client.setTimeout(30000);
            client.addHeader("Authorization", SessionIdUtils.getTokingId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void toLoginActivity(Activity activity, String statusCode) {
        if ("401".equals(statusCode)) {
            ToastUtils.makeText(this, "请重新登陆，用户信息出错");
            activity.startActivity(new Intent(activity, MainActivity.class));
        } else {
            if (activity instanceof MainActivity) {
                if ("400".equals(statusCode)){
                    ToastUtils.makeText(this, " 账号或密码错误");
                }
            }else {
                ToastUtils.makeText(this, "请求失败，请重试");
//                if (activity instanceof LaunchActivity) {
//                    activity.startActivity(new Intent(activity, MainActivity.class));
//                }
            }
        }
    }

//    public void setProgressDialogShow(Activity activity) {
//
//    }
//    public void disProgressDialog(){
//
//    }


   static class SSLSocketFactoryEx extends SSLSocketFactory {
        SSLContext sslContext = SSLContext.getInstance("TLS");

        public SSLSocketFactoryEx(KeyStore truststore)
                throws NoSuchAlgorithmException, KeyManagementException,
                KeyStoreException, UnrecoverableKeyException {
            super(truststore);
            TrustManager tm = new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain, String authType)
                        throws java.security.cert.CertificateException {

                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain, String authType)
                        throws java.security.cert.CertificateException {

                }
            };

            sslContext.init(null, new TrustManager[]{tm}, null);
        }


        @Override
        public Socket createSocket(Socket socket, String host, int port,
                                   boolean autoClose) throws IOException, UnknownHostException {
            return sslContext.getSocketFactory().createSocket(socket, host, port,
                    autoClose);
        }

        @Override
        public Socket createSocket() throws IOException {
            return sslContext.getSocketFactory().createSocket();
        }

    }
}
