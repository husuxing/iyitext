package jdhe.iyibank.com.iyimeal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;


import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.Cx_itemAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class CancellationCashierSearchActivity extends BaseActivity  implements BGARefreshLayout.BGARefreshLayoutDelegate {


    private Cx_itemAdapter cx_itemAdapter;
    private ListView listView;
    private BGARefreshLayout mRefreshLayout;
    private LinearLayout title_back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancellation_search_cashier);
        initview();
    }

    private void initview() {
        title_back1= (LinearLayout) findViewById(R.id.title_back1);
        title_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.listview);
        cx_itemAdapter = new Cx_itemAdapter(this);
        listView.setAdapter(cx_itemAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.serach };
        return ids;
    }
}
