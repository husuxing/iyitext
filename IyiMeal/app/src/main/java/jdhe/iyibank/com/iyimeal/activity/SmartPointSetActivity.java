package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.SmartPointSetAdapter;
import jdhe.iyibank.com.iyimeal.adapter.TableSetAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class SmartPointSetActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{

    private ListView listView;
    private SmartPointSetAdapter smartPointSetAdapter;
    private BGARefreshLayout mRefreshLayout;
    private TextView resetall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_point_set2);
        initTitle();
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
//        title_wen.setVisibility(View.VISIBLE);
        mBaseTitle.setText("智能点单设置");
        initview();
    }

    private void initview() {
        resetall= (TextView) findViewById(R.id.resetall);
        listView = (ListView) findViewById(R.id.listview);
        smartPointSetAdapter = new SmartPointSetAdapter(this);
        listView.setAdapter(smartPointSetAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SmartPointSetActivity.this,AddSmartPointActivity.class));
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

