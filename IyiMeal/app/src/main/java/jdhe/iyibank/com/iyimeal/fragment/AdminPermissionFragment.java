package jdhe.iyibank.com.iyimeal.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddAdminPermissionActivity;
import jdhe.iyibank.com.iyimeal.activity.AddConsumerActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;
import jdhe.iyibank.com.iyimeal.activity.MemberManagementSearchActivity;
import jdhe.iyibank.com.iyimeal.adapter.AdminPermissionAdapter;
import jdhe.iyibank.com.iyimeal.costomview.XCFlowLayout;

/**
 * Created by Administrator on 2017/8/4.
 */

public class AdminPermissionFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private ListView listView;
    public BGARefreshLayout mRefreshLayout;
    private TextView mBaseTitle,nulltv;
    private LinearLayout title_sc,mBaseBack,titmean;
    ImageView logo;
    private AdminPermissionAdapter adminPermissionAdapter;
    private Button comfirmBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.member_management_fragmentlayout, container, false);
        initview(v);
        return v;
    }

    private void initview(View v) {
        comfirmBtn= (Button) v.findViewById(R.id.comfirmBtn);
        titmean= (LinearLayout)v. findViewById(R.id.titmean);
        mBaseBack = (LinearLayout) v.findViewById(R.id.title_back);
        title_sc = (LinearLayout)v. findViewById(R.id.title_sc);
        mBaseTitle = (TextView) v.findViewById(R.id.title_content);
        logo = (ImageView) v.findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        mBaseBack.setVisibility(View.GONE);
        title_sc.setVisibility(View.VISIBLE);
        titmean.setVisibility(View.VISIBLE);
        mBaseTitle.setText("权限管理");

        listView = (ListView) v.findViewById(R.id.listview);
        adminPermissionAdapter = new AdminPermissionAdapter(getActivity());
        listView.setAdapter(adminPermissionAdapter);
        mRefreshLayout = (BGARefreshLayout) v.findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        comfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), AddAdminPermissionActivity.class));
            }
        });
        title_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), MemberManagementSearchActivity.class));
            }
        });
        titmean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.homeActivity.setLayout();
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

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }

}
