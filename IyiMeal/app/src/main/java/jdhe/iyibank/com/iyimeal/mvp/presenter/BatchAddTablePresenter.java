package jdhe.iyibank.com.iyimeal.mvp.presenter;

import android.app.Activity;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchAddTableModle;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchAddTableView;
import jdhe.iyibank.com.iyimeal.mvp.model.BatchAddTableModel;

/**
 * Created by Administrator on 2017/8/18.
 */

public class BatchAddTablePresenter {
    private IBatchAddTableModle iBatchAddTableModle;
    private IBatchAddTableView iBatchAddTableView;

    public BatchAddTablePresenter(IBatchAddTableView iBatchAddTableView) {
        this.iBatchAddTableView = iBatchAddTableView;
        iBatchAddTableModle = new BatchAddTableModel();
    }

    public void setModle(String nub,String area,String down,String roomfee,String mealfee){
        iBatchAddTableModle.setAddNub(nub);
        iBatchAddTableModle.setArea(area);
        iBatchAddTableModle.setdownNub(down);
        iBatchAddTableModle.setMealFee(mealfee);
        iBatchAddTableModle.setRoomFee(roomfee);
    }

    public void startActivivty() throws Exception{
        BatchAddTableBean batchAddTableBean=iBatchAddTableModle.getBatch();
        iBatchAddTableView.startNextActivity(batchAddTableBean);
    }


}
