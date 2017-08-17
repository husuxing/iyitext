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
import jdhe.iyibank.com.iyimeal.entity.FoodListItemData;
import jdhe.iyibank.com.iyimeal.fragment.AddProductFrament;
import jdhe.iyibank.com.iyimeal.fragment.FootMaintenanceFragment;

public class FoodMaintenanceActivity extends BaseActivity {
    ViewPager fragmentViewPager;
    ListView leftListView;
    private ArrayList<FoodListItemData> leftlist;
    private LeftAdapter leftAdapter;
    private ArrayList<Fragment> fragmentlist;
    private FootMaintenanceFragment fragment1;
    private FootMaintenanceFragment fragment2;
    TextView resetall, sureall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_maintenance);
        initTitle();
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
        mBaseTitle.setText("菜品维护");
        initview();
    }

    private void initview() {
            title_wen.setVisibility(View.VISIBLE);
            title_wen.setText("完成");
            title_wen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(FoodMaintenanceActivity.this,HomeActivity.class));
                }
            });
        resetall = (TextView) findViewById(R.id.resetall);
        sureall = (TextView) findViewById(R.id.sureall);
        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodMaintenanceActivity.this, DialogActivity.class)
                        .putExtra("title", "添加分类").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("isedit", "1").putExtra("addcalss", "0")
                );
            }
        });
        sureall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FoodMaintenanceActivity.this, AddFoodActivity.class));
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

        leftAdapter = new LeftAdapter(this,leftlist);
        leftListView.setAdapter(leftAdapter);
        leftListView.setDividerHeight(0);
        // listview点击事件
        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
//                leftAdapter.setSelectedPosition(position);
                leftAdapter.notifyDataSetInvalidated();
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
        fragment1 = new FootMaintenanceFragment();//
        fragment2 = new FootMaintenanceFragment();//
        fragmentlist.add(fragment1);
        fragmentlist.add(fragment2);
        fragmentViewPager.setAdapter(new FragmentAdapter(
                getSupportFragmentManager(), fragmentlist, this));
        fragmentViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
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
            View view1 = LayoutInflater.from(activity).inflate(R.layout.footmain_itemlayout, null, false);
            delete = (ImageView) view1.findViewById(R.id.delete);
            heng = view1.findViewById(R.id.heng);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.startActivity(new Intent(activity, DialogActivity.class)
                            .putExtra("title", "提示").putExtra("msg", "你正在删除“家常菜”分类，该分类菜品也一并删除")
                            .putExtra("isbutton", true).putExtra("isedit", "1")
                    );
                }
            });
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

