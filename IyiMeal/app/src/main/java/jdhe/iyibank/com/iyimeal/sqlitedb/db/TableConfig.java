package jdhe.iyibank.com.iyimeal.sqlitedb.db;

/**
 * Created by Administrator on 2017/8/8.
 */

public class TableConfig {
    public static final String TABLE_CUSTOMER = "customer";
    /**
     * Customer数据表的字段
     */
    public static class Customer{
        //Customer
        public static final String CUSTOMER_ID="id";
        public static final String CUSTOMER_NAME="customerName";
        public static final String DELIVERY_PHONE="deliveryPhone";
        public static final String ADDR="addr";
        public static final String ACCESS_TYPE="accessType";
        public static final String CUSTOMER_RATING="customerRating";
        public static final String LAYERS="layers";
        public static final String REMARK="remark";
        public static final String CONTACTS="contacts";
    }
}
