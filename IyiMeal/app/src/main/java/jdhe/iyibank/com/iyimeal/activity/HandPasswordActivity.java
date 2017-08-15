package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.handpassword.LocusPassWordView;

public class HandPasswordActivity extends BaseActivity {

    private LocusPassWordView lpwv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_password);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("手势密码");
        initview();
    }

    private void initview() {
        lpwv = (LocusPassWordView) this.findViewById(R.id.mLocusPassWordView);
        lpwv.setOnCompleteListener(new LocusPassWordView.OnCompleteListener() {
            @Override
            public void onComplete(String mPassword) {
                startActivity(new Intent(HandPasswordActivity.this,HomeActivity.class));
                finish();
            }
        });
        lpwv.clearPassword();
    }
}
