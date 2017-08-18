package jdhe.iyibank.com.iyimeal.interface_all;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface IBatchTablelistModle {
   void setBatchBeans(ArrayList<BatchAddTableBean> batchAddTableBeens);
    ArrayList<BatchAddTableBean> getBatchBean();
}
