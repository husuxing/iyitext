package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.MyAppLication;
import jdhe.iyibank.com.iyimeal.costomview.XCFlowLayout;
import jdhe.iyibank.com.iyimeal.util.DensityUtil;

/**
 * Created by Administrator on 2017/8/4.
 */

public class AdminPermissionAdapter extends BaseAdapter {
    private Activity context;

    public AdminPermissionAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder myViewHolder = null;
        if (convertView == null) {
            myViewHolder = new Holder();
            convertView = View.inflate(context, R.layout.adminpermission_adapterlayout, null);
            myViewHolder.mFlowLayout = (XCFlowLayout) convertView.findViewById(R.id.flowlayout);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }


//        ViewGroup.LayoutParams params = myViewHolder.mFlowLayout.getLayoutParams();
////        params.width = DensityUtil.dip2px(context, 200);
//        String names = "";
//        for (String name : mNames) {
//            names += name;
//        }

//        MyAppLication.screenW
//        int dp_heigth=
//        MyAppLication.screenW

//        int num = names.length() * 10 + mNames.length * 10;
//        int ci = num / DensityUtil.px2dip(context, MyAppLication.screenW);
//
//        if (num % DensityUtil.px2dip(context, MyAppLication.screenW) != 0) {
//            ci++;
//        }
//        int gao = 2 * 30;
////        params.width = MyAppLication.screenH;
//        params.height = DensityUtil.dip2px(context, gao);
//        myViewHolder.mFlowLayout.setLayoutParams(params);
        initChildViews(myViewHolder.mFlowLayout);
        return convertView;
    }

    static class Holder {
        LinearLayout cxbj;
        private XCFlowLayout mFlowLayout;
        private ImageView cancle;
        private TextView name;
        private TextView number;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }

    private String mNames[] = {
            "已离职", "管理员权限", "点餐收银",
            "历史账单", "交班报表", "会员管理",
            "菜品资料维护", "基本信息设置"
    };

    private void initChildViews(XCFlowLayout mFlowLayout) {
       Log.d("ddddddddddddd", mFlowLayout.getChildCount()+"");
        if (mFlowLayout.getChildCount() == 0) {
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.leftMargin = 5;
            lp.rightMargin = 5;
            lp.topMargin = 5;
            lp.bottomMargin = 5;
            for (int i = 0; i < mNames.length; i++) {
//            View view=   LayoutInflater.from(context).inflate(R.layout.textview_layout, null, false);
                TextView view = new TextView(context);
                view.setTextSize(10);
                view.setText(mNames[i]);
                view.setTextColor(Color.WHITE);
                view.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.textview_bg));
                mFlowLayout.addView(view, lp);
            }
        }
    }
}
