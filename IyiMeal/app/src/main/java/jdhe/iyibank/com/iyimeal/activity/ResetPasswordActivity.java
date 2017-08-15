package jdhe.iyibank.com.iyimeal.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.util.ToastUtils;
import jdhe.iyibank.com.iyimeal.util.handpassword.StringUtil;

public class ResetPasswordActivity extends BaseActivity {

    private TextView resetall;
    private EditText oldPasswprd, newPasswrod, comfirmPassword;
    private String oldPasswprdS, newPasswrodS, comfirmPasswordS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText(getResources().getString(R.string.modify_password));
        intview();
    }

    private void intview() {
        resetall = (TextView) findViewById(R.id.resetall);
        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldPasswprdS = oldPasswprd.getText().toString().trim();
                newPasswrodS = newPasswrod.getText().toString().trim();
                comfirmPasswordS = comfirmPassword.getText().toString().trim();

                if (StringUtil.isEmpty(oldPasswprdS)) {
                    ToastUtils.makeText(ResetPasswordActivity.this,getResources().getString(R.string.oldpassword_notnull));
                    return;
                }

                if (StringUtil.isEmpty(newPasswrodS)) {
                    ToastUtils.makeText(ResetPasswordActivity.this,getResources().getString(R.string.newpassword_notnull));
                    return;
                }

                if (StringUtil.isEmpty(comfirmPasswordS)) {
                    ToastUtils.makeText(ResetPasswordActivity.this,getResources().getString(R.string.confirmation_passwordnotnull));
                    return;
                }
                if (!comfirmPasswordS.equals(newPasswrodS)) {
                    ToastUtils.makeText(ResetPasswordActivity.this,getResources().getString(R.string.newpassword_confirmation_password_not_consistent));
                    return;
                }
//                modifyPassWord(oldPasswprdS,newPasswrodS,comfirmPasswordS);
            }
        });
        oldPasswprd = (EditText) findViewById(R.id.oldPasswprd);
        newPasswrod = (EditText) findViewById(R.id.newPassword);
        comfirmPassword = (EditText) findViewById(R.id.comfirmPassword);
    }
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.oldPasswprd,R.id.newPassword,R.id.comfirmPassword};
        return ids;
    }


}
