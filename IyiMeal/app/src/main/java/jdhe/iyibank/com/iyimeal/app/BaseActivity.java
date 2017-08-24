package jdhe.iyibank.com.iyimeal.app;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.LinkedList;

import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.util.KeyBoardUtils;


/**
 * Created by Administrator on 2017/5/5.
 */

public class BaseActivity extends FragmentActivity implements IBaseView{
    private LinkedList<Activity> activityList;
    protected LinearLayout mBaseBack, mLinearTitle, title_rightImage,title_sc;
    protected TextView mBaseTitle,title_wen;
    protected ImageView topImageview, logo, title_menu;
    private RelativeLayout mLayoutTitle;
    public int pageNmb = 20, tuHeng = 5;
    private ProgressDialog mProgressDialog;
//    public int[] colorArr = {R.color.pressblueff, R.color.brand_brown_red
//            , R.color.yellow_pressed, R.color.other_gray
//            , R.color.translucent_black, R.color.yellow_pressed
//            , R.color.service_blue, R.color.green
//            , R.color.packet_red_gray, R.color.pressblue4f
//            , R.color.brand_dark_red, R.color.brand_mid_blue
//            , R.color.translucent_black10, R.color.mood_red_tit
//            , R.color.yellow_pressed, R.color.yellow_pressed
//            , R.color.yellow_pressed, R.color.yellow_pressed
//            , R.color.heat_red, R.color.yellow_pressed
//            , R.color.yellow_pressed, R.color.yellow_pressed
//            , R.color.yellow_pressed, R.color.yellow_pressed};


    public static BaseActivity getBaseActivity() {
        return baseActivity;
    }

    static BaseActivity baseActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        MyAppLication.screenW = dm.widthPixels;
        MyAppLication.screenH = dm.heightPixels;//获取屏幕的分辨率
        activityList = new LinkedList<Activity>();
        addClass(this);
        baseActivity = this;
    }

    protected void hideTitle(int visibility) {
        mLinearTitle.setVisibility(visibility);
    }

    public void addClass(Activity activity) {
        MyAppLication.getInstance().addBuyActivity(activity);
    }

    public void clearClass() {
        MyAppLication.getInstance().clearClass();
    }

    /**
     * 初始化状态栏控件
     */
    protected void initTitle() {
        try {
            title_wen=(TextView) findViewById(R.id.title_wen);
            title_menu = (ImageView) findViewById(R.id.title_menu);
            mLayoutTitle = (RelativeLayout) findViewById(R.id.title);
            title_sc = (LinearLayout) findViewById(R.id.title_sc);
            title_rightImage = (LinearLayout) findViewById(R.id.title_rightImage);
            mBaseBack = (LinearLayout) findViewById(R.id.title_back);
            mLinearTitle = (LinearLayout) findViewById(R.id.view_top);
            mBaseTitle = (TextView) findViewById(R.id.title_content);
            topImageview = (ImageView) findViewById(R.id.topImageview);
            logo = (ImageView) findViewById(R.id.logo);
            mBaseBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取屏幕分辨率
     *
     * @return
     */
    protected DisplayMetrics getScreen() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //注：回调 2
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public BGARefreshLayout setRefreshLayout(BGARefreshLayout mRefreshLayout, int id, BGARefreshLayout.BGARefreshLayoutDelegate delegate, Context context) {
        mRefreshLayout = (BGARefreshLayout) findViewById(
                id);
        mRefreshLayout.setDelegate(delegate);
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(context, true);
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        return mRefreshLayout;
    }

    /**
     * 清除editText的焦点
     *
     * @param v   焦点所在View
     * @param ids 输入框
     */
    public void clearViewFocus(View v, int... ids) {
        if (null != v && null != ids && ids.length > 0) {
            for (int id : ids) {
                if (v.getId() == id) {
                    v.clearFocus();
                    break;
                }
            }
        }


    }

    /**
     * 隐藏键盘
     *
     * @param v   焦点所在View
     * @param ids 输入框
     * @return true代表焦点在edit上
     */
    public boolean isFocusEditText(View v, int... ids) {
        if (v instanceof EditText) {
            EditText tmp_et = (EditText) v;
            for (int id : ids) {
                if (tmp_et.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    //是否触摸在指定view上面,对某个控件过滤
    public boolean isTouchView(View[] views, MotionEvent ev) {
        if (views == null || views.length == 0) return false;
        int[] location = new int[2];
        for (View view : views) {
            view.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];
            if (ev.getX() > x && ev.getX() < (x + view.getWidth())
                    && ev.getY() > y && ev.getY() < (y + view.getHeight())) {
                return true;
            }
        }
        return false;
    }
    //endregion

    //region 右滑返回上级


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isTouchView(filterViewByIds(), ev)) return super.dispatchTouchEvent(ev);
            if (hideSoftByEditViewIds() == null || hideSoftByEditViewIds().length == 0)
                return super.dispatchTouchEvent(ev);
            View v = getCurrentFocus();
            if (isFocusEditText(v, hideSoftByEditViewIds())) {
                //隐藏键盘
                KeyBoardUtils.hideInputForce(this);
                clearViewFocus(v, hideSoftByEditViewIds());
            }
        }
        return super.dispatchTouchEvent(ev);

    }

    /**
     * 传入EditText的Id
     * 没有传入的EditText不做处理
     *
     * @return id 数组
     */
    public int[] hideSoftByEditViewIds() {
        return null;
    }

    /**
     * 传入要过滤的View
     * 过滤之后点击将不会有隐藏软键盘的操作
     *
     * @return id 数组
     */
    public View[] filterViewByIds() {
        return null;
    }

    public Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    public void setQr(Activity activity, String url, ImageView iv) {
//        String str_url = "https://" + url;
//        Bundle bundle = new Bundle();
//        bundle.putString("url", str_url);
        // 当输入框为空时，提示用户
        if (url.equals("")) {
//            Toast.makeText(getApplicationContext(), "输入框不能为空", Toast.LENGTH_SHORT).show();
        } else {
//            QRCodeUtil.showThreadImage(activity, url, iv, 0);//R.mipmap.ic_launcher
        }
//        return  QRCodeUtil.showThreadImage(activity, url, iv, R.mipmap.ic_launcher);
    }

    public int minMultiple(int a, int b) {
        int r = a, s = a, t = b;
        if (a < b) {
            r = a;
            a = b;
            b = r;
        }
        while (r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return s * t / a;
    }


    public void setListViewFooter(int size, ListView listview, Activity activity) {
        TextView TvFooterView = null;
        if (0 < size && size < pageNmb) {
            if (listview.getFooterViewsCount() == 0) {

                LinearLayout layout = null;
                if (TvFooterView == null) {
                    layout = new LinearLayout(activity);
                    TvFooterView = new TextView(activity);
                    TvFooterView.setText("已经全部加载完毕");
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    params.setMargins(0, 20, 0, 10);
                    TvFooterView.setLayoutParams(params);
                    TvFooterView.setTextSize(13);
                    TvFooterView.setGravity(Gravity.CENTER);
                    layout.addView(TvFooterView);
                }
                listview.addFooterView(layout);
            }
        }
    }

    public String getTimeNow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String time;
        if (month < 10) {
            time = year + "0" + month;
        } else {
            time = year + "" + month;
        }
        return time;
    }

    @Override
    public void showProgress(boolean flag, String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(flag);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setMessage(message);
        }

        mProgressDialog.show();
    }

    @Override
    public void showProgress(String message) {
        showProgress(true, message);
    }

    @Override
    public void showProgress() {
        showProgress(true);
    }

    @Override
    public void showProgress(boolean flag) {
        showProgress(flag, "");
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog == null)
            return;

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    @Override
    public void showToast(String msg) {
        if (!isFinishing()) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void close() {
        finish();
    }
}
