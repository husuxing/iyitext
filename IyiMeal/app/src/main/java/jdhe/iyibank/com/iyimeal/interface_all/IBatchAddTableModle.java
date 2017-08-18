package jdhe.iyibank.com.iyimeal.interface_all;

import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

/**
 * Created by Administrator on 2017/8/18.
 */

public interface IBatchAddTableModle {
    void setAddNub(String nub);
    void setArea(String Area);
    void setdownNub(String downNub);
    void setRoomFee(String RoomFee);
    void setMealFee(String MealFee);
    BatchAddTableBean getBatch();
}
