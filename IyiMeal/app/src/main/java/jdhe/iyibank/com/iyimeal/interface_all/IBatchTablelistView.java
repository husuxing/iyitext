package jdhe.iyibank.com.iyimeal.interface_all;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface IBatchTablelistView {
    void setList(ArrayList<BatchAddTableBean> batchAddTableBeens);
    void initHeaderAndFooter();
}
