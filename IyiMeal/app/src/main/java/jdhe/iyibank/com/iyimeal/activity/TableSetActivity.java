package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.ConsumerDetailsAdapter;
import jdhe.iyibank.com.iyimeal.adapter.TableSetAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class TableSetActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{

    private ListView listView;
    private TableSetAdapter tableSetAdapter;
    private BGARefreshLayout mRefreshLayout;
    private TextView resetall,delete;
    String who;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_set);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("桌台设置");
        initview();
    }

    private void initview() {
        who=getIntent().getExtras().getString("who","");
        if("DialogActivity".equals(who)){//"AreaAetActivity".equals(who)||
            title_wen.setVisibility(View.VISIBLE);
            title_wen.setText("下一步");
            title_wen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(TableSetActivity.this,FoodMaintenanceActivity.class));
                }
            });
        }
        delete= (TextView) findViewById(R.id.delete);
        resetall= (TextView) findViewById(R.id.resetall);
        listView = (ListView) findViewById(R.id.listview);
        tableSetAdapter = new TableSetAdapter(this);
        listView.setAdapter(tableSetAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        resetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TableSetActivity.this,BatchAddTableActivity.class).putExtra("who",""));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TableSetActivity.this,AddTableActivity.class).putExtra("who",""));
//                startActivity(new Intent(TableSetActivity.this, DialogActivity.class)
//                        .putExtra("title", "提示").putExtra("msg", "是否删除所勾选桌台")
//                        .putExtra("isbutton", true)
//                );
            }
        });
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout bgaRefreshLayout) {

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout bgaRefreshLayout) {
        return false;
    }
}

