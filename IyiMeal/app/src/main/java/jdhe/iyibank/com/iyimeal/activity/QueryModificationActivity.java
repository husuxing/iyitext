package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.fragment.ProductFragment;
import jdhe.iyibank.com.iyimeal.util.ToastUtils;

public class QueryModificationActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private String[] TITLE;
    private ViewPager viewPager;
    private TabPageIndicator indicator;
    private ProductInfoTabAdapter adapter;
    private ImageView addproduct;
    private TextView sureall,resetall;
    private String who;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_modification);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("已选菜品");
        initview();
    }

    private void initview() {
        who=getIntent().getExtras().getString("who","");
        TITLE = new String[]{"001号桌", "001号桌",
                "001号桌", "001号桌", "001号桌",
                "001号桌", "001号桌", "001号桌",
                "001号桌"};
        resetall= (TextView) findViewById(R.id.resetall);
        sureall= (TextView) findViewById(R.id.sureall);
        addproduct = (ImageView) findViewById(R.id.addproduct);
        viewPager = (ViewPager) findViewById(R.id.vp_order_manage);
        indicator = (TabPageIndicator) findViewById(R.id.order_manage_indicator);
        adapter = new ProductInfoTabAdapter(
                getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);
        indicator.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        if("tab_main2".equals(who)){
            sureall.setVisibility(View.GONE);
            addproduct.setVisibility(View.VISIBLE);
            resetall.setVisibility(View.VISIBLE);
        }else if("tab_main4".equals(who)){
            sureall.setVisibility(View.VISIBLE);
            addproduct.setVisibility(View.GONE);
            resetall.setVisibility(View.GONE);
        }
        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QueryModificationActivity.this, AddProductActivity.class).putExtra("who","QueryModificationActivity"));
            }
        });
        sureall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QueryModificationActivity.this,CustomerBillActivity.class));
            }
        });
        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.makeText(QueryModificationActivity.this,"提交成功");

//                startActivity(new Intent(QueryModificationActivity.this,CustomerBillActivity.class));
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

    class ProductInfoTabAdapter extends FragmentPagerAdapter {
        public ProductInfoTabAdapter(FragmentManager fm) {
            super(fm);
        }

        public ProductFragment all1, all0, all2;
        public ProductFragment allall;
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
            allall = new ProductFragment();
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
