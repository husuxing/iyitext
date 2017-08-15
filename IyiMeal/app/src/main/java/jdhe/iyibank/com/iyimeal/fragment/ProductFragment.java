package jdhe.iyibank.com.iyimeal.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.ProductListAdapter;

/**
 * Created by Administrator on 2017/5/8.
 */

public class ProductFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private int type;
    private int page = 1;
    private int states;
    public String status;
    private boolean isHelper;
    public static ProductFragment instance;
    private TextView mTextNull;
    public static boolean isChange = false;
    private ProgressDialog pd;
    private StringBuffer sb;
    private ListView listView;
    public ProductListAdapter productListAdapter0, productListAdapter1, productListAdapter2;
    public BGARefreshLayout mRefreshLayout;
    private int pageData = 1, pagenum = 20;
    private TextView TvFooterView,nulltv;
    private LinearLayout layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.productitemlayout, container, false);
        instance = this;
        type = getArguments().getInt("type");
        listView = (ListView) v.findViewById(R.id.listview);
        switch (type) {
            case 0:
                status = "0";
                break;
            case 1:
                status = "1";
                break;
            case 2:
                status = "2";
                break;
        }
        productListAdapter0 = new ProductListAdapter(getActivity());
        listView.setAdapter(productListAdapter0);
        mRefreshLayout = (BGARefreshLayout) v.findViewById(
                R.id.refresh);
//        nulltv= (TextView) v.findViewById(R.id.nulltv);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static ProductFragment getInstance() {
        return instance;
    }

    @Override
    public void onResume() {

        super.onResume();
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return true;
    }

}
