package jdhe.iyibank.com.iyimeal.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import jdhe.iyibank.com.iyimeal.costomview.widget.OptionsPopupWindow;
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

    public void setModle(String nub, String area, String down, String roomfee, String mealfee) {
        iBatchAddTableModle.setAddNub(nub);
        iBatchAddTableModle.setArea(area);
        iBatchAddTableModle.setdownNub(down);
        iBatchAddTableModle.setMealFee(mealfee);
        iBatchAddTableModle.setRoomFee(roomfee);
    }

    public void startActivivty() throws Exception {
        BatchAddTableBean batchAddTableBean = iBatchAddTableModle.getBatch();
        iBatchAddTableView.startNextActivity(batchAddTableBean);
    }

    public void setAreaData(Context context,View view) {
        OptionsPopupWindow optionsPopupWindow = new OptionsPopupWindow(context);
        final ArrayList<String> options1Items = new ArrayList<>();
        options1Items.add("一楼");
        options1Items.add("二楼");
        options1Items.add("三楼");
        optionsPopupWindow.setPicker(options1Items);//, options2Items, options3Items, true);
        optionsPopupWindow.setSelectOptions(0);//, 0, 0);
        optionsPopupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        optionsPopupWindow
                .setOnoptionsSelectListener(new OptionsPopupWindow.OnOptionsSelectListener() {

                    @Override
                    public void onOptionsSelect(int options1, int option2,
                                                int options3) {
                        String tx = options1Items.get(options1);
                        iBatchAddTableView.setAreaChoose(tx);
                    }
                });
    }
}
