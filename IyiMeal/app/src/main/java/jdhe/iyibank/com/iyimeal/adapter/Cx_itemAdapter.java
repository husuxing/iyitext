package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.app.MyAppLication;

/**
 * Created by Administrator on 2017/8/3.
 */

public class Cx_itemAdapter extends BaseAdapter {
    private Activity context;

    public Cx_itemAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
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

        ProductHolder myViewHolder = null;
        if (convertView == null) {
            myViewHolder = new ProductHolder();
            convertView = View.inflate(context, R.layout.cx_itemfreagment_layout, null);
            myViewHolder.btn_cancel = (TextView) convertView.findViewById(R.id.btn_cancel);
            myViewHolder.number = (TextView) convertView.findViewById(R.id.number);
            myViewHolder.cxbj = (LinearLayout) convertView.findViewById(R.id.cxbj);
            myViewHolder.cancle = (ImageView) convertView.findViewById(R.id.cancle);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (ProductHolder) convertView.getTag();
        }

        final ProductHolder finalMyViewHolder = myViewHolder;
        myViewHolder.btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = finalMyViewHolder.btn_cancel.getText().toString();
                if ("撤销".equals(text)) {
                    context.startActivity(new Intent(context, DialogActivity.class)
                            .putExtra("title", "提示").putExtra("msg", "你将撤销该账单")
                            .putExtra("isbutton", true).putExtra("isedit", "1")
                    );
                    finalMyViewHolder.cxbj.setBackgroundColor(ContextCompat.getColor(context, R.color.huid0));
                    finalMyViewHolder.number.setTextColor(ContextCompat.getColor(context, R.color.colorgray69));
                    finalMyViewHolder.btn_cancel.setText("取消撤销");
                    finalMyViewHolder.btn_cancel.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
//                    finalMyViewHolder.btn_cancel.setTextColor(ContextCompat.getColor(context,R.color.white));
                    finalMyViewHolder.cancle.setVisibility(View.VISIBLE);
                }else {
                    finalMyViewHolder.cxbj.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    finalMyViewHolder.number.setTextColor(ContextCompat.getColor(context, R.color.redf5));
                    finalMyViewHolder.btn_cancel.setText("撤销");
                    finalMyViewHolder.btn_cancel.setBackground(ContextCompat.getDrawable(context, R.drawable.border_edit_text1));
                    finalMyViewHolder.btn_cancel.setTextColor(ContextCompat.getColor(context,R.color.black));
                    finalMyViewHolder.cancle.setVisibility(View.GONE);
                }

            }
        });
        return convertView;
    }

    static class ProductHolder {
        LinearLayout cxbj;
        private ImageView cancle;
        private TextView btn_cancel;
        private TextView number;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }
}
