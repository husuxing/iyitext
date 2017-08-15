package jdhe.iyibank.com.iyimeal.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;

/**
 * Created by Administrator on 2017/8/3.
 */

public class ShiftTableFragment extends Fragment {
    public BGARefreshLayout mRefreshLayout;
    private int pageData = 1, pagenum = 20;
    private TextView mBaseTitle, nulltv;
    private LinearLayout title_sc,mBaseBack,titmean;
    ImageView logo;
    private Button comfirmBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.shifttablefragmentlayout, container, false);
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
        comfirmBtn= (Button) v.findViewById(R.id.comfirmBtn);
        mBaseBack = (LinearLayout) v.findViewById(R.id.title_back);
        title_sc = (LinearLayout)v. findViewById(R.id.title_sc);
        titmean= (LinearLayout)v. findViewById(R.id.titmean);
        mBaseTitle = (TextView) v.findViewById(R.id.title_content);
        logo = (ImageView) v.findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        titmean.setVisibility(View.VISIBLE);
        mBaseBack.setVisibility(View.GONE);
        mBaseTitle.setText("交班报表");
        titmean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.homeActivity.setLayout();
            }
        });
        comfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getContext(), DialogActivity.class)
                        .putExtra("title", "提示").putExtra("msg", "现在就交班吗")
                        .putExtra("isbutton", true).putExtra("isedit", "1")
                );
            }
        });
    }


}

