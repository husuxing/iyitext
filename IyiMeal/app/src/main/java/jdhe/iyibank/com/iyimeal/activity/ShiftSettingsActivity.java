package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.ShiftSettingsAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class ShiftSettingsActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{

    private ListView listView;
    private ShiftSettingsAdapter shiftSettingsAdapter;
    private BGARefreshLayout mRefreshLayout;
    private Button comfirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_settings);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("班次设置");
        initview();
    }

    private void initview() {
        comfirmBtn= (Button) findViewById(R.id.comfirmBtn);
        listView = (ListView) findViewById(R.id.listview);
        shiftSettingsAdapter = new ShiftSettingsAdapter(this);
        listView.setAdapter(shiftSettingsAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        comfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShiftSettingsActivity.this,AddShiftActivity.class).putExtra("who","ShiftSettingsActivity"));
            }
        });



    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }
}

