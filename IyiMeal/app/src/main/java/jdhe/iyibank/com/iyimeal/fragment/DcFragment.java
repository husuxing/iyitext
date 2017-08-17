package jdhe.iyibank.com.iyimeal.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.activity.HomeActivity;
import jdhe.iyibank.com.iyimeal.activity.QueryModificationActivity;
import jdhe.iyibank.com.iyimeal.activity.CustomerBillActivity;
import jdhe.iyibank.com.iyimeal.activity.TurnTableActivity;
import jdhe.iyibank.com.iyimeal.adapter.ExpandGridViewAdapter;
import jdhe.iyibank.com.iyimeal.costomview.ExpandGridView;
import jdhe.iyibank.com.iyimeal.entity.TableGridViewData;
import jdhe.iyibank.com.iyimeal.util.handpassword.MathUtil;

/**
 * Created by Administrator on 2017/5/8.
 */

public class DcFragment extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {
    public static DcFragment instance;
    public ExpandGridViewAdapter expandGridViewAdapter;//, productListAdapter1, productListAdapter2;
    public BGARefreshLayout mRefreshLayout;
    private int pageData = 1, pagenum = 20;
    private TextView TvFooterView, nulltv;
    private LinearLayout layout;
    private ScrollView mScrollView;
    private ExpandGridView expandGridView;
    private ArrayList<String> data_list;
    public LinearLayout linearLayout, lianll, title_back1;
    private Spinner spinner;
    private TextView tab_main1, tab_main2, tab_main3, tab_main4,tishici;
    private RecyclerView recyclerView_one;
    private ArrayAdapter<String> arr_adapter;
    private LinearLayoutManager mLayoutManager;
    static int[] imageid = {R.mipmap.zt,  R.mipmap.qxlt, R.mipmap.zjlt, R.mipmap.qxsy,};//R.mipmap.ft,
    static String[] imageName = {"转台", "追加连台", "取消连台", "取消所有"};//"分台",
    private TestRecyclerAdapter mAdapter;
    private LinearLayout title_sc, chouti,bghui;
    private RelativeLayout scRl, title;
    private Button comfirmBt, cancleBt;
    private ImageView jia, title_menu1;
    private boolean jiab;
    private int dataPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dcfragemntlayout, container, false);
        intview(v);
        return v;
    }

    public void setlianllState() {
//        tishici.setText(text);
//        lianll.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        bghui.setVisibility(View.GONE);
        Drawable rightDrawable = ContextCompat.getDrawable(getActivity(), R.drawable.jii);
        jia.setImageDrawable(rightDrawable);
    }

    public void setTab_main(boolean main1, boolean main2, boolean main3, boolean main4, boolean jiab) {
        tab_main1.setSelected(main1);
        tab_main2.setSelected(main2);
        tab_main3.setSelected(main3);
        tab_main4.setSelected(main4);
        this.jiab = jiab;
    }
    public void setDataPosition(int position) {
        dataPosition=position;
    }

    private void intview(View view) {

        data_list = new ArrayList<>();
        data_list.add("全部");
        data_list.add("二楼包间");
        data_list.add("大厅卡座");
        title_menu1 = (ImageView) view.findViewById(R.id.title_menu1);
        tishici= (TextView) view.findViewById(R.id.tishici);
        cancleBt = (Button) view.findViewById(R.id.cancle);
        comfirmBt = (Button) view.findViewById(R.id.comfirmBt);
        bghui = (LinearLayout) view.findViewById(R.id.bghui);
        title_back1 = (LinearLayout) view.findViewById(R.id.title_back1);
        chouti = (LinearLayout) view.findViewById(R.id.chouti);
        title_sc = (LinearLayout) view.findViewById(R.id.title_sc);
        title = (RelativeLayout) view.findViewById(R.id.title);
        scRl = (RelativeLayout) view.findViewById(R.id.scRl);
        linearLayout = (LinearLayout) view.findViewById(R.id.recyclerll);
        lianll = (LinearLayout) view.findViewById(R.id.lianll);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        tab_main1 = (TextView) view.findViewById(R.id.tab_main1);
        tab_main2 = (TextView) view.findViewById(R.id.tab_main2);
        tab_main3 = (TextView) view.findViewById(R.id.tab_main3);
        tab_main4 = (TextView) view.findViewById(R.id.tab_main4);
        jia = (ImageView) view.findViewById(R.id.jia);
        comfirmBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), DialogActivity.class)
                        .putExtra("title", "注意").putExtra("msg", "你正在将" + "<font color=#5459c3>天下第一座</font>转移到" + "<font color=#5459c3>一号座</font>")
                        .putExtra("isbutton", true).putExtra("isedit", "1")
                );
            }
        });

        cancleBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lianll.setVisibility(View.GONE);
            }
        });
        title_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scRl.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
            }
        });
        title_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scRl.setVisibility(View.GONE);
                title.setVisibility(View.VISIBLE);
            }
        });
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jiab) {
                    if (linearLayout.getVisibility() == View.VISIBLE) {
                        linearLayout.setVisibility(View.GONE);
                        Drawable rightDrawable = ContextCompat.getDrawable(getActivity(), R.drawable.jii);
                        jia.setImageDrawable(rightDrawable);
                        bghui.setVisibility(View.GONE);
//                    rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
//                    jia.setCompoundDrawables(null, null, rightDrawable, null);
                    } else {
                        linearLayout.setVisibility(View.VISIBLE);
                        Drawable rightDrawable = ContextCompat.getDrawable(getActivity(), R.drawable.jia);
                        jia.setImageDrawable(rightDrawable);
                        bghui.setVisibility(View.VISIBLE);
//                    rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
//                    jia.setCompoundDrawables(null, null, rightDrawable, null);
                    }
                }
            }
        });
        tab_main1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab_main1.isSelected()) {
                    startActivity(new Intent(getContext(), DialogActivity.class)
                            .putExtra("title", "请输入就餐人数").putExtra("msg", "")
                            .putExtra("isbutton", true).putExtra("isedit", "0").putExtra("who_tab", "tab_main1").putExtra("dataPosition",dataPosition)
                    );
                }

            }
        });
        tab_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab_main2.isSelected()) {
                    startActivity(new Intent(getContext(), QueryModificationActivity.class).putExtra("who","tab_main2")
                    );
                }

            }
        });
        tab_main3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab_main3.isSelected()) {
                    startActivity(new Intent(getContext(), DialogActivity.class)
                            .putExtra("title", "拼台：就餐人数").putExtra("msg", "")
                            .putExtra("isbutton", true).putExtra("isedit", "0").putExtra("who_tab", "tab_main3").putExtra("dataPosition",dataPosition)
                    );
                }
            }
        });
        tab_main4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tab_main4.isSelected()) {
                    startActivity(new Intent(getContext(), QueryModificationActivity.class).putExtra("who","tab_main4")
                    );
                }

            }
        });
        mScrollView = (ScrollView) view.findViewById(
                R.id.scrollableLayout);
        mScrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        mScrollView.setFocusable(true);
        mScrollView.setFocusableInTouchMode(true);
        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.requestFocusFromTouch();
                return false;
            }
        });
        List<TableGridViewData> tableGridViewDatas = new ArrayList<TableGridViewData>();
        for (int i = 0; i < 40; i++) {
            TableGridViewData tableGridViewData = new TableGridViewData("", "", false, new Random().nextInt(3), R.mipmap.dc_0);
            tableGridViewDatas.add(tableGridViewData);
        }


        expandGridView = (ExpandGridView) view.findViewById(R.id.expandGridView);
        expandGridViewAdapter = new ExpandGridViewAdapter(getActivity(), tableGridViewDatas, this);
        expandGridView.setAdapter(expandGridViewAdapter);
        mRefreshLayout = (BGARefreshLayout) view.findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        recyclerView_one = (RecyclerView) view.findViewById(R.id.recyclerView_one);
        setRecyclerView_one();

        //适配器
        arr_adapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_layout_product, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
//        spinner.setDropDownHorizontalOffset(100);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                //拿到被选择项的值
//                productfenleiS = (String) spinner.getSelectedItem();
//                for (SearchCmmodityList searchCmmodityList : searchCmmodityLists) {
//
//                    if (productfenleiS.equals(searchCmmodityList.getName())) {
//                        productfenleiSID = searchCmmodityList.getTypeID() + "";
//                    }
//                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        chouti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.homeActivity.setLayout();
            }
        });
        title_menu1.setOnClickListener(new View.OnClickListener() {
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

    private void setRecyclerView_one() {

        //设置固定大小
        recyclerView_one.setHasFixedSize(true);
        //创建线性布局
        mLayoutManager = new LinearLayoutManager(getActivity());
        //方向设置
        mLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        //给RecyclerView设置布局管理器
        recyclerView_one.setLayoutManager(mLayoutManager);


        ViewGroup.LayoutParams layoutParams;
        layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = imageid.length * 115;
        linearLayout.setLayoutParams(layoutParams);
        //创建适配器，并且设置
        mAdapter = new TestRecyclerAdapter(getActivity(), this);
        recyclerView_one.setAdapter(mAdapter);

    }

    static class TestRecyclerAdapter extends RecyclerView.Adapter<TestRecyclerAdapter.ViewHolder> {
        private LayoutInflater mInflater;


        //        private List<PayTypeList> payTypeLists;
        private Activity context;
        DcFragment dcFragment;

        public TestRecyclerAdapter(Activity context, DcFragment dc) {
            this.mInflater = LayoutInflater.from(context);
            this.context = context;
            this.dcFragment = dc;
        }

        /**
         * item显示类型
         *
         * @param parent
         * @param viewType
         * @return
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.recyclerviewlayout, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        /**
         * 数据的绑定显示
         *
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.item_tv.setImageResource(imageid[position]);
            holder.item_tx.setText(imageName[position]);

            holder.item_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    dcFragment.setlianllState("请选择转移桌台");
                    context.startActivity(new Intent(context,TurnTableActivity.class).putExtra("string","请选择转移桌台"));
                }
            });
        }

        @Override
        public int getItemCount() {
            return imageid.length;
        }

        //自定义的ViewHolder，持有每个Item的的所有界面元素
        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView item_tv;
            public TextView item_tx;

            public ViewHolder(View view) {
                super(view);
                item_tv = (ImageView) view.findViewById(R.id.gridview_imageview);
                item_tx = (TextView) view.findViewById(R.id.gridview_textview);

            }
        }
    }

}
