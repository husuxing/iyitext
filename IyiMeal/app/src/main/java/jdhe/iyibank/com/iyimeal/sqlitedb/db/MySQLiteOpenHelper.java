package jdhe.iyibank.com.iyimeal.sqlitedb.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Administrator on 2017/8/8.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static MySQLiteOpenHelper helper;

    //构造器,传入四个参数Context对象，数据库名字name，操作数据库的Cursor对象，版本号version。
    private MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //为了简化构造器的使用，我们自定义一个构造器
    private MySQLiteOpenHelper(Context context, String name) {
        this(context, name, null, 1);//传入Context和数据库的名称，调用上面那个构造器
    }

    //将自定义的数据库创建类单例。
    public static synchronized MySQLiteOpenHelper getInstance(Context context) {
        if (helper == null) {
            helper = new MySQLiteOpenHelper(context, "iyirestaurant");//数据库名称为create_db。
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //在创建数据库时，初始化创建数据库中包含的数据库表。这里以一个“客户”的数据表为例
        /*
        customer   创建 "客户"数据表
         */
//        sqLiteDatabase.execSQL("create table if not exists " + TableConfig.TABLE_ACCOUNTS + "("
//                + TableConfig.Accounts.ID + " integer not null primary key autoincrement,"
//                + TableConfig.Accounts.BALANCE + " verchar(20),"
//                + TableConfig.Accounts.CREATETIME + " verchar(20),"
//                + TableConfig.Accounts.RECHARGE + " verchar(20) ,"
//                + TableConfig.Accounts.REMARKS + " verchar(20),"
//                + TableConfig.Accounts.REMARKS + " verchar(20), "
//                + TableConfig.Accounts.LAYERS + " verchar(20),"
//                + TableConfig.Accounts.CONTACTS + " verchar(20),"
//                + TableConfig.Accounts.REMARK + " verchar(20))");

        sqLiteDatabase.execSQL("CREATE TABLE if not exists" + TableConfig.TABLE_ACCOUNTS +
                "(" +
                        TableConfig.Accounts.ID + " integer not null primary key autoincrement,"
                        + TableConfig.Accounts.BALANCE + " double not null,"
                        + TableConfig.Accounts.CREATETIME + " data not null,"
                        + TableConfig.Accounts.RECHARGE + " double not null,"
                        + TableConfig.Accounts.REMARKS + " text,"
                        + TableConfig.Accounts.SHOPID + " integer,"
                        + TableConfig.Accounts.TOTALFREEMONEY + " double not null,"
                        + TableConfig.Accounts.UNIONID + " text(36) not null,"
                        + TableConfig.Accounts.USERID + "integer"
                        + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //用于升级数据库，只需要在创建本类对象时传入一个比之前创建传入的version大的数即可。
    }
}
