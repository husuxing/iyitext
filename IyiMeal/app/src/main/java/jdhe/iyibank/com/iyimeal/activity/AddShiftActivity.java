package jdhe.iyibank.com.iyimeal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class AddShiftActivity extends BaseActivity {
    private ToggleButton toggleButton;
    private TextView datatv;
    private String who;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shift);
        initTitle();
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
        title_wen.setVisibility(View.VISIBLE);
        who=getIntent().getExtras().getString("who","");
        if("ShiftSettingsActivity".equals(who)){
            mBaseTitle.setText("添加班次");
        }else {
            mBaseTitle.setText("编辑班次");
        }
        initview();
    }

    private void initview() {
        toggleButton= (ToggleButton) findViewById(R.id.toggleButton);
        datatv= (TextView) findViewById(R.id.datatv);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {//
                    datatv.setText("今日");
                } else {
                    datatv.setText("次日");
                }
            }
        });
    }
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.shift_name };
        return ids;
    }
}
