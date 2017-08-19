package jdhe.iyibank.com.iyimeal.interface_all;

import android.app.Activity;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface IBatchAddTableView {
    String getAddNub();
    String getArea();
    String getdownNub();
    String getRoomFee();
    String getMealFee();
    void startNextActivity(BatchAddTableBean batchAddTableBean);
    void setAreaChoose(String area);
}
