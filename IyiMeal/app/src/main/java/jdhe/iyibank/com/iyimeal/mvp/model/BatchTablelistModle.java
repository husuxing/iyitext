package jdhe.iyibank.com.iyimeal.mvp.model;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchTablelistModle;

/**
 * Created by Administrator on 2017/8/18.
 */

public class BatchTablelistModle implements IBatchTablelistModle {
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
