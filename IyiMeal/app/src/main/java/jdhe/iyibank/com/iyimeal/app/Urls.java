package jdhe.iyibank.com.iyimeal.app;

public class Urls {
    //内网     确认订单页面有一个全局控制/
//    public static String BASE_URL = "http://192.168.8.140:5001/";
    //外网119.29.147.233
    public static String BASE_URL = "https://iyi.8th.com/";//"http://119.29.147.233/";

    //    2.1用户登录、退出
    //UserLogin 登录
    public static String USERLOGIN = "api/Jwt/GetToken";
    // SendSMS  发送验证码
    public static String SENDSMS = "api/Customer/SendSMS";
    // UserRegister 注册
    public static String USERREGISTER = "api/Customer/Register";
    // FindPassword  找回密码
    public static String FINDPASSWORD = "api/Customer/FindPassword";
    //UserQuit  退出
    public static String USERQUIT = "api/Customer/UserQuit";

    //    2.2手势密码
    //设置手势密码启用 ModifyUserSetInfo
    public static String MODIFYUSERSETINFO = "api/Customer/ModifyUserSetInfo";
    //设置手势密码 SetGesturePassWord
    public static String SETGESTUREPASSWORD = "api/Customer/SetGesturePassWord";
    //找回手势密码 FindGesturePassWord
    public static String FINDGESTUREPASSWORD = "";
    //校验手势密码 VerifyGesturePassWord
    public static String VERIFYGESTUREPASSWORD = "api/Customer/VerifyGesturePassWord";
    //开关手势密码 EnableGesturePassWord
    public static String ENABLEGESTUREPASSWORD = "";

    //    2.3图片上传
    //   图上传  UploadImage
    public static String UPLOADIMAGE = "api/Image/UploadImage";

    //    2.4用户信息设置修改
    //    获取用户信息 GetUserInfo
    public static String GETUSERINFO = "api/Customer/GetUserInfo";
    //    修改用户信息 ModifyUserInfo
    public static String MODIFYUSERINFO = "api/Customer/ModifyUserInfo";
    //    修改密码 ModifyPassWord
    public static String MODIFYPASSWORD = "api/Customer/ModifyPassWord";

    //2.5店铺信息
    //  获取店铺信息  GetShopInfo
    public static String GETSHOPINFO = "api/Order/GetShopInfo";
    //  获取店铺信息  GetShopDetailInfo
    public static String GETSHOPDETAIINFO = "api/Shop/GetShopDetailInfo";
    // 设置店铺信息  SetShopDetailInfo
    public static String SETSHOPDETAIINFO = "api/Shop/SetShopDetailInfo";

    //    2.6销售订单
    //  获取商店收入 GetShopIncome
    public static String GETSHOPINCOME = "api/Order/GetShopIncome";
    //  获取全部订单 GetAllOrderList
    public static String GETALLORDERLIST = "api/Order/GetAllOrderList";
    //  获取已完成订单 GetFinishedOrderList
    public static String GETFINISHEDORDERLIST = "";
    //  获取未完成订单 GetUnfinishedOrderList
    public static String GETUNFINISHEDORDERLIST = "";
    //  获取订单详情 GetOrderDetail
    public static String GETORDERDETAIL = "";


    //  订单数统计列表 ReportForOrderCount
    public static String REPORTFORORDERCOUNT = "api/Report/ReportForOrderCount";
    //  订单销售统计列表 ReportForOrderSales
    public static String REPORTFORORDERSALES = "api/Report/ReportForOrderSales";
    //  支付方式占比统计 ReportForOrderPay
    public static String REPORTFORORDERPAY = "api/Report/ReportForOrderPay";

    //    2.7员工管理
    //  获取员工列表 GetEmployeeList
    public static String GETEMPLOYEELIST = "api/Emplyee/GetEmployeeList";
    //  获取员工详情 GetEmployeeDetail
    public static String GETEMPLOYEEDETAIL = "api/Emplyee/GetEmployeeDetail";
    //  修改员工信息 ModifyEmployee
    public static String MODIFYEMPLOYEE = "api/Emplyee/ModifyEmployee";
    //  添加员工信息 AddEmployee
    public static String ADDEMPLOYEE = "api/Emplyee/AddEmployee";

    // 2.8菜品管理
    //  获取所有商品列表 GetCommodityList
    public static String GETCOMMODITYLIST = "api/Product/GetCommodityList";
    //  获取按条件商品列表 GetSearchCmmodityList
    public static String GETSEARCHCOMMODITYLIST = "api/Product/GetSearchCmmodityList";
//    //  获取下载商品列表 GetPullOffCommodityList
//    public static String GETPULLOFFCOMMODITYLIST = "";
    //  获取商品详情 GetCmmodityDetail
    public static String GETCMMODITYDETAIL = "api/Product/GetCommodityDetail";
    //  修改商品信息 ModifyCommodity
    public static String MODIFYCOMMODITY = "api/Product/ModifyCommodity";
    //  添加商品 AddCommodity
    public static String ADDCOMMODITY = "api/Product/AddCommodity";

    // 2.9菜品类别
    //  获取菜品类别列表 GetCommodityTypeList
    public static String GETCOMMODITYTYPELIST = "api/ProductType/GetCommodityTypeList";
    //  获取所有启用状态的菜品类别 GetEnabledCommodityTypeList
    public static String GETENABLEDCOMMODITYTYPELIST = "api/ProductType/GetEnabledCommodityTypeList";
    //  获取菜品详情 GetCommodityTypeDetail
    public static String GETCOMMODITYTYPEDETAIL = "api/ProductType/GetCommodityTypeDetail";
    //  修改菜品类别 ModifyCommodityType
    public static String MODIFYCOMMODITYTYPE = "api/ProductType/ModifyCommodityType";
    //  添加菜品列表 AddCommodityType
    public static String ADDCOMMODITYTYPE = "api/ProductType/AddCommodityType";

    // 2.10桌台设置
    //  获取桌台列表 GetDeskList
    public static String GETDESKLIST = "api/Desk/GetDeskList";
    //  获取桌台详情 GetDeskDetail
    public static String GETDESKDETAIL = "api/Desk/GetDeskDetail";
    //  修改桌台信息 ModifyDesk  /
    public static String MODIFYDESK = "api/Desk/ModifyDesk";
    //  添加桌台 AddDesk
    public static String ADDDESK = "api/Desk/AddDesk";


    // 2.11外卖设置
    //  获取我外卖设置列表 GetTakeOutList
    public static String GETTAKEOUTLIST = "api/TakeOut/GetTakeOutList";
    //  获取外卖设置详情 GetTakeOutDetail
    public static String GETTAKEOUTDETAIL = "api/TakeOut/GetTakeOutDetail";
    //  修改外卖设置 ModifyTakeOut
    public static String MODIFYTAKEOUT = "api/TakeOut/ModifyTakeOut";
    //  添加外卖设置 AddTakeOut
    public static String ADDTAKEOUT = "api/TakeOut/AddTakeOut";

    // 2.12预订管理
    //  预定管理列表 GetReservationList
    public static String GETRESERVATIONLIST = "api/Reservation/GetReservationList";

    // 2.13二维码管理
    //  获取支持的所有支付类型 GetPayTypeList
    public static String GETPAYTYPELIST = "api/QRCode/GetPayTypeList";

    //  获取用户邮箱 GetUserEmail
    public static String GETUSEREMAIL = "api/QRCode/GetUserEmail";
    //  设置用户邮箱 SetUserEmail
    public static String SETUSEREMAIL = "api/QRCode/SetUserEmail";
    //  获取收款二维码 GetReceiptQRcode
    public static String GETRECEIPTQRCODE = "api/QRCode/GetReceiptQRcode";
    //  添加二维码 AddQRCode
    public static String ADDQRCODE = "api/QRCode/AddQRCode";
    //  发送收款二维码 SendReceiptQRCode
    public static String SENDRECEIPTQRCODE = "";
    //  获取二维码列表 GetQRCodePageList
    public static String GETQRCODELIST = "api/QRCode/GetQRCodePageList";
    //  发送二维码列表 SendQRCodeList
    public static String SENDQRCODELIST = "api/QRCode/SendQRCodeList";
    //  删除二维码 DeleteQRCode
    public static String DELETEQRCODE = "api/QRCode/DeleteQRCode";
    //  修改二维码 ModifyQRCode
    public static String MODIFYQRCODE = "api/QRCode/ModifyQRCode";
    //  获取二维码详情 GetQRCodeDetail
    public static String GETQRCODEDETAIL = "api/QRCode/GetQRCodeDetail";
    //  发送固定金额二维码 SendFixedPriceQRCode
    public static String SENDPIXEDPRICEQRCODE = "";
    //  获取非固定金额二维码列表 GetFloatPriceQRCodeList
    public static String GETFLOATPRICEQRCODELIST = "";
    //  发送非固定金额二维码列表 SendFloatPriceQRCodeList
    public static String SENDFLOATPRICEQRCODELIST = "";
    //  删除非固定金额二维码 DeleteFloatPriceQRCode
    public static String DELETEFLOATPRICEQRCODE = "";
    //  修改非固定金额二维码 ModifyFloatPriceQRCode
    public static String MODIFYFLOATPRICEQRCODE = "";
    //  获取非固定金额二维码详情 GetFloatPriceQRCodeDetail
    public static String GETFLOATPRICEQRCODEDETAIL = "";
    //  发送非固定金额二维码 SendFloatPriceQRCode
    public static String SENDFLOATPRICEQRCODE = "";

    //2.14扫描收款
    //  扫描收款 /api/Pay/ScanPay
    public static String SCANPAY= "api/Pay/ScanPay";

    // 2.15统计
    //  统计销售金额 StatisticsSales
    public static String STATISTICSSALES = "";
    //  统计销售订单 StatisticsOrderNumber
    public static String STATISTCSORDERNUMBER = "";
    //  统计支付方式 StatisticsPayWay
    public static String STATISTICSPAYWAY = "";
    //  统计支付方式详情 StatisticsPayWayDetail
    public static String STATISTICSPAYWAYDETAIL = "";

    //  添加用户支付 AddUserPayInfo
    public static String ADDUSERPAYINFO = "api/UserPayInfo/AddUserPayInfo";
    //  修改用户支付 ModifyUserPayInfo
    public static String MODIFYUSERPAYINFO = "api/UserPayInfo/ModifyUserPayInfo";
    //  获取用户支付配置列表 GetUserPayInfoList
    public static String GETUSERPAYINFOLIST = "api/UserPayInfo/GetUserPayInfoList";
    //  获取用户支付配置详情 GetUserPayInfoDetail
    public static String GETUSERPAYINFODETAIL = "api/UserPayInfo/GetUserPayInfoDetail";
    //  获取支付方式 GetPayServiceList
    public static String GETPAYSERVICELIST = "api/UserPayInfo/GetPayServiceList";







}
