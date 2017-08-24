package jdhe.iyibank.com.iyimeal.interface_all;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

/**
 * Created by Administrator on 2017/8/24.
 */

public interface IClassification_of_dishesModle {
    void setBatchBeans(ArrayList<BatchAddTableBean> batchAddTableBeens);
    ArrayList<BatchAddTableBean> getBatchBean();
}
