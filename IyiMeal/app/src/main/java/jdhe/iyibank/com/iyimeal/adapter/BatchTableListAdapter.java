package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddTableActivity;
import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;

/**
 * Created by Administrator on 2017/8/18.
 */

public class BatchTableListAdapter extends BaseAdapter {
    private Activity context;
    private ArrayList<BatchAddTableBean> batchAddTableBeens;

    public BatchTableListAdapter(Activity context,ArrayList<BatchAddTableBean> batchAddTableBeens) {//, List<User> users, boolean isNearPeople) {
        this.context = context;
        this.batchAddTableBeens = batchAddTableBeens;

    }

    @Override
    public int getCount() {
        return batchAddTableBeens.size();
    }

    @Override
    public Object getItem(int position) {
        return batchAddTableBeens.get(position);
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
            convertView = View.inflate(context, R.layout.batchtablelist_layout, null);
            myViewHolder.beij = (LinearLayout) convertView.findViewById(R.id.beij);
            myViewHolder.no_ = (TextView) convertView.findViewById(R.id.no_);
            myViewHolder.room_nub = (EditText) convertView.findViewById(R.id.room_nub);
            myViewHolder.seatName = (EditText) convertView.findViewById(R.id.seatName);
            myViewHolder.roomfee = (EditText) convertView.findViewById(R.id.roomfee);
            myViewHolder.number = (EditText) convertView.findViewById(R.id.number);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }
        final Holder finalMyViewHolder = myViewHolder;
        myViewHolder.no_.setText(batchAddTableBeens.get(position).getSeatNum());
        myViewHolder.room_nub.setText(batchAddTableBeens.get(position).getSeatNum());
        myViewHolder.seatName.setText(batchAddTableBeens.get(position).getAreaet());
        myViewHolder.roomfee.setText(batchAddTableBeens.get(position).getRoom_charge());
        myViewHolder.number.setText(batchAddTableBeens.get(position).getDown_nub());
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, AddTableActivity.class).putExtra("who", "TableSetAdapter"));
//            }
//        });
        return convertView;
    }

    static class Holder {
        private ToggleButton toggleButton;
        LinearLayout cxbj, beij;
        private ImageView cancle;
        private EditText room_nub,seatName,roomfee,number;
        private TextView no_;
        private TextView ranknub;
        private TextView state;
    }
}