package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class AddConsumerActivity extends BaseActivity {
    private Button comfirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_consumer);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("添加会员");
        initview();
    }

    private void initview() {
        comfirmBtn= (Button) findViewById(R.id.comfirmBtn);
        comfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddConsumerActivity.this, DialogActivity.class)
                        .putExtra("title", "添加会员信息").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("isaddconsumer", "0")
                );
            }
        });
    }
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.kanub, R.id.name, R.id.phone, R.id.birthday, R.id.adress, R.id.bz};
        return ids;
    }
}
