package jdhe.iyibank.com.iyimeal.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.SectionsPagerAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.fragment.Classification_of_dishesFragment;
import jdhe.iyibank.com.iyimeal.fragment.DishesFrament;

public class Recycle_binActivity extends BaseActivity {

    private ArrayList<Fragment> mFragmentList;
    private List<String> mTitleStrings;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recycle_bin);
        super.onCreate(savedInstanceState);

        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("菜品回收站");
        initview();
    }

    private void initview() {
        mFragmentList = new ArrayList<>();
        mTitleStrings = Arrays.asList("菜品分类", "菜品");
        for (String fragmentname : mTitleStrings) {
            switch (fragmentname) {
                case "菜品分类":
                    mFragmentList.add(Classification_of_dishesFragment.newInstance
                            ());
                    break;
                case "菜品":
                    mFragmentList.add(DishesFrament.newInstance
                            ());
                    break;
//                case "本周":
//                    mFragmentList.add(Classification_of_dishesFragment.newInstance
//                            ());
//                    break;
//                case "下周":
//                    mFragmentList.add(Classification_of_dishesFragment.newInstance
//                            ());
//                    break;
//                case "本月":
//                    mFragmentList.add(Classification_of_dishesFragment.newInstance
//                            ());
//                    break;
//                case "今年":
//                    mFragmentList.add(Classification_of_dishesFragment.newInstance
//                            ());
//                    break;
                default:

                    break;
            }
        }
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), this, mFragmentList, mTitleStrings);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


}
