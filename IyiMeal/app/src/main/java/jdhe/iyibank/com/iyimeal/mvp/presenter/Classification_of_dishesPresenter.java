package jdhe.iyibank.com.iyimeal.mvp.presenter;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchTablelistModle;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchTablelistView;
import jdhe.iyibank.com.iyimeal.interface_all.IClassification_of_dishesModle;
import jdhe.iyibank.com.iyimeal.interface_all.IClassification_of_dishesView;
import jdhe.iyibank.com.iyimeal.mvp.model.BatchTablelistModle;
import jdhe.iyibank.com.iyimeal.mvp.model.Classification_of_dishesModle;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Classification_of_dishesPresenter {
    private IClassification_of_dishesModle iClassification_of_dishesModle;
    private IClassification_of_dishesView iClassification_of_dishesView;

    public Classification_of_dishesPresenter(IClassification_of_dishesView iClassification_of_dishesView) {
        this.iClassification_of_dishesView = iClassification_of_dishesView;
        iClassification_of_dishesModle = new Classification_of_dishesModle();
    }

    public void getBatchBeans() throws Exception{

        ArrayList<BatchAddTableBean> batchAddTableBeens=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BatchAddTableBean batchAddTableBean=new BatchAddTableBean("","","","","","");
            batchAddTableBeens.add(batchAddTableBean);
        }
        iClassification_of_dishesModle.setBatchBeans(batchAddTableBeens);
        iClassification_of_dishesView.setList(batchAddTableBeens);
    }

    public void setListAdapter() {
        ArrayList<BatchAddTableBean> batchAddTableBeens=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BatchAddTableBean batchAddTableBean=new BatchAddTableBean("","","","","","");
            batchAddTableBeens.add(batchAddTableBean);
        }
        iClassification_of_dishesModle.setBatchBeans(batchAddTableBeens);
        iClassification_of_dishesView.setList(batchAddTableBeens);
//        iClassification_of_dishesView.setList(iClassification_of_dishesModle.getBatchBean());
//        iClassification_of_dishesView.initHeaderAndFooter();
    }
}
