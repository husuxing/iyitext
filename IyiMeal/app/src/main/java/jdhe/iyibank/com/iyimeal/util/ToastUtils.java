package jdhe.iyibank.com.iyimeal.util;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import jdhe.iyibank.com.iyimeal.R;


public class ToastUtils extends Toast {
    public ToastUtils(Context context) {
        super(context);
    }
    public static Toast makeText(Context context, CharSequence text) {
        Toast result = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.newtoast, null);
        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        textView.setText(text);
        result.setView(layout);
        result.setDuration(Toast.LENGTH_SHORT);
        result.show();
        return result;
    }

    public static Toast makeTextWifi(Context context) {
        Toast result = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.newtoast, null);
        ImageView imageView = (ImageView) layout.findViewById(R.id.toast_image);
        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        imageView.setVisibility(View.VISIBLE);
        textView.setText("无法连接到网络");
        imageView.setImageResource(R.drawable.toast_wifi);
        result.setView(layout);
        result.setDuration(Toast.LENGTH_SHORT);
        result.show();
        return result;
    }

    public static Toast makeTextError(Context context) {
        Toast result = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.newtoast, null);
        ImageView imageView = (ImageView) layout.findViewById(R.id.toast_image);
        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        imageView.setVisibility(View.VISIBLE);
        textView.setText("服务器未响应，请稍后再试");
        imageView.setImageResource(R.drawable.toast_error);
        result.setView(layout);
        result.setDuration(Toast.LENGTH_SHORT);
        result.show();
        return result;
    }

    //EditView  隐藏软键盘
    public static void setOnTouch(View view, final Activity context) throws Exception {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
                View vv = context.getCurrentFocus();
                if (vv == null) {//
                    return false;
                }
                IBinder windowToken = vv.getWindowToken();
                boolean ii = imm.hideSoftInputFromWindow(windowToken, 0);
                return ii;
            }
        });
    }
}
