package jdhe.iyibank.com.iyimeal.app;

import android.os.Environment;


public class Config {
    public static final String SUCCESS = "Success";
    public static final String MESSAGE = "Message";
    public static final String TOKEN = "Token";
    public static final String DATA = "Data";
    public static final String MY_GROUP = "my_group";// 我的群
    public static final String START_GROUP = "start_groups";// 发起群聊
    public static final String NOTICE_APPLY = "notice_apply";// 申请与通知
    public static final String MESSAGE_TYPE = "type";//自定义消息类型
    public static final String MESSAGE_ID = "goodsid";//商品id
    public static final String MESSAGE_INVENTORY_ID = "inventoryid";//sku id
    public static final String MESSAGE_ORDERND = "orderno";//订单号
    public static final String MESSAGE_ORDER_ROLE = "orderrole";//订单号
    public static final String ACCOUNT_REMOVED = "account_removed";
//    public final static int SUCCESS = 100;//成功
    public final static int ERROR = 101;//失败，传回中文错误信息
    public final static int KEY_FAILURE = 120;//未获取key
    public final static int NOT_LOGIN = 110;//未登录
    public final static int PAY = 102;//支付时返回
    public final static String PATH = Environment.getExternalStorageDirectory().getPath() + "/IyiBank/";
//    public final static int LOGIN_RESID[] = {R.drawable.home1, R.drawable.home2, R.drawable.home3};


}
