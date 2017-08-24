package jdhe.iyibank.com.iyimeal.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;

import butterknife.BindView;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseFragment;
import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IClassification_of_dishesView;
import jdhe.iyibank.com.iyimeal.mvp.presenter.Classification_of_dishesPresenter;
import jdhe.iyibank.com.iyimeal.util.RecycleViewDivider;

/**
 * Created by Administrator on 2017/8/24.
 */

public class DishesFrament  extends BaseFragment implements View.OnClickListener,IClassification_of_dishesView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.id_recyclerview)
    RecyclerView mRecyclerView;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private LoadMoreWrapper mLoadMoreWrapper;
    private CommonAdapter<BatchAddTableBean> mAdapter;
    Classification_of_dishesPresenter classification_of_dishesPresenter=new Classification_of_dishesPresenter(this);

    public DishesFrament() {
    }


    public static DishesFrament newInstance() {
        DishesFrament fragment = new DishesFrament();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.classification_of_dishesfragment_layout;
    }

    @Override
    public void initView() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.VERTICAL, R.drawable.divider_mileage));
        try {
            classification_of_dishesPresenter.setListAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    protected void managerArguments() {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
//            case R.id.joke_find:
//                startActivity(new Intent(getContext(), JokeActivity.class));
//                break;
//            case R.id.star_find:
//                startActivity(new Intent(getContext(), ConstellationActivity.class));
//                break;
//            case R.id.wannianli_find:
//                startActivity(new Intent(getContext(), ChinaCalendarActivity.class));
//                break;
            default:
                break;
        }
    }


    @Override
    public void setList(ArrayList<BatchAddTableBean> batchAddTableBeens) {
        mAdapter = new CommonAdapter<BatchAddTableBean>(getContext(), R.layout.classification_of_dishes_itemlayout, batchAddTableBeens)
        {
            @Override
            protected void convert(ViewHolder myViewHolder, BatchAddTableBean batchAddTableBean, int position) {
//                myViewHolder.setVisible(R.id.money,true);
//                myViewHolder.setText(R.id.room_nub,batchAddTableBean.getSeatNum());
//                myViewHolder.setText(R.id.seatName,batchAddTableBean.getAreaet());
//                myViewHolder.setText(R.id.roomfee,batchAddTableBean.getRoom_charge());
//                myViewHolder.setText(R.id.number,batchAddTableBean.getDown_nub());
            }

        };
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);
        mLoadMoreWrapper = new LoadMoreWrapper(mHeaderAndFooterWrapper);
        mRecyclerView.setAdapter(mLoadMoreWrapper);
    }

    @Override
    public void initHeaderAndFooter() {

    }
}
