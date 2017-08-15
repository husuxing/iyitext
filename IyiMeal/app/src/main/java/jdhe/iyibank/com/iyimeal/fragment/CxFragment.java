package jdhe.iyibank.com.iyimeal.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.CancellationCashierSearchActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;

/**
 * Created by Administrator on 2017/5/8.
 */

public class CxFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate, ViewPager.OnPageChangeListener {
    private int type;
    private int page = 1;
    private int states;
    public String status;
    private boolean isHelper;
    public static DcFragment instance;
    private TextView mTextNull;
    public static boolean isChange = false;
    private ProgressDialog pd;
    private StringBuffer sb;
    private ListView listView;
    //    public ProductListAdapter productListAdapter0, productListAdapter1, productListAdapter2;
    public BGARefreshLayout mRefreshLayout;
    private int pageData = 1, pagenum = 20;
    private TextView mBaseTitle, nulltv;
    private LinearLayout title_sc,mBaseBack,titmean;
    private static String[] TITLE;
    private ViewPager viewPager;
    private TabPageIndicator indicator;
    private CancellAdapter adapter;
    HomeActivity homeActivity;
    ImageView logo;
    public CxFragment(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_cancellation_cashier, container, false);
        initview(v);
        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static DcFragment getInstance() {
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
        return false;
    }

    private void initview(View v) {
        mBaseBack = (LinearLayout) v.findViewById(R.id.title_back);
        title_sc = (LinearLayout)v. findViewById(R.id.title_sc);
        titmean= (LinearLayout)v. findViewById(R.id.titmean);
        mBaseTitle = (TextView) v.findViewById(R.id.title_content);
        logo = (ImageView) v.findViewById(R.id.logo);
        logo.setVisibility(View.GONE);
        titmean.setVisibility(View.VISIBLE);
        mBaseBack.setVisibility(View.GONE);
        title_sc.setVisibility(View.VISIBLE);
        mBaseTitle.setText("撤销收银");
        TITLE = new String[]{"今日账单", "今日已撤销账单"
        };
        viewPager = (ViewPager) v.findViewById(R.id.vp_order_manage);
        indicator = (TabPageIndicator) v.findViewById(R.id.order_manage_indicator);
        adapter = new CancellAdapter(
                getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        indicator.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        title_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), CancellationCashierSearchActivity.class));
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class CancellAdapter extends FragmentPagerAdapter {
        public CancellAdapter(FragmentManager fm) {
            super(fm);
        }

        public Cx_itemFreagment all1, all0, all2;
        public Cx_itemFreagment allall;
        private List<Fragment> mTabContents = new ArrayList<Fragment>();
//        @Override
//        public Fragment getItem(int id) {
//
//            Bundle bundle = new Bundle();
//            switch (id) {
//                case 0:
//                    all0 = new ProductFragment();
//                    bundle.putInt("type", 0);
//                    all0.setArguments(bundle);
////                    mTabContents.add(all0);
//                    mTabContents.add(allall);
//                    return all0;
//                case 1:
//                    all1 = new ProductFragment();
//                    bundle.putInt("type", 1);
//                    all1.setArguments(bundle);
//                    mTabContents.add(allall);
////                    mTabContents.add(all1);
//                    return all1;
//                case 2:
//                    all2 = new ProductFragment();
//                    bundle.putInt("type", 2);
////                    mTabContents.add(all2);
//                    all2.setArguments(bundle);
//                    mTabContents.add(allall);
//                    return all2;
//            }
//            return null;

        @Override
        public Fragment getItem(int position) {
            allall = new Cx_itemFreagment();
            Bundle bundle = new Bundle();
            for (int i = 0; i < TITLE.length; i++) {
                bundle.putInt("type", position);
                allall.setArguments(bundle);
                return allall;
            }
//                switch (position) {
//                    case 0:
//                        bundle.putInt("type", 1);
//                        allall.setArguments(bundle);
//                        return allall;
//                    case 1:
//                        bundle.putInt("type", 2);
//                        allall.setArguments(bundle);
//                        return allall;
//                }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length].toUpperCase();
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            Fragment fragment = (Fragment)super.instantiateItem(container,position);
//            getSupportFragmentManager().beginTransaction().show(fragment).commit();
//            return fragment;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            Fragment fragment = mTabContents.get(position);
//            getSupportFragmentManager().beginTransaction().hide(fragment).commit();
//        }
    }
}
