package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

public class AddTableActivity extends BaseActivity {
String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);
        initTitle();
        title=getIntent().getStringExtra("who");
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
        title_wen.setVisibility(View.VISIBLE);
        if(!"".equals(title)){
            mBaseTitle.setText("编辑桌台");
        }else {
            mBaseTitle.setText("添加桌台");
        }

        initview();
    }

    private void initview() {
        title_wen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BatchAddTableBean batchAddTableBean=new BatchAddTableBean("3","3","3","3","3","3");
                startActivity(new Intent(AddTableActivity.this,BatchTablelistActivity.class).putExtra("Bean", batchAddTableBean));
                finish();
            }
        });
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.account ,R.id.table,R.id.table_abbreviation,R.id.areaet,R.id.down_nub ,R.id.room_charge,R.id.mealfee};
        return ids;
    }
}
