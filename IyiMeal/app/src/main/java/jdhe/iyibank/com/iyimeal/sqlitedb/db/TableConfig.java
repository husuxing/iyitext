package jdhe.iyibank.com.iyimeal.sqlitedb.db;

/**
 * Created by Administrator on 2017/8/8.
 */

public class TableConfig {
    public static final String TABLE_ACCOUNTS = "accounts" ;
    /**
     * Customer数据表的字段
     */
    public static class Accounts{
        //Customer
        public static final String ID="ID";
        public static final String BALANCE="Balance";
        public static final String CREATETIME="CreateTime";
        public static final String RECHARGE="Recharge";
        public static final String REMARKS="Remarks";
        public static final String SHOPID="ShopID";
        public static final String TOTALFREEMONEY="TotalFreeMoney";
        public static final String UNIONID="UnionID";
        public static final String USERID="UserID";
    }
    public static final String TABLE_DESKS = "desks"  ;
    public static final String TABLE_ODRERITEMS="orderitems"  ;
    public static final String TABLE_ORDERS = "orders"  ;
    public static final String TABLE_PAYSETTINGS = "paysettings";
    public static final String TABLE_PERMISSIONS = "permissions" ;
    public static final String TABLE_PRODUCTS = "products" ;
    public static final String TABLE_PRODUCTTYPES = "producttypes" ;
    public static final String TABLE_REGISONS = "regions" ;
    public static final String TABLE_SHOPMEMBERS = "shopmembers" ;
    public static final String TABLE_SHOPPRINTSETINGS = "shopprintsettings"  ;
    public static final String TABLE_SHOPS = "shops" ;
    public static final String TABLE_TRADERECORDS = "traderecords" ;
    public static final String TABLE_USERS = "users" ;
    public static final String TABLE_WORKSHIFTCHANGERECORDS= "workshiftchangerecords" ;
    public static final String TABLE_WORKSHIFTS = "workshifts" ;


}
