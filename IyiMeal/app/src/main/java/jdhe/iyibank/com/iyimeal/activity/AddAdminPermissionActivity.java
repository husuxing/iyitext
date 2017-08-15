package jdhe.iyibank.com.iyimeal.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.XCFlowLayout;

public class AddAdminPermissionActivity extends BaseActivity {
    private XCFlowLayout mFlowLayout;
    private String mNames[] = {
            "已离职","管理员权限","点餐收银",
            "历史账单","交班报表","会员管理",
            "菜品资料维护","基本信息设置"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin_permission);
        initTitle();
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);
        mBaseTitle.setText("添加管理权限");
        initview();
    }

    private void initview() {
        mFlowLayout = (XCFlowLayout) findViewById(R.id.flowlayout);
        initChildViews();
    }

    private void initChildViews() {

        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.textview_bg));
            mFlowLayout.addView(view, lp);
        }
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.phone_zh, R.id.Name, R.id.password};
        return ids;
    }
}
