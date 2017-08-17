package jdhe.iyibank.com.iyimeal.network;

import android.util.Log;


import jdhe.iyibank.com.iyimeal.network.api.QueryInfoApi;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*************************************************************
 * Created by OCN.Yang           * * * *   * * * *   *     * *
 * Time:2016/10/10 16:49.        *     *   *         * *   * *
 * Email address:yangocn@163.com *     *   *         *   * * *
 * Web site:www.ocnyang.com      * * * *   * * * *   *     * *
 *************************************************************/


public class Network {

    public static final String ROOT_URL = "http://v.juhe.cn/";


    private static QueryInfoApi sQueryTelApi;
    private static QueryInfoApi sQueryQQApi;
    private static QueryInfoApi sQueryIDCardApi;




    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public static QueryInfoApi getQueryIDCardApi(){
        if (sQueryIDCardApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://apis.juhe.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sQueryIDCardApi = retrofit.create(QueryInfoApi.class);
        }
        return sQueryIDCardApi;
    }
    public static QueryInfoApi getQueryQQApi(){
        if (sQueryQQApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://japi.juhe.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sQueryQQApi = retrofit.create(QueryInfoApi.class);
        }
        return sQueryQQApi;
    }
    public static QueryInfoApi getQueryTelApi(){
        if (sQueryTelApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://apis.juhe.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sQueryTelApi = retrofit.create(QueryInfoApi.class);
        }
        return sQueryTelApi;
    }



}
