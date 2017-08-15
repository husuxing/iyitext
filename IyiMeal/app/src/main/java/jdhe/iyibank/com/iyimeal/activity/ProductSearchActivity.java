package jdhe.iyibank.com.iyimeal.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.AddProductListAdapter;
import jdhe.iyibank.com.iyimeal.adapter.ProductListAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class ProductSearchActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{

    private ListView listView;
    private AddProductListAdapter addProductListAdapter;
    private BGARefreshLayout mRefreshLayout;

    private LinearLayout title_back1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_search);
//        initTitle();
//        logo.setVisibility(View.GONE);
//        mBaseTitle.setText("注册");
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
        addProductListAdapter = new AddProductListAdapter(this);
        listView.setAdapter(addProductListAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
//        nulltv= (TextView) v.findViewById(R.id.nulltv);
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
        int[] ids = {R.id.search };
        return ids;
    }
}
