package jdhe.iyibank.com.iyimeal.mvp.presenter;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchAddTableModle;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchAddTableView;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchTablelistModle;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchTablelistView;
import jdhe.iyibank.com.iyimeal.mvp.model.BatchAddTableModel;
import jdhe.iyibank.com.iyimeal.mvp.model.BatchTablelistModle;

/**
 * Created by Administrator on 2017/8/18.
 */

public class BatchTablelistPresenter {
    private IBatchTablelistModle iBatchTablelistModle;
    private IBatchTablelistView iBatchTablelistView;

    public BatchTablelistPresenter(IBatchTablelistView iBatchTablelistView) {
        this.iBatchTablelistView = iBatchTablelistView;
        iBatchTablelistModle = new BatchTablelistModle();
    }

    public void setBatchBean(BatchAddTableBean batchAddTableBean) throws Exception{
        ArrayList<BatchAddTableBean> batchAddTableBeens = new ArrayList<>();
        String area = batchAddTableBean.getAreaet();
        String down = batchAddTableBean.getDown_nub();
        String room = batchAddTableBean.getRoom_charge();
        String meal = batchAddTableBean.getMealfee();
        for (int i = 0; i < Integer.valueOf(batchAddTableBean.getNub()); i++) {
            BatchAddTableBean bean = new BatchAddTableBean("", i + "", area,
                    down, room, meal);
            batchAddTableBeens.add(bean);
        }
        iBatchTablelistModle.setBatchBeans(batchAddTableBeens);
        iBatchTablelistView.setList(batchAddTableBeens);
    }

    public void setListAdapter() {
        iBatchTablelistView.setList(iBatchTablelistModle.getBatchBean());
        iBatchTablelistView.initHeaderAndFooter();
    }

//    public void startActivivty() {
//        BatchAddTableBean batchAddTableBean = iBatchAddTableModle.getBatch();
//        iBatchAddTableView.startNextActivity(batchAddTableBean);
//    }
}
