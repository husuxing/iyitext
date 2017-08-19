package jdhe.iyibank.com.iyimeal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.FragmentAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.ProductPopupWindow;
import jdhe.iyibank.com.iyimeal.entity.FoodListItemData;
import jdhe.iyibank.com.iyimeal.fragment.AddProductFrament;
import jdhe.iyibank.com.iyimeal.fragment.FoodMain_Fragment;

public class AddProductActivity extends BaseActivity implements View.OnClickListener{

    private ViewPager fragmentViewPager;
    private ListView leftListView;
    private List<FoodListItemData> leftlist;
    private LeftAdapter leftAdapter;
    private ArrayList<Fragment> fragmentlist;
    private AddProductFrament fragment1,fragment2;
    private LinearLayout caidanll,zuotaill;
    private ProductPopupWindow mPopWindow;
    String who;
    private TextView sureall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        initTitle();
        who=getIntent().getExtras().getString("who","");
        logo.setVisibility(View.GONE);
        initview();
    }

    private void initview() {
        sureall= (TextView) findViewById(R.id.sureall);
        sureall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddProductActivity.this,QueryModificationActivity.class).putExtra("who","AddProductActivity"));
            }
        });
        zuotaill= (LinearLayout) findViewById(R.id.zuotaill);
        if("QueryModificationActivity".equals(who)||"DialogActivity".equals(who)||"ExpandGridViewAdapter".equals(who)){
            title_sc.setVisibility(View.VISIBLE);
            mBaseTitle.setText("开始点菜");
        }else if("AddSmartPointActivity".equals(who)){
            mBaseTitle.setText("编辑菜品列表");
            zuotaill.setVisibility(View.GONE);
        }
        caidanll= (LinearLayout) findViewById(R.id.caidanll);
        caidanll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindow = new ProductPopupWindow(AddProductActivity.this, AddProductActivity.this, "");//"CAMERA_onclick"
                mPopWindow.showAsDropDown(caidanll,5,5,Gravity.BOTTOM);
//                mPopWindow.showAtLocation(view, Gravity.BOTTOM
//                        , 100, 100); // 设置layout在PopupWindow中显示的位置| Gravity.CENTER_HORIZONTAL

//                startActivity(new Intent(AddProductActivity.this,ProductSearchActivity.class));
            }
        });

        title_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddProductActivity.this,ProductSearchActivity.class));
            }
        });
        fragmentViewPager = (ViewPager) findViewById(R.id.fragmentViewPager);
        leftListView = (ListView) findViewById(R.id.leftListView);
        fragmentViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        fragmentViewPager.requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        fragmentViewPager.requestDisallowInterceptTouchEvent(false);
                    default:
                        break;
                }
                return true;
            }
        });
        initDatas();// left初始化。
        initDatasViewPager();
    }

    public void initDatas() {
        leftlist=new ArrayList<FoodListItemData>();
        FoodListItemData foodListItemData1 = new FoodListItemData("川菜", "1");
        leftlist.add(foodListItemData1);
        for (int i = 0; i < 5; i++) {

            FoodListItemData foodListItemData = new FoodListItemData("川菜", "0");
            leftlist.add(foodListItemData);
        }

        leftAdapter = new LeftAdapter(this, leftlist);
        leftListView.setAdapter(leftAdapter);
        leftListView.setDividerHeight(0);
        // listview点击事件
        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
//                leftAdapter.setSelectedPosition(position);
//                leftAdapter.notifyDataSetInvalidated();
                leftAdapter.setViewHeng(position);
                if (position % 2 == 1) {
                    fragmentViewPager.setCurrentItem(1);
                } else {
                    fragmentViewPager.setCurrentItem(0);
                }
            }
        });
    }

    public void initDatasViewPager() {
        fragmentlist = new ArrayList<Fragment>();
        fragment1 = new AddProductFrament();//
        fragment2 = new AddProductFrament();//
        fragmentlist.add(fragment1);
        fragmentlist.add(fragment2);
        fragmentViewPager.setAdapter(new FragmentAdapter(
                getSupportFragmentManager(), fragmentlist, this));
        fragmentViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    @Override
    public void onClick(View view) {

    }

    // set OnPageChangeListener in inner class
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        /**
         * 当点击不同id的ViewPage的时候才触发
         */
        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        }

    }

    static class LeftAdapter extends BaseAdapter {
        private Activity activity;
        private ImageView delete;
        private View heng;
        private List<FoodListItemData> list;

        LeftAdapter(Activity activity, List<FoodListItemData> list) {
            this.activity = activity;
            this.list = list;
        }
//        LeftAdapter(Activity activity) {
//            this.activity = activity;
//        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }


        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = LayoutInflater.from(activity).inflate(R.layout.addproductleftlistview_item, null, false);
            heng = view1.findViewById(R.id.heng);
            if ("1".equals(list.get(i).getIsHneg())) {
                heng.setVisibility(View.VISIBLE);
            }else {
                heng.setVisibility(View.GONE);
            }
            return view1;
        }

        public void setViewHeng(int position) {
            for(FoodListItemData foodListItemData:list){
                foodListItemData.setIsHneg("0");
            }
            list.get(position).setIsHneg("1");
            notifyDataSetChanged();
        }
    }
}
