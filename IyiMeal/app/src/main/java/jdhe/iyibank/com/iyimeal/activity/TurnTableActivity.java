package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.TurnTableExpandGridViewAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.ExpandGridView;
import jdhe.iyibank.com.iyimeal.entity.TableGridViewData;

public class TurnTableActivity extends BaseActivity {
    public TurnTableExpandGridViewAdapter turnTableExpandGridViewAdapter;//, productListAdapter1, productListAdapter2;
    public BGARefreshLayout mRefreshLayout;
    private ScrollView mScrollView;
    private ExpandGridView expandGridView;
    private ArrayList<String> data_list;
    public LinearLayout linearLayout, lianll, title_back1;
    private Spinner spinner;
    private TextView tab_main1, tab_main2, tab_main3, tab_main4, tishici;
    private ArrayAdapter<String> arr_adapter;
    private LinearLayout title_sc, chouti;
    private RelativeLayout scRl, title;
    private Button comfirmBt, cancleBt;
    private ImageView jia, title_menu1;
    private String tisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_table);
        intview();
    }

    private void intview() {
        tisi = getIntent().getExtras().getString("string", "");
        data_list = new ArrayList<>();
        data_list.add("全部");
        data_list.add("二楼包间");
        data_list.add("大厅卡座");
        title_menu1 = (ImageView) findViewById(R.id.title_menu1);
        tishici = (TextView) findViewById(R.id.tishici);
        cancleBt = (Button) findViewById(R.id.cancle);
        comfirmBt = (Button) findViewById(R.id.comfirmBt);
        title_back1 = (LinearLayout) findViewById(R.id.title_back1);
        chouti = (LinearLayout) findViewById(R.id.chouti);
        title_sc = (LinearLayout) findViewById(R.id.title_sc);
        title = (RelativeLayout) findViewById(R.id.title);
        scRl = (RelativeLayout) findViewById(R.id.scRl);
        linearLayout = (LinearLayout) findViewById(R.id.recyclerll);
        lianll = (LinearLayout) findViewById(R.id.lianll);
        spinner = (Spinner) findViewById(R.id.spinner);
        tishici.setText(tisi);

        cancleBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        comfirmBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TurnTableActivity.this, DialogActivity.class)
                        .putExtra("title", "提示").putExtra("msg", "你正在将1号桌转移到2号桌")
                        .putExtra("isbutton", true)
                );
            }
        });
        title_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mScrollView = (ScrollView) findViewById(
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


        expandGridView = (ExpandGridView) findViewById(R.id.expandGridView);
        turnTableExpandGridViewAdapter = new TurnTableExpandGridViewAdapter(this, tableGridViewDatas, this);
        expandGridView.setAdapter(turnTableExpandGridViewAdapter);
//        mRefreshLayout = (BGARefreshLayout) findViewById(
//                R.id.refresh);
//        mRefreshLayout.setDelegate(this);
//        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(getActivity(), true);
//        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
//        recyclerView_one = (RecyclerView) view.findViewById(R.id.recyclerView_one);
//        setRecyclerView_one();

        //适配器
        arr_adapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_layout_product, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
//        spinner.setDropDownHorizontalOffset(100);
        spinner = (Spinner) findViewById(R.id.spinner);
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
    }
}
