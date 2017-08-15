package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.PayWayListExpandAdapter;
import jdhe.iyibank.com.iyimeal.adapter.ReceivablesAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;

public class Receivables_ConsumerActivity extends BaseActivity {
    private RelativeLayout giverl, youhuij, zhek, moling;
    private ExpandListView expandListView;
    private PayWayListExpandAdapter payWayListExpandAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receivables__consumer);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("收款");
        initview();
    }

    private void initview() {
        expandListView = (ExpandListView) findViewById(R.id.expandlsitView);
        payWayListExpandAdapter = new PayWayListExpandAdapter(this,"Receivables_ConsumerActivity");
        expandListView.setAdapter(payWayListExpandAdapter);
        giverl = (RelativeLayout) findViewById(R.id.giverl);
        giverl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Receivables_ConsumerActivity.this, DialogActivity.class)
                        .putExtra("title", "赠送菜品").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("iddialog_scrolllist", "0")
                );
            }
        });
        youhuij = (RelativeLayout) findViewById(R.id.youhuij);
        youhuij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Receivables_ConsumerActivity.this, DialogActivity.class)
                        .putExtra("title", "使用优惠券").putExtra("msg", "单位：元")
                        .putExtra("isbutton", true).putExtra("isyouhuijll", "0")
                );
            }
        });
        zhek = (RelativeLayout) findViewById(R.id.zhek);
        zhek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Receivables_ConsumerActivity.this, DialogActivity.class)
                        .putExtra("title", "请选择折扣").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("iszhekourl", "0")
                );
            }
        });
        moling = (RelativeLayout) findViewById(R.id.moling);
        moling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Receivables_ConsumerActivity.this, DialogActivity.class)
                        .putExtra("title", "抹零").putExtra("msg", "单位：元")
                        .putExtra("isbutton", true).putExtra("isyouhuijll", "0")
                );
            }
        });
    }
}
