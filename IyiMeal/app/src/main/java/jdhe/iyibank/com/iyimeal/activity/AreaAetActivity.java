package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.ArrayList;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.AreaSetAdapter;
import jdhe.iyibank.com.iyimeal.adapter.ConsumerDetailsAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.entity.AreaBean;

public class AreaAetActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    private ListView listView;
    private AreaSetAdapter areaSetAdapter;
    private BGARefreshLayout mRefreshLayout;

    private Button comfirmBtn;
    private String who;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_aet);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("区域设置");
        initview();
    }

    private void initview() {
        who = getIntent().getExtras().getString("who", "");
        if ("MainActivity".equals(who)) {
            title_wen.setVisibility(View.VISIBLE);
            title_wen.setText("下一步");
            title_wen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(AreaAetActivity.this, TableSetActivity.class).putExtra("who", "AreaAetActivity"));
                }
            });
        }
        ArrayList<AreaBean> areaBeens = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            AreaBean areaBean = new AreaBean("大厅");
            areaBeens.add(areaBean);
        }

        comfirmBtn = (Button) findViewById(R.id.comfirmBtn);
        listView = (ListView) findViewById(R.id.listview);
        areaSetAdapter = new AreaSetAdapter(this, areaBeens);
        listView.setAdapter(areaSetAdapter);
        mRefreshLayout = (BGARefreshLayout) findViewById(
                R.id.refresh);
        mRefreshLayout.setDelegate(this);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        comfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(AreaAetActivity.this, DialogActivity.class)
                        .putExtra("title", "请输入区域名称").putExtra("msg", "").putExtra("who", "AreaAetActivity")
                        .putExtra("isbutton", true).putExtra("isedit", "0"), 100
                );
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == 100) {
                    String name = data.getExtras().getString("areaname", "");
                    addArea(name);
                }
                if (requestCode == 101) {
                    String position = data.getExtras().getString("position", "");
                    areaSetAdapter.deleteArea(Integer.valueOf(position));
                }
                if (requestCode == 102) {
                    String position = data.getExtras().getString("position", "");

                    String name = data.getExtras().getString("name", "");
                    Logger.e(name+position);
                    areaSetAdapter.ressetAreaName(Integer.valueOf(position),name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addArea(String name) {
        AreaBean areaBean =new AreaBean(name);
        areaSetAdapter.addArea(areaBean);
    }

}
