package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddFoodActivity;
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.activity.FoodMaintenanceActivity;


/**
 * Created by Administrator on 2017/8/2.
 */

public class FootFragmentAdapter  extends BaseAdapter {
    private Activity context;
    private String status;

    public FootFragmentAdapter(Activity context) {
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

        OrderMainHolder myViewHolder = null;
        if (convertView == null) {
            myViewHolder = new OrderMainHolder();
            convertView = View.inflate(context, R.layout.footfragmentadapterlayout, null);

            myViewHolder.name = (TextView) convertView.findViewById(R.id.name);
            myViewHolder.delete = (ImageView) convertView.findViewById(R.id.delete);
//            myViewHolder.zfmoney = (TextView) convertView.findViewById(R.id.zfmoney);
//            myViewHolder.zfsales = (TextView) convertView.findViewById(R.id.zfsales);
//            myViewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (OrderMainHolder) convertView.getTag();
        }
        myViewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AddFoodActivity.class).putExtra("who","FootFragmentAdapter"));
            }
        });
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DialogActivity.class)
                        .putExtra("title", "提示").putExtra("msg", "你正在删除“家常菜”。")
                        .putExtra("isbutton", true).putExtra("isedit", "1")
                );
            }
        });
        return convertView;
    }

    static class OrderMainHolder {
        private TextView name, zfmoney,zfsales,time,order,payee,beizhu;
        private LinearLayout detailtextview,xialaLl;
        private ImageView delete;
    }

}

