package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AreaAetActivity;
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;
import jdhe.iyibank.com.iyimeal.entity.AreaBean;

/**
 * Created by Administrator on 2017/8/4.
 */

public class AreaSetAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<AreaBean> areaBeens;

    public AreaSetAdapter(Activity context,ArrayList<AreaBean> areaBeens) {//, List<User> users, boolean isNearPeople) {
        this.context = context;
        this.areaBeens = areaBeens;

    }

    @Override
    public int getCount() {
        return areaBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return areaBeens.get(position);
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
            convertView = View.inflate(context, R.layout.areasetadapterlayout, null);
            myViewHolder.delete = (TextView) convertView.findViewById(R.id.delete);
            myViewHolder.areaname = (TextView) convertView.findViewById(R.id.areaname);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }
        myViewHolder.areaname.setText(areaBeens.get(position).getName());
//        TextPaint paint = myViewHolder.name.getPaint();
//        paint.setFakeBoldText(true);
//        final Holder finalMyViewHolder = myViewHolder;
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivityForResult(new Intent(context, DialogActivity.class)
                        .putExtra("title", "提示").putExtra("msg", "是否删除所选区域")
                        .putExtra("isbutton", true).putExtra("who","AreaSetAdapterdelete").putExtra("position",position+""),101
                );
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivityForResult(new Intent(context, DialogActivity.class)
                        .putExtra("title", "修改区域名称").putExtra("msg", "")
                        .putExtra("isbutton", true).putExtra("isedit", "0").putExtra("who","AreaSetAdapterdelete_2").putExtra("position",position+""),102
                );
            }
        });
        return convertView;
    }

    static class Holder {
        LinearLayout cxbj;
        private ImageView cancle;
        private TextView areaname;
        private TextView number;
        private TextView xiaolian;
        private TextView delete;
        private TextView state;
    }

    public void addArea(AreaBean areaBean){
        areaBeens.add(areaBean);
        notifyDataSetChanged();
    }
    public void deleteArea(int position) {
        areaBeens.remove(position);
        notifyDataSetChanged();
    }
    public void ressetAreaName(int position,String name) {
        areaBeens.get(position).setName(name);
        notifyDataSetChanged();
    }
}

