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
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AreaAetActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;
import jdhe.iyibank.com.iyimeal.activity.PermissionViewActivity;
import jdhe.iyibank.com.iyimeal.activity.ResetHandPasswordActivity;
import jdhe.iyibank.com.iyimeal.activity.ResetPasswordActivity;
import jdhe.iyibank.com.iyimeal.activity.ShiftSettingsActivity;
import jdhe.iyibank.com.iyimeal.activity.ShopPrintSetActivity;
import jdhe.iyibank.com.iyimeal.activity.SmartPointSetActivity;
import jdhe.iyibank.com.iyimeal.activity.TableSetActivity;

/**
 * Created by Administrator on 2017/8/3.
 */

public class BaseMessageFrament extends Fragment{
    public BGARefreshLayout mRefreshLayout;
    private int pageData = 1, pagenum = 20;
    private TextView mBaseTitle, nulltv;
    private LinearLayout title_sc,mBaseBack,titmean,areasetll,tableset,shiftset
            ,hand_password_reset,shopday,SmartPoint,permission,passwodreset;
    ImageView logo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.basemessage_framentlayout, container, false);
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
        hand_password_reset= (LinearLayout) v.findViewById(R.id.hand_password_reset);

        passwodreset= (LinearLayout) v.findViewById(R.id.passwodreset);
        permission= (LinearLayout) v.findViewById(R.id.permission);
        SmartPoint= (LinearLayout) v.findViewById(R.id.SmartPoint);
        shopday= (LinearLayout) v.findViewById(R.id.shopday);
        shiftset= (LinearLayout) v.findViewById(R.id.shiftset);
        areasetll= (LinearLayout) v.findViewById(R.id.areasetll);
        tableset= (LinearLayout) v.findViewById(R.id.tableset);
        mBaseBack = (LinearLayout) v.findViewById(R.id.title_back);
        title_sc = (LinearLayout)v. findViewById(R.id.title_sc);
        titmean= (LinearLayout)v. findViewById(R.id.titmean);
        mBaseTitle = (TextView) v.findViewById(R.id.title_content);
        logo = (ImageView) v.findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        titmean.setVisibility(View.VISIBLE);
        mBaseBack.setVisibility(View.GONE);
        mBaseTitle.setText("基本信息");
        titmean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.homeActivity.setLayout();
            }
        });
        areasetll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AreaAetActivity.class).putExtra("who","BaseMessageFrament"));
            }
        });
        tableset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TableSetActivity.class).putExtra("who","BaseMessageFrament"));
            }
        });
        shiftset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShiftSettingsActivity.class));
            }
        });
        shopday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ShopPrintSetActivity.class));
            }
        });
        SmartPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SmartPointSetActivity.class));
            }
        });
        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PermissionViewActivity.class));
            }
        });
        passwodreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResetPasswordActivity.class));
            }
        });

        hand_password_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ResetHandPasswordActivity.class));
            }
        });

    }


}
