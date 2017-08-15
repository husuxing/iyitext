package jdhe.iyibank.com.iyimeal.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddConsumerActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;
import jdhe.iyibank.com.iyimeal.activity.MemberManagementSearchActivity;
import jdhe.iyibank.com.iyimeal.adapter.HistrotyAdapter;
import jdhe.iyibank.com.iyimeal.adapter.MemberManagementAdapter;
import jdhe.iyibank.com.iyimeal.costomview.widget.OptionsPopupWindow;
import jdhe.iyibank.com.iyimeal.costomview.widget.TimePopupWindow;
import jdhe.iyibank.com.iyimeal.util.ToastUtils;

/**
 * Created by Administrator on 2017/8/3.
 */

public class HistoryFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private ListView listView;
    public BGARefreshLayout mRefreshLayout;
    private TextView mBaseTitle,nulltv,start_tv,end_tv,shift_name;
    private LinearLayout title_sc,mBaseBack,titmean;
    ImageView logo;
    private HistrotyAdapter histrotyAdapter;
    private RelativeLayout rl_startdata,rl_enddata,choose_shift;
    private TimePopupWindow pwTime;
    private OptionsPopupWindow optionsPopupWindow;
    private int nub = 0;
    private ArrayList<String> options1Items = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.historyfragmentlayout, container, false);
        initview(v);
        return v;
    }

    private void initview(View v) {
        shift_name= (TextView) v.findViewById(R.id.shift_name);
        start_tv= (TextView) v.findViewById(R.id.start_tv);
        end_tv= (TextView) v.findViewById(R.id.end_tv);
        // 时间选择器
        pwTime = new TimePopupWindow(getActivity(), TimePopupWindow.Type.YEAR_MONTH_DAY);
        // 时间选择后回调
        pwTime.setOnTimeSelectListener(new TimePopupWindow.OnTimeSelectListener() {

            @Override
            public void onTimeSelect(Date date) {
                Date date1 = new Date(System.currentTimeMillis());
                switch (nub) {
                    case 1:

                        compareDate(date, date1);
                        start_tv.setText(getTime(date));
                        break;
                    case 2:
                        compareDate(date, date1);
                        end_tv.setText(getTime(date));
                        break;
                }
            }
        });

        optionsPopupWindow = new OptionsPopupWindow(getActivity());

        // 选项1
        options1Items.add("早班");
        options1Items.add("晚班");
        options1Items.add("全天班");
        // 三级联动效果
        optionsPopupWindow.setPicker(options1Items);//, options2Items, options3Items, true);
        // 设置选择的三级单位
//		pwOptions.setLabels("省", "市", "区");
        // 设置默认选中的三级项目
        optionsPopupWindow.setSelectOptions(0);//, 0, 0);
        // 监听确定选择按钮
        optionsPopupWindow
                .setOnoptionsSelectListener(new OptionsPopupWindow.OnOptionsSelectListener() {

                    @Override
                    public void onOptionsSelect(int options1, int option2,
                                                int options3) {
						String tx = options1Items.get(options1);
                        shift_name.setText(tx);
                    }
                });
        choose_shift= (RelativeLayout) v.findViewById(R.id.choose_shift);

        rl_startdata= (RelativeLayout) v.findViewById(R.id.rl_startdata);
        rl_enddata= (RelativeLayout) v.findViewById(R.id.rl_enddata);
        rl_startdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nub=1;
                pwTime.showAtLocation(rl_enddata, Gravity.BOTTOM, 0, 0, new Date());
            }
        });
        rl_enddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nub=2;
                pwTime.showAtLocation(rl_enddata, Gravity.BOTTOM, 0, 0, new Date());
            }
        });

        choose_shift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionsPopupWindow.showAtLocation(rl_enddata, Gravity.BOTTOM, 0, 0);
            }
        });

        titmean= (LinearLayout)v. findViewById(R.id.titmean);
        mBaseBack = (LinearLayout) v.findViewById(R.id.title_back);
        title_sc = (LinearLayout)v. findViewById(R.id.title_sc);
        mBaseTitle = (TextView) v.findViewById(R.id.title_content);
        logo = (ImageView) v.findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        mBaseBack.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
        titmean.setVisibility(View.VISIBLE);
        mBaseTitle.setText("历史账单");

        listView = (ListView) v.findViewById(R.id.listview);
        histrotyAdapter = new HistrotyAdapter(getActivity());
        listView.setAdapter(histrotyAdapter);
        mRefreshLayout = (BGARefreshLayout) v.findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
//        comfirmBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().startActivity(new Intent(getActivity(), AddConsumerActivity.class));
//            }
//        });
//        title_sc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().startActivity(new Intent(getActivity(), MemberManagementSearchActivity.class));
//            }
//        });
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

    public int compareDate(Date dt1, Date dt2) {
        if (dt1.getTime() > dt2.getTime()) {
            //	System.out.println("dt1 在dt2前");
            ToastUtils.makeText(getActivity(), "请选择今天之前的时间");
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            //	System.out.println("dt1在dt2后");
            return -1;
        } else {//相等
            return 0;
        }
    }
    public static String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}

