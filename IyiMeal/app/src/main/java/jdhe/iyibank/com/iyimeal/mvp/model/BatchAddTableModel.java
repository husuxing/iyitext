package jdhe.iyibank.com.iyimeal.mvp.model;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchAddTableModle;

/**
 * Created by Administrator on 2017/8/18.
 */

public class BatchAddTableModel implements IBatchAddTableModle {
    BatchAddTableBean batchAddTableBean=new BatchAddTableBean();
    @Override
    public void setAddNub(String nub) {
        batchAddTableBean.setNub(nub);
    }

    @Override
    public void setArea(String Area) {
        batchAddTableBean.setAreaet(Area);
    }

    @Override
    public void setdownNub(String downNub) {
        batchAddTableBean.setDown_nub(downNub);
    }

    @Override
    public void setRoomFee(String RoomFee) {
        batchAddTableBean.setRoom_charge(RoomFee);
    }

    @Override
    public void setMealFee(String MealFee) {
        batchAddTableBean.setMealfee(MealFee);
    }

    @Override
    public BatchAddTableBean getBatch() {
        return batchAddTableBean;
    }

}
