package jdhe.iyibank.com.iyimeal.sqlitedb.dbinit;


import jdhe.iyibank.com.iyimeal.sqlitedb.dao.Customer;
import jdhe.iyibank.com.iyimeal.sqlitedb.db.TableConfig;
import jdhe.iyibank.com.iyimeal.sqlitedb.dbtool.TableOperate;

/**
 * Created by Administrator on 2017/8/8.
 */

public class DataBaseInit {
    /**
     * 初始化客户数据表
     */
    public static void initCustomerTable() {
        Customer customer1 = new Customer();
        customer1.setCustomerName("华庆丰");
        customer1.setDeliveryPhone("15345675673");
        customer1.setAddr("前进");
        customer1.setAccessType("农贸批发");
        customer1.setCustomerRating("A");
        customer1.setLayers("默认图层");
        customer1.setRemark("");
        customer1.setContacts("");

        Customer customer2 = new Customer();
        customer2.setCustomerName("物美草桥");
        customer2.setDeliveryPhone("");
        customer2.setAddr("");
        customer2.setAccessType("农贸批发");
        customer2.setCustomerRating("");
        customer2.setLayers("");
        customer2.setRemark("");
        customer2.setContacts("");

        Customer customer3 = new Customer();
        customer3.setCustomerName("京客隆");
        customer3.setDeliveryPhone("15937542659");
        customer3.setAddr("前进华润五金机电附近");
        customer3.setAccessType("农贸批发");
        customer3.setCustomerRating("A");
        customer3.setLayers("默认图层");
        customer3.setRemark("");
        customer3.setContacts("");

//        TableOperate operate = new TableOperate();//创建数据库操作类
//        operate.insert(TableConfig.TABLE_CUSTOMER,customer1);
//        operate.insert(TableConfig.TABLE_CUSTOMER,customer2);
//        operate.insert(TableConfig.TABLE_CUSTOMER, customer3);

        //删除
//        operate.delete(TableConfig.TABLE_CUSTOMER,TableConfig.Customer.CUSTOMER_NAME,"京客隆");
        //修改
//        Customer custtomer4 = new Customer();
//        operate.uptate(TableConfig.TABLE_CUSTOMER,TableConfig.Customer.CUSTOMER_NAME,"京客隆",customer4);
        //查询
//        ArrayList list = operate.query(TableConfig.TABLE_CUSTOMER, Customer.class, TableConfig.Customer.CUSTOMER_NAME, "京客隆");
//        Customer cus = (Customer) list.get(0);
//        Log.d("data", ""+cus.getCustomerName());
    }
}
