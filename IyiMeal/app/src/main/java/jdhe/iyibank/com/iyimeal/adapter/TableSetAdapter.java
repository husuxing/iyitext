package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddTableActivity;

/**
 * Created by Administrator on 2017/8/4.
 */

public class TableSetAdapter extends BaseAdapter {
    private Activity context;

    public TableSetAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
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
            convertView = View.inflate(context, R.layout.tablesetadapterlayout, null);
            myViewHolder.beij = (LinearLayout) convertView.findViewById(R.id.beij);
            myViewHolder.toggleButton = (ToggleButton) convertView.findViewById(R.id.toggleButton);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }
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
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, AddTableActivity.class).putExtra("who","TableSetAdapter"));
            }
        });
        return convertView;
    }

    static class Holder {
        private ToggleButton toggleButton;
        LinearLayout cxbj,beij;
        private ImageView cancle;
        private TextView name;
        private TextView number;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }
}
