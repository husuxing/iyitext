package jdhe.iyibank.com.iyimeal.activity;

import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.fragment.AdminPermissionFragment;
import jdhe.iyibank.com.iyimeal.fragment.BaseMessageFrament;
import jdhe.iyibank.com.iyimeal.fragment.CxFragment;
import jdhe.iyibank.com.iyimeal.fragment.DcFragment;
import jdhe.iyibank.com.iyimeal.fragment.HistoryFragment;
import jdhe.iyibank.com.iyimeal.fragment.MemberManagementFragment;
import jdhe.iyibank.com.iyimeal.fragment.FoodMain_Fragment;
import jdhe.iyibank.com.iyimeal.fragment.ProductRenewFragment;
import jdhe.iyibank.com.iyimeal.fragment.ShiftTableFragment;

import static jdhe.iyibank.com.iyimeal.R.string.count;


public class HomeActivity extends BaseActivity {
    private List<TextView> mImageList;
    private TextView basemessage, dcsy, cxsy, footmaintenance, history, productxf;
    private TextView adminqx, tuichu;
    private TextView jbbb;
    private TextView mmfTv;
    private TextView jia;
    DcFragment dcFragment;
    CxFragment cxFragment;
    FoodMain_Fragment footFragment;
    HistoryFragment historyFragment;
    BaseMessageFrament baseMessageFrament;
    ShiftTableFragment shiftTableFragment;
    MemberManagementFragment memberManagementFragment;
    AdminPermissionFragment adminPermissionFragment;
    ProductRenewFragment productRenewFragment;
    public static HomeActivity homeActivity;
    private Map<Integer, Fragment> fragmentMap;
    private FragmentTransaction transaction;
    private DrawerLayout drawerLayout;
    RelativeLayout main_left_drawer_layout, yiny;
    private ActionBarDrawerToggle drawerbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intiview();
        homeActivity = this;

    }

    public void setLayout() {
        drawerLayout.openDrawer(main_left_drawer_layout);
    }

    private void intiview() {
        yiny = (RelativeLayout) findViewById(R.id.yiny);
        tuichu = (TextView) findViewById(R.id.tuichu);
        productxf = (TextView) findViewById(R.id.productxf);
        history = (TextView) findViewById(R.id.history);
        basemessage = (TextView) findViewById(R.id.basemessage);
        adminqx = (TextView) findViewById(R.id.adminqx);
        dcsy = (TextView) findViewById(R.id.dcsy);
        dcsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(0);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        cxsy = (TextView) findViewById(R.id.cxsy);
        cxsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(1);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        jbbb = (TextView) findViewById(R.id.jbbb);
        jbbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(2);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        mmfTv = (TextView) findViewById(R.id.mmfTv);
        mmfTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(3);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(4);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);

            }
        });
        footmaintenance = (TextView) findViewById(R.id.footmaintenance);
        footmaintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(5);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        basemessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(7);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        adminqx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(6);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        productxf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCurrentTab(8);
                drawerLayout.closeDrawers();
                setTextbg((TextView) view);
            }
        });
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);

        //设置菜单内容之外其他区域的背景色
        drawerLayout.setScrimColor(Color.TRANSPARENT);

        //左边菜单
        main_left_drawer_layout = (RelativeLayout) findViewById(R.id.main_left_drawer_layout);
        //右边菜单
//        main_right_drawer_layout = (RelativeLayout) findViewById(R.id.main_right_drawer_layout);
        initEvent();

//
//        data_list = new ArrayList<>();
//        data_list.add("jijdij");
//        data_list.add("jijdij");
//        data_list.add("jijdij");
//        data_list.add("jijdij");
//
//        linearLayout = (LinearLayout) findViewById(R.id.recyclerll);
//        spinner = (Spinner) findViewById(R.id.spinner);
//        tab_main1 = (TextView) findViewById(R.id.tab_main1);
//        tab_main2 = (TextView) findViewById(R.id.tab_main2);

//        jia = (TextView) findViewById(R.id.jia);
//        tab_main1.setSelected(true);
//        tab_main2.setSelected(true);
//        tab_main3.setSelected(true);
//        tab_main4.setSelected(true);
//        jia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                linearLayout.setVisibility(View.VISIBLE);
//            }
//        });
//        mScrollView = (ScrollView) findViewById(
//                R.id.scrollableLayout);
//        mScrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
//        mScrollView.setFocusable(true);
//        mScrollView.setFocusableInTouchMode(true);
//        mScrollView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.requestFocusFromTouch();
//                return false;
//            }
//        });
//        expandGridView = (ExpandGridView) findViewById(R.id.expandGridView);
//        expandGridViewAdapter = new ExpandGridViewAdapter(this);
//        expandGridView.setAdapter(expandGridViewAdapter);
//        mRefreshLayout = (BGARefreshLayout) findViewById(
//                R.id.refresh);
//        mRefreshLayout.setDelegate(this);
//        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
//        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
//        setRecyclerView_one();
//
//        //适配器
//        arr_adapter = new ArrayAdapter<String>(HomeActivity.this, R.layout.simple_spinner_layout_product, data_list);
//        //设置样式
//        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //加载适配器
//        spinner.setAdapter(arr_adapter);
//
//        spinner = (Spinner) findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//
//                //拿到被选择项的值
////                productfenleiS = (String) spinner.getSelectedItem();
////                for (SearchCmmodityList searchCmmodityList : searchCmmodityLists) {
////
////                    if (productfenleiS.equals(searchCmmodityList.getName())) {
////                        productfenleiSID = searchCmmodityList.getTypeID() + "";
////                    }
////                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

//
        fragmentMap = new HashMap<Integer, Fragment>();
        dcFragment = new DcFragment();
        cxFragment = new CxFragment(this);
        shiftTableFragment = new ShiftTableFragment();
        footFragment = new FoodMain_Fragment();
        baseMessageFrament = new BaseMessageFrament();
        memberManagementFragment = new MemberManagementFragment();
        adminPermissionFragment = new AdminPermissionFragment();
        historyFragment = new HistoryFragment();
        productRenewFragment = new ProductRenewFragment();
        mImageList = new ArrayList<TextView>();
//        mImageList.add(tab_main1);
        mImageList.add(dcsy);
        mImageList.add(cxsy);
        mImageList.add(jbbb);
        mImageList.add(mmfTv);
        mImageList.add(history);
        mImageList.add(footmaintenance);
        mImageList.add(adminqx);
        mImageList.add(basemessage);
        fragmentMap.put(0, dcFragment);
        fragmentMap.put(1, cxFragment);
        fragmentMap.put(2, shiftTableFragment);
        fragmentMap.put(3, memberManagementFragment);
        fragmentMap.put(4, historyFragment);
        fragmentMap.put(5, footFragment);//菜品维护
        fragmentMap.put(6, adminPermissionFragment);
        fragmentMap.put(7, baseMessageFrament);//
        fragmentMap.put(8, productRenewFragment);//
        setCurrentTab(0);
    }

//    private void setRecyclerView_one() {
//        recyclerView_one = (RecyclerView) this.findViewById(R.id.recyclerView_one);
//        //设置固定大小
//        recyclerView_one.setHasFixedSize(true);
//        //创建线性布局
//        mLayoutManager = new LinearLayoutManager(this);
//        //方向设置
//        mLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
//        //给RecyclerView设置布局管理器
//        recyclerView_one.setLayoutManager(mLayoutManager);
//
//
//        ViewGroup.LayoutParams layoutParams;
//        layoutParams = linearLayout.getLayoutParams();
//        layoutParams.width = imageid.length * 98;
//        linearLayout.setLayoutParams(layoutParams);
//        //创建适配器，并且设置
//        mAdapter = new TestRecyclerAdapter(this);
//        recyclerView_one.setAdapter(mAdapter);
//
//    }


    private void setCurrentTab(int index) {
//        for (int i = 0; i < mImageList.size(); i++) {
//            if (i == index) {
//                mImageList.get(i).setSelected(true);
//            } else {
//                mImageList.get(i).setSelected(false);
//            }
//        }
        transaction = getSupportFragmentManager().beginTransaction();
        hideFragments(transaction);
        Fragment fragment = fragmentMap.get(index);
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl_main, fragment);
        }
        transaction.show(fragment);
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        for (int i = 0; i < fragmentMap.size(); i++) {
            if (fragmentMap.get(i) != null) {
                transaction.hide(fragmentMap.get(i));
            }
        }
    }

    //设置开关监听
    private void initEvent() {
        drawerbar = new ActionBarDrawerToggle(this, drawerLayout, R.mipmap.ic_launcher, R.string.app_name, R.string.app_name) {
            //菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                yiny.setVisibility(View.VISIBLE);
            }

            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                yiny.setVisibility(View.GONE);
            }
        };

        drawerLayout.setDrawerListener(drawerbar);
    }

    public void setTextbg(TextView textView) {
        if(textView == dcsy){
            dcsy.setTextColor(ContextCompat.getColor(this,R.color.white2));
            dcsy.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            dcsy.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            dcsy.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == cxsy){
            cxsy.setTextColor(ContextCompat.getColor(this,R.color.white2));
            cxsy.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            cxsy.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            cxsy.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == jbbb){
            jbbb.setTextColor(ContextCompat.getColor(this,R.color.white2));
            jbbb.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            jbbb.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            jbbb.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == mmfTv){
            mmfTv.setTextColor(ContextCompat.getColor(this,R.color.white2));
            mmfTv.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            mmfTv.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            mmfTv.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == history){
            history.setTextColor(ContextCompat.getColor(this,R.color.white2));
            history.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            history.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            history.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == footmaintenance){
            footmaintenance.setTextColor(ContextCompat.getColor(this,R.color.white2));
            footmaintenance.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            footmaintenance.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            footmaintenance.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == basemessage){
            basemessage.setTextColor(ContextCompat.getColor(this,R.color.white2));
            basemessage.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            basemessage.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            basemessage.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == adminqx){
            adminqx.setTextColor(ContextCompat.getColor(this,R.color.white2));
            adminqx.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            adminqx.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            adminqx.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(textView == productxf){
            productxf.setTextColor(ContextCompat.getColor(this,R.color.white2));
            productxf.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_blue67));
        }else {
            productxf.setBackground(ContextCompat.getDrawable(this,R.drawable.brand_whit));
            productxf.setTextColor(ContextCompat.getColor(this,R.color.black));
        }

    }
    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.serchEdittext};
        return ids;
    }
}
