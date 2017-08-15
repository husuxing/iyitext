package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.costomview.XCFlowLayout;

/**
 * Created by Administrator on 2017/8/4.
 */

public class SmartPointSetAdapter extends BaseAdapter {
    private Activity context;
    private String mNames[] = {
            "已离职", "管理员权限", "点餐收银",
            "历史账单", "交班报表", "会员管理",
            "菜品资料维护", "基本信息设置"
    };

    public SmartPointSetAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
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
            convertView = View.inflate(context, R.layout.smartpointset_adapterlayout, null);//
            myViewHolder.mFlowLayout = (XCFlowLayout) convertView.findViewById(R.id.flowlayout);
            myViewHolder.toggleButton = (ToggleButton) convertView.findViewById(R.id.toggleButton);
            myViewHolder.beij = (LinearLayout) convertView.findViewById(R.id.beij);

            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }

//        TextPaint paint = myViewHolder.name.getPaint();
//        paint.setFakeBoldText(true);
//        final Holder finalMyViewHolder = myViewHolder;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        final Holder finalMyViewHolder = myViewHolder;
        myViewHolder.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {//
                        finalMyViewHolder.beij.setVisibility(View.GONE);
                    } else {
                        finalMyViewHolder.beij.setVisibility(View.VISIBLE);
                    }
                }
        });
        initChildViews(myViewHolder.mFlowLayout);
        return convertView;
    }

    static class Holder {
        LinearLayout cxbj,beij;
        private ImageView cancle;
        private XCFlowLayout mFlowLayout;
        private ToggleButton toggleButton;
        private TextView ranknub;
        private TextView state;
    }

    private void initChildViews(XCFlowLayout mFlowLayout) {
        if (mFlowLayout.getChildCount() == 0) {
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.leftMargin = 5;
            lp.rightMargin = 5;
            lp.topMargin = 5;
            lp.bottomMargin = 5;
            for (int i = 0; i < mNames.length; i++) {
//         View view=   LayoutInflater.from(context).inflate(R.layout.textview_layout, null, false);
                TextView view = new TextView(context);
                view.setText(mNames[i]);
                view.setTextSize(10);
                view.setTextColor(Color.WHITE);
                view.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.textview_bg));
                mFlowLayout.addView(view, lp);
            }
        }
    }
}
