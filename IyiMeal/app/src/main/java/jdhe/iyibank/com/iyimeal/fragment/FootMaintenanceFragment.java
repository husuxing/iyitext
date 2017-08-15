package jdhe.iyibank.com.iyimeal.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
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
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.adapter.AddProductListAdapter;
import jdhe.iyibank.com.iyimeal.adapter.FootFragmentAdapter;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;

/**
 * Created by Administrator on 2017/8/2.
 */

public class FootMaintenanceFragment extends Fragment {
    public BGARefreshLayout mRefreshLayout;
    private TextView TvFooterView,cleartv;
    private LinearLayout layout;
    ExpandListView expandListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.footfragmentlayout, container, false);
        intview(v);

        return v;
    }

    private void intview(View v) {
        expandListView= (ExpandListView) v.findViewById(R.id.lv_pay);
        cleartv= (TextView) v.findViewById(R.id.cleartv);
        FootFragmentAdapter expandListViewPayAdapter = new FootFragmentAdapter(getActivity());
        expandListView.setAdapter(expandListViewPayAdapter);
        cleartv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), DialogActivity.class)
                        .putExtra("title", "提示").putExtra("msg", "你正在清空“家常菜”所有分类菜品")
                        .putExtra("isbutton", true).putExtra("isedit", "1")
                );
            }
        });
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onResume() {

        super.onResume();
    }



}
