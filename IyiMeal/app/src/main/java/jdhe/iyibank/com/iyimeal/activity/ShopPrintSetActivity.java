package jdhe.iyibank.com.iyimeal.activity;

import android.os.Bundle;
import android.view.View;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class ShopPrintSetActivity extends BaseActivity {

//            SmartPoint
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_point_set);
        initTitle();
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
        title_wen.setVisibility(View.VISIBLE);
        mBaseTitle.setText("商户打印设置");
        initview();
    }

    private void initview() {

    }
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.api,R.id.shopnub};
        return ids;
    }
}
