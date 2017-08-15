package jdhe.iyibank.com.iyimeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.activity.HandPasswordActivity;
import jdhe.iyibank.com.iyimeal.activity.RegisterActivity;
import jdhe.iyibank.com.iyimeal.activity.Reset_PasswordActivity;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class MainActivity extends BaseActivity {
    TextView regist, resetpw;
    EditText phone, password;
    Button loginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intview();
    }

    private void intview() {
        regist = (TextView) findViewById(R.id.regist);
        resetpw = (TextView) findViewById(R.id.forgetpassword);
        phone = (EditText) findViewById(R.id.iphone);
        password = (EditText) findViewById(R.id.password);
        loginBt= (Button) findViewById(R.id.loginBt);

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
                startActivity(new Intent(MainActivity.this, HandPasswordActivity.class));
//                finish();
            }
        });
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.iphone, R.id.password};
        return ids;
    }
}
