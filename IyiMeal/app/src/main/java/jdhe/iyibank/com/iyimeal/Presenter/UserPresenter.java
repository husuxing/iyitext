package jdhe.iyibank.com.iyimeal.Presenter;

import jdhe.iyibank.com.iyimeal.entity.UserBean;
import jdhe.iyibank.com.iyimeal.interface_all.IlandModle;
import jdhe.iyibank.com.iyimeal.interface_all.IlandView;

/**
 * Created by Administrator on 2017/8/16.
 */

public class UserPresenter {
    private IlandView mUserView;
    private IlandModle mUserModel;

    public UserPresenter(IlandView view) {
        mUserView = view;
//        mUserModel = new UserModel();
    }

    public void saveUser( int id, String firstName, String lastName) {
        mUserModel.setPassWord(lastName);
    }

    public void loadUser( int id) {
        UserBean user = mUserModel.load(id);
        mUserView.setPassWord(user.toString()); // 通过调用IUserView的方法来更新显示
    }
}
