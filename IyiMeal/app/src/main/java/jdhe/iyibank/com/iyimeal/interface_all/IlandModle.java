package jdhe.iyibank.com.iyimeal.interface_all;

import jdhe.iyibank.com.iyimeal.entity.UserBean;

/**
 * Created by Administrator on 2017/8/16.
 */

public interface IlandModle {
    void setUserName(String userName);
    void setPassWord(String passWord);
    UserBean load(int id);
}
