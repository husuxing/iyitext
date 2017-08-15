package jdhe.iyibank.com.iyimeal.http;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import jdhe.iyibank.com.iyimeal.app.MyAppLication;
import jdhe.iyibank.com.iyimeal.app.Urls;
import jdhe.iyibank.com.iyimeal.util.CommonUtils;
import jdhe.iyibank.com.iyimeal.util.ToastUtils;


/**
 * http异步请求
 */
public class Http {


    /**
     * get请求
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public static void get(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        if(CommonUtils.isNetWorkConnected(context)){
            MyAppLication.client.get(getAbsoluteUrl(url), params, responseHandler);
        }else {
            ToastUtils.makeTextWifi(context);
        }
    }

    /**
     * post请求
     *
     * @param url
     * @param params
     * @param responseHandler
     */
    public static void post(Context context, String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        if(CommonUtils.isNetWorkConnected(context)){
            MyAppLication.client.post(getAbsoluteUrl(url), params, responseHandler);
        }else {
            ToastUtils.makeTextWifi(context);
        }
    }

    /**
     * 下载文件
     *
     * @param url
     * @param responseHandler
     */
    public static void get(Context context, String url, AsyncHttpResponseHandler responseHandler) {
        if(CommonUtils.isNetWorkConnected(context)){
            MyAppLication.client.get(getAbsoluteUrl(url), responseHandler);
        }else {
            ToastUtils.makeTextWifi(context);
        }
    }

    public static void downloadImage(Context context, String url, BinaryHttpResponseHandler responseHandler) {
        if(CommonUtils.isNetWorkConnected(context)){
            MyAppLication.client.get(url, responseHandler);
        }else {
            ToastUtils.makeTextWifi(context);
        }
    }
    /**
     * 取消网络请求。
     * @param context
     * @param mayInterruptIfRunning
     */
    public static void cancelRequests(Context context, boolean mayInterruptIfRunning) {
        MyAppLication.client.cancelRequests(context, mayInterruptIfRunning);
    }

    /**
     * 拼接url
     *
     * @param relativeUrl
     * @return
     */
    private static String getAbsoluteUrl(String relativeUrl) {
        return Urls.BASE_URL + relativeUrl;
    }

}
