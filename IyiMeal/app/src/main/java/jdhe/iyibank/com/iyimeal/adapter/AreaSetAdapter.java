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
import jdhe.iyibank.com.iyimeal.activity.DialogActivity;

/**
 * Created by Administrator on 2017/8/4.
 */

public class AreaSetAdapter extends BaseAdapter {
    private Activity context;

    public AreaSetAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
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
            convertView = View.inflate(context, R.layout.areasetadapterlayout, null);
            myViewHolder.delete = (TextView) convertView.findViewById(R.id.delete);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }

//        TextPaint paint = myViewHolder.name.getPaint();
//        paint.setFakeBoldText(true);
//        final Holder finalMyViewHolder = myViewHolder;
        myViewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DialogActivity.class)
                        .putExtra("title", "提示").putExtra("msg", "是否删除所选区域")
                        .putExtra("isbutton", true)
                );
            }
        });
        return convertView;
    }

    static class Holder {
        LinearLayout cxbj;
        private ImageView cancle;
        private TextView name;
        private TextView number;
        private TextView xiaolian;
        private TextView delete;
        private TextView state;
    }
}

