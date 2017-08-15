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
import jdhe.iyibank.com.iyimeal.adapter.ConsumerDetailsAdapter;
import jdhe.iyibank.com.iyimeal.adapter.MemberManagementAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class ConsumerDetailsActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{

    private ListView listView;
    private ConsumerDetailsAdapter cx_itemAdapter;
    private BGARefreshLayout mRefreshLayout;
    private TextView setMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer_details);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("消费记录");
        initview();
    }

    private void initview() {
        setMoney= (TextView) findViewById(R.id.setMoney);
        listView = (ListView) findViewById(R.id.listview);
        cx_itemAdapter = new ConsumerDetailsAdapter(this);
        listView.setAdapter(cx_itemAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        setMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConsumerDetailsActivity.this, DialogActivity.class)
                        .putExtra("title", "充值").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("issetMoneyll", "0")
                );
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
