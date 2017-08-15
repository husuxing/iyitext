package jdhe.iyibank.com.iyimeal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;
import jdhe.iyibank.com.iyimeal.adapter.ExpandGridViewAdapter;
import jdhe.iyibank.com.iyimeal.adapter.PayWayListExpandAdapter;
import jdhe.iyibank.com.iyimeal.adapter.ProductRenewGridAdapter;
import jdhe.iyibank.com.iyimeal.costomview.ExpandGridView;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;
import jdhe.iyibank.com.iyimeal.entity.FilterGridData;

/**
 * Created by Administrator on 2017/8/4.
 */

public class ProductRenewFragment extends Fragment {
    private TextView mBaseTitle, nulltv;
    private LinearLayout title_sc, mBaseBack, titmean, areasetll, tableset, shiftset, hand_password_reset, shopday, SmartPoint, permission, passwodreset;
    ImageView logo;
    private ExpandGridView expandGridView;
    private ProductRenewGridAdapter productRenewGridAdapter;
    private ArrayList<FilterGridData> filterGridDataListzhifu;
    private ExpandListView expandListView;
    private PayWayListExpandAdapter payWayListExpandAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.product_renew_fragmentlayout, container, false);
        initview(v);
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


    private void initview(View v) {
        expandListView = (ExpandListView) v.findViewById(R.id.expandlsitView);
        payWayListExpandAdapter = new PayWayListExpandAdapter(getActivity(),"ProductRenewFragment");
        expandListView.setAdapter(payWayListExpandAdapter);



        hand_password_reset = (LinearLayout) v.findViewById(R.id.hand_password_reset);

        passwodreset = (LinearLayout) v.findViewById(R.id.passwodreset);
        permission = (LinearLayout) v.findViewById(R.id.permission);
        SmartPoint = (LinearLayout) v.findViewById(R.id.SmartPoint);
        shopday = (LinearLayout) v.findViewById(R.id.shopday);
        shiftset = (LinearLayout) v.findViewById(R.id.shiftset);
        areasetll = (LinearLayout) v.findViewById(R.id.areasetll);
        tableset = (LinearLayout) v.findViewById(R.id.tableset);
        mBaseBack = (LinearLayout) v.findViewById(R.id.title_back);
        title_sc = (LinearLayout) v.findViewById(R.id.title_sc);
        titmean = (LinearLayout) v.findViewById(R.id.titmean);
        mBaseTitle = (TextView) v.findViewById(R.id.title_content);
        logo = (ImageView) v.findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        titmean.setVisibility(View.VISIBLE);
        mBaseBack.setVisibility(View.GONE);
        mBaseTitle.setText("续费");
        titmean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.homeActivity.setLayout();
            }
        });

        expandGridView = (ExpandGridView) v.findViewById(R.id.grid_filter);

        filterGridDataListzhifu = new ArrayList<>();
        FilterGridData filterGridData0 = new FilterGridData("1个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData0);
        FilterGridData filterGridData1 = new FilterGridData("2个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData1);
        FilterGridData filterGridData2 = new FilterGridData("3个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData2);
        FilterGridData filterGridData3 = new FilterGridData("4个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData3);
        FilterGridData filterGridData4 = new FilterGridData("5个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData4);
        FilterGridData filterGridData5 = new FilterGridData("6个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData5);
        FilterGridData filterGridData6 = new FilterGridData("7个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData6);
        FilterGridData filterGridData7 = new FilterGridData("8个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData7);
        FilterGridData filterGridData8 = new FilterGridData("9个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData8);
        FilterGridData filterGridData9 = new FilterGridData("10个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData9);
        FilterGridData filterGridData10 = new FilterGridData("11个月", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData10);
        FilterGridData filterGridData11 = new FilterGridData("1年", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData11);
        FilterGridData filterGridData12 = new FilterGridData("2年", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData12);
        FilterGridData filterGridData13 = new FilterGridData("3年", true, false, 0, 1, "0");
        filterGridDataListzhifu.add(filterGridData13);


        productRenewGridAdapter = new ProductRenewGridAdapter(getActivity(), filterGridDataListzhifu, 0);
        expandGridView.setAdapter(productRenewGridAdapter);
//        expandGridViewAdapter = new ExpandGridViewAdapter(getActivity());
//        expandGridView.setAdapter(expandGridViewAdapter);
    }


}

