package jdhe.iyibank.com.iyimeal.util;

import android.util.Log;

public class LogTool {
	public static boolean V = true;//发布时改为false
	public static final String TAG = "ComeHelpMe";

	public static void i(String msg){
		if(V){
			i(TAG, msg);
		}
	}

	public static void i(String tag, String msg) {
		if(V){
			Log.i(tag, msg);
		}
	}

    public static void d(String msg){
		if(V){
			d(TAG, msg);
		}
	}
    public static void e(String msg){
		if(V){
			d(TAG, msg);
		}
	}
	public static void d(String tag, String msg) {
		if(V){
            Log.d(tag, msg);
		}
	}
	
	public static String makeLogTag(Class<?> clazz) {
		return "日志_" + clazz.getSimpleName();
	}
}
