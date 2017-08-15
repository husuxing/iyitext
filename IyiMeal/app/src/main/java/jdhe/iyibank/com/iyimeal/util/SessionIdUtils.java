package jdhe.iyibank.com.iyimeal.util;

import android.text.TextUtils;


import java.util.UUID;

import jdhe.iyibank.com.iyimeal.app.MyAppLication;

public class SessionIdUtils {
	public static String getSessionId(){
		String sessionid= MyAppLication.getSharePreferenceUtil().getSessionId();
		if(TextUtils.isEmpty(sessionid)){
			sessionid= UUID.randomUUID().toString().replace("-", "");
			MyAppLication.getSharePreferenceUtil().setSessionId(sessionid);
		}
		return sessionid;
	}
	public static String getTokingId(){
//		String tokingidcopy = "";
		String tokingid= MyAppLication.getSharePreferenceUtil().getTokingId();
		if(!TextUtils.isEmpty(tokingid)){
			tokingid="Bearer "+tokingid;
		}
		return tokingid;
//		return "Bearer "+"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ey" +
//				"J1bmlxdWVfbmFtZSI6Inplbmd5aSIsInNpZCI6IjM4IiwianRpIjoiNGUyMmFjMjQtNjM5OC00N" +
//				"zFkLWFjYjYtMTAzZTM3ZTE0M2JjIiwibmJmIjoxNDk3NDIyOTgwLCJleHAiOjE0OTgwMjc3ODAsImlzc" +
//				"yI6IllpWWFBcHBTZXJ2aWNlQ2VudGVyQ29weXJpZ2h0IiwiYXVkIjo" +
//				"iaHR0cDovLzE5Mi4xNjguOC4xNDA6NTAwMS8ifQ.W6haXMvDuTJIsXxRkgP_ud2A3ToFUbsjzFD1PxTMae0";
	}
}
