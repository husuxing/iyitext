package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddFoodActivity;
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.activity.Receivables_ConsumerActivity;
import jdhe.iyibank.com.iyimeal.costomview.CameraPopupWindow;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;
import jdhe.iyibank.com.iyimeal.costomview.YhPopupWindow;

/**
 * Created by Administrator on 2017/8/5.
 */

public class ReceivablesAdapter extends BaseAdapter implements View.OnClickListener {
    private Activity context;
    private Receivables_items_Adapter receivables_items_adapter;
    private YhPopupWindow yhPopupWindow;

    public ReceivablesAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 5;
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
            convertView = View.inflate(context, R.layout.receivables_adapterlayout, null);
            myViewHolder.expandListView = (ExpandListView) convertView.findViewById(R.id.listview);
            myViewHolder.youhui = (TextView) convertView.findViewById(R.id.youhui);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }
        receivables_items_adapter = new Receivables_items_Adapter(context);
        myViewHolder.expandListView.setAdapter(receivables_items_adapter);
        myViewHolder.youhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yhPopupWindow = new YhPopupWindow(context, ReceivablesAdapter.this, "");//"CAMERA_onclick"
                yhPopupWindow.showAtLocation(view, Gravity.BOTTOM
                        | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
            }
        });

        return convertView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnzk:
                context.startActivity(new Intent(context, DialogActivity.class)
                        .putExtra("title", "请选择折扣").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("iszhekourl", "0")
                );
                yhPopupWindow.dismiss();
                break;
            case R.id.btnyh:
                context.startActivity(new Intent(context, DialogActivity.class)
                        .putExtra("title", "使用优惠券").putExtra("msg", "单位：元")
                        .putExtra("isbutton", true).putExtra("isyouhuijll", "0")
                );
                yhPopupWindow.dismiss();
                break;
        }
    }

    static class Holder {
        LinearLayout cxbj;
        private ImageView cancle;
        private ExpandListView expandListView;
        private TextView youhui;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }
}

