package jdhe.iyibank.com.iyimeal.mvp.model;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IClassification_of_dishesModle;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Classification_of_dishesModle implements IClassification_of_dishesModle{
    ArrayList<BatchAddTableBean> batchAddTableBeens;
    @Override
    public void setBatchBeans(ArrayList<BatchAddTableBean> batchAddTableBeens) {
        this.batchAddTableBeens=batchAddTableBeens;
    }

    @Override
    public ArrayList<BatchAddTableBean> getBatchBean() {
        return batchAddTableBeens;
    }
}
