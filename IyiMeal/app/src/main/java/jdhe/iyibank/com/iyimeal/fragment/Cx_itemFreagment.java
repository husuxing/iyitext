package jdhe.iyibank.com.iyimeal.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.Cx_itemAdapter;
import jdhe.iyibank.com.iyimeal.adapter.ProductListAdapter;

/**
 * Created by Administrator on 2017/8/3.
 */

public class Cx_itemFreagment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private int type;
    private int page = 1;
    private int states;
    public String status;
    private boolean isHelper;
    public static Cx_itemFreagment instance;
    private TextView mTextNull;
    public static boolean isChange = false;
    private ProgressDialog pd;
    private StringBuffer sb;
    private ListView listView;
    public Cx_itemAdapter cx_itemAdapter, productListAdapter1, productListAdapter2;
    public BGARefreshLayout mRefreshLayout;
    private int pageData = 1, pagenum = 20;
    private TextView TvFooterView,nulltv;
    private LinearLayout layout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cx_item_fragment, container, false);
//        type = getArguments().getInt("type");
        listView = (ListView) v.findViewById(R.id.listview);
//        switch (type) {
//            case 0:
//                status = "0";
//                break;
//            case 1:
//                status = "1";
//                break;
//            case 2:
//                status = "2";
//                break;
//        }
        cx_itemAdapter = new Cx_itemAdapter(getActivity());
        listView.setAdapter(cx_itemAdapter);
        mRefreshLayout = (BGARefreshLayout) v.findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
