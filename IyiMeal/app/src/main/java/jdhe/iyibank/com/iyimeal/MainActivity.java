package jdhe.iyibank.com.iyimeal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.orhanobut.logger.Logger;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import jdhe.iyibank.com.iyimeal.activity.AreaAetActivity;
import jdhe.iyibank.com.iyimeal.activity.RegisterActivity;
import jdhe.iyibank.com.iyimeal.activity.Reset_PasswordActivity;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.entity.QueryIDCard;
import jdhe.iyibank.com.iyimeal.entity.QueryQQ;
import jdhe.iyibank.com.iyimeal.entity.QueryTel;
import jdhe.iyibank.com.iyimeal.network.Network;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements IWXRenderListener {
    TextView regist, resetpw;
    EditText phone, password;
    Button loginBt;

    WXSDKInstance mWXSDKInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //weex
//        mWXSDKInstance = new WXSDKInstance(this);
//        mWXSDKInstance.registerRenderListener(this);
//        /**
//         * WXSample 可以替换成自定义的字符串，针对埋点有效。
//         * template 是.we transform 后的 js文件。
//         * option 可以为空，或者通过option传入 js需要的参数。例如bundle js的地址等。
//         * jsonInitData 可以为空。
//         * width 为-1 默认全屏，可以自己定制。
//         * height =-1 默认全屏，可以自己定制。
//         */
//        mWXSDKInstance.render("MyApplication", WXFileUtils.loadFileContent("myweex.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
//


        intview();
    }

    private void intview() {
        regist = (TextView) findViewById(R.id.regist);
        resetpw = (TextView) findViewById(R.id.forgetpassword);
        phone = (EditText) findViewById(R.id.iphone);
        password = (EditText) findViewById(R.id.password);
        loginBt = (Button) findViewById(R.id.loginBt);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        resetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Reset_PasswordActivity.class));
            }
        });
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rx();
                startActivity(new Intent(MainActivity.this, AreaAetActivity.class).putExtra("who", "MainActivity"));
//                startActivity(new Intent(MainActivity.this, HandPasswordActivity.class));
//                finish();
            }
        });
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.iphone, R.id.password};
        return ids;
    }


    public static final String QUERY_IDCARD_KEY = "220f329adbf071c81b4b3011e0439cad";
    public static final String QUERY_QQ_KEY = "27100330526ba52940ecc6846436c398";
    public static final String QUERY_TEL_KEY = "576f995fdbc2c0e9db5fa785da34efd6";

    public static final int QUERY_TEL = 1;
    public static final int QUERY_QQ = 2;
    public static final int QUERY_IDCARD = 3;

    private Subscription mSubscription;

    public int mQueryStyle = 1;

    Observer<Object> mObserver = new Observer<Object>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object object) {
            try {
                switch (mQueryStyle) {
                    case QUERY_IDCARD:
                        QueryIDCard queryIDCard = (QueryIDCard) object;
                        showResult(queryIDCard.getResult().toString());
                        break;
                    case QUERY_QQ:
                        QueryQQ queryQQ = (QueryQQ) object;
                        showResult(queryQQ.getResult().getData().toString());
                        break;
                    case QUERY_TEL:
                        QueryTel queryTel = (QueryTel) object;
                        showResult(queryTel.getResult().toString());
                        break;
                    default:
                        break;
                }
            } catch (Exception exception) {
                showResult(null);
            }
        }
    };

    private void rx() {
        mSubscription = Network.getQueryTelApi()
                .getTelInfo(QUERY_TEL_KEY, phone.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }


    private void showResult(String s) {
        Logger.e("查询结果：" + s);
        if (TextUtils.isEmpty(s)) {
            regist.setText("查询结果有误，请检查输入号码是否有误！");
        } else {
            regist.setText(s);
        }
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (mWXSDKInstance != null) {
//            mWXSDKInstance.onActivityResume();
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (mWXSDKInstance != null) {
//            mWXSDKInstance.onActivityPause();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (mWXSDKInstance != null) {
//            mWXSDKInstance.onActivityStop();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mWXSDKInstance != null) {
//            mWXSDKInstance.onActivityDestroy();
//        }
//    }
//
    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
//        setContentView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }
}
