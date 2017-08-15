package jdhe.iyibank.com.iyimeal.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.viewpagerindicator.TabPageIndicator;

import org.json.JSONObject;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddConsumerActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;
import jdhe.iyibank.com.iyimeal.activity.MemberManagementSearchActivity;
import jdhe.iyibank.com.iyimeal.adapter.Cx_itemAdapter;
import jdhe.iyibank.com.iyimeal.adapter.MemberManagementAdapter;

/**
 * Created by Administrator on 2017/5/8.
 */

public class MemberManagementFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    private ListView listView;
    public BGARefreshLayout mRefreshLayout;
    private TextView mBaseTitle,nulltv;
    private LinearLayout title_sc,mBaseBack,titmean;
    ImageView logo;
    private MemberManagementAdapter memberManagementAdapter;
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
        mBaseTitle.setText("会员列表");

        listView = (ListView) v.findViewById(R.id.listview);
        memberManagementAdapter = new MemberManagementAdapter(getActivity());
        listView.setAdapter(memberManagementAdapter);
        mRefreshLayout = (BGARefreshLayout) v.findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        comfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), AddConsumerActivity.class));
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
