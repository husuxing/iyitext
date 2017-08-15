package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class MemberManagementModificationActivity extends BaseActivity {
    TextView setMoney, lookconsumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_management_modification);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("会员详情");
        initview();
    }

    private void initview() {
        setMoney = (TextView) findViewById(R.id.setMoney);
        lookconsumer = (TextView) findViewById(R.id.lookconsumer);
        setMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberManagementModificationActivity.this, DialogActivity.class)
                        .putExtra("title", "充值").putExtra("msg", "金额单位：元")
                        .putExtra("isbutton", true).putExtra("issetMoneyll", "0")
                );
            }
        });
        lookconsumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MemberManagementModificationActivity.this, ConsumerDetailsActivity.class)
                );
            }
        });
    }
}
