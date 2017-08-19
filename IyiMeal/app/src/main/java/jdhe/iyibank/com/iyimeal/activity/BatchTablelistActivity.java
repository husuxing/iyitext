package jdhe.iyibank.com.iyimeal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.BatchTableListAdapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchTablelistView;
import jdhe.iyibank.com.iyimeal.mvp.presenter.BatchTablelistPresenter;
import jdhe.iyibank.com.iyimeal.util.RecycleViewDivider;

public class BatchTablelistActivity extends BaseActivity implements IBatchTablelistView {
    @BindView(R.id.resetall)
    TextView resetall;
    @BindView(R.id.id_recyclerview)
    RecyclerView mRecyclerView;
    private BatchTableListAdapter batchTableListAdapter;
    BatchTablelistPresenter batchTablelistPresenter;

    private CommonAdapter<BatchAddTableBean> mAdapter;
    private LoadMoreWrapper mLoadMoreWrapper;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_batch_tablelist);
        super.onCreate(savedInstanceState);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("批量添加桌台");
        try {
            initview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initview() throws Exception{
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        BatchAddTableBean batchAddTableBean = getIntent().getExtras().getParcelable("Bean");
        batchTablelistPresenter = new BatchTablelistPresenter(this);
        batchTablelistPresenter.setBatchBean(batchAddTableBean);
        batchTablelistPresenter.setListAdapter();
    }

    @OnClick(R.id.resetall)
    public void setResetallOnclick(View view) {
        startActivity(new Intent(BatchTablelistActivity.this, DialogActivity.class)
                .putExtra("title", "提示").putExtra("msg", "是否添加所勾选桌台")
                .putExtra("isbutton", true).putExtra("who", "BatchTablelistActivity")
        );
    }
    @Override
    public void initHeaderAndFooter()
    {
//        mRecyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(
                this, LinearLayoutManager.VERTICAL, R.drawable.divider_mileage));
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        mLoadMoreWrapper = new LoadMoreWrapper(mHeaderAndFooterWrapper);
//        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
//        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener()
//        {
//            @Override
//            public void onLoadMoreRequested()
//            {
//                mLoadMoreWrapper.notifyDataSetChanged();
//            }
//        });
        mRecyclerView.setAdapter(mLoadMoreWrapper);
    }

    @Override
    public void setList(ArrayList<BatchAddTableBean> batchAddTableBeens) {
        mAdapter = new CommonAdapter<BatchAddTableBean>(this, R.layout.batchtablelist_layout, batchAddTableBeens)
        {
            @Override
            protected void convert(ViewHolder myViewHolder, BatchAddTableBean batchAddTableBean, int position) {
                myViewHolder.setText(R.id.no_,batchAddTableBean.getSeatNum());
                myViewHolder.setText(R.id.room_nub,batchAddTableBean.getSeatNum());
                myViewHolder.setText(R.id.seatName,batchAddTableBean.getAreaet());
                myViewHolder.setText(R.id.roomfee,batchAddTableBean.getRoom_charge());
                myViewHolder.setText(R.id.number,batchAddTableBean.getDown_nub());
            }

        };

//        batchTableListAdapter = new BatchTableListAdapter(this, batchAddTableBeens);
//        listView.setAdapter(batchTableListAdapter);
    }


//    ArrayList<BatchAddTableBean> batchAddTableBeens = new ArrayList<>();
//
//        String area = batchAddTableBean.getAreaet();
//        String down = batchAddTableBean.getDown_nub();
//        String room = batchAddTableBean.getRoom_charge();
//        String meal = batchAddTableBean.getMealfee();
//        for (int i = 0; i < Integer.valueOf(batchAddTableBean.getNub()); i++) {
//            BatchAddTableBean bean = new BatchAddTableBean("", i + "", area,
//                    down, room, meal);
//            batchAddTableBeens.add(bean);
//        }

//        batchTableListAdapter = new BatchTableListAdapter(this, batchAddTableBeens);
//        listView.setAdapter(batchTableListAdapter);
//        resetall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(BatchTablelistActivity.this, DialogActivity.class)
//                        .putExtra("title", "提示").putExtra("msg", "是否添加所勾选桌台")
//                        .putExtra("isbutton", true).putExtra("who", "BatchTablelistActivity")
//                );
//            }
//        });
}
