package jdhe.iyibank.com.iyimeal.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;

public class Reset_PasswordActivity extends BaseActivity {
    private Button getcodebtn;
    private TimerTask task;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rese_password);
        initTitle();
        logo.setVisibility(View.GONE);
        mBaseTitle.setText("重置密码");
        initview();
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.phone, R.id.newps,R.id.setps, R.id.code};
        return ids;
    }

    private void initview() {
        getcodebtn = (Button) findViewById(R.id.getcodebtn);
        getcodebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getcodebtn.setBackground(ContextCompat.getDrawable(getApplication(), R.drawable.corners_deep_gray_small2));
                getcodebtn.setTextColor(ContextCompat.getColor(getApplication(), R.color.graybf));
                startTimer();
                getcodebtn.setClickable(false);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    private void startTimer() {
        if (timer == null) {
            timer = new Timer();
        }

        if (task == null) {
            task = new TimerTask() {
                private int recLen = 60;

                @Override
                public void run() {

                    runOnUiThread(new Runnable() {      // UI thread
                        @Override
                        public void run() {
                            recLen--;
                            getcodebtn.setText("" + recLen + "秒");
                            if (recLen < 1) {
                                stopTimer();
                                getcodebtn.setClickable(true);
                                getcodebtn.setBackground(ContextCompat.getDrawable(getApplication(), R.drawable.corners_deep_orange_small));
                                getcodebtn.setTextColor(ContextCompat.getColor(getApplication(), R.color.capture_text_bg));
                                getcodebtn.setText("获取验证码");
                            }
                        }
                    });
                }
            };
        }

        if (timer != null && task != null)
            timer.schedule(task, 1000, 1000);

    }
}
