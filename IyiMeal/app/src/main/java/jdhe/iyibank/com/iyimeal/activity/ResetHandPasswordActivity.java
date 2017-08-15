package jdhe.iyibank.com.iyimeal.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.handpassword.LocusPassWordView;

public class ResetHandPasswordActivity extends BaseActivity {
    private Context context;
    private LocusPassWordView lpwv;
    private String password;
    private boolean needverify = true;
    private TextView forgetpw, tishi;
    private boolean isTurePassword, isTureTwoPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_hand_password);
        initTitle();
        initview();
    }

    private void initview() {
        tishi = (TextView) findViewById(R.id.tishi);
        logo.setVisibility(View.GONE);
        context = this;
        lpwv = (LocusPassWordView) this.findViewById(R.id.mLocusPassWordView);
        lpwv.setOnCompleteListener(new LocusPassWordView.OnCompleteListener() {
            @Override
            public void onComplete(String mPassword) {

                lpwv.clearPassword();
            }
        });
        forgetpw = (TextView) findViewById(R.id.forgetpwtv);
        forgetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ResetHandPasswordActivity.this, ForgetPasswordActivity.class).putExtra("who", "hand"));
            }
        });
        View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}

