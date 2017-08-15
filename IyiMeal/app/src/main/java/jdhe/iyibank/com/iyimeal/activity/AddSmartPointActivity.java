package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.Receivables_items_Adapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;

public class AddSmartPointActivity extends BaseActivity {

    private Receivables_items_Adapter receivables_items_adapter;
    private ExpandListView expandListView;
    private TextView sureall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_smart_point);
        initTitle();
        logo.setVisibility(View.GONE);
        title_wen.setVisibility(View.VISIBLE);
        mBaseTitle.setText("添加智能点单");
        initview();
    }

    private void initview() {
        sureall= (TextView) findViewById(R.id.sureall);
        expandListView= (ExpandListView) findViewById(R.id.listview);
        receivables_items_adapter = new Receivables_items_Adapter(this);
        expandListView.setAdapter(receivables_items_adapter);
        sureall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddSmartPointActivity.this,AddProductActivity.class).putExtra("who","AddSmartPointActivity"));
            }
        });
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.setmeal_name ,R.id.number,R.id.setmeal_price};
        return ids;
    }
}
