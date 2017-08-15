package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;

/**
 * Created by Administrator on 2017/8/3.
 */

public class HistrotyAdapter extends BaseAdapter {
    private Activity context;

    public HistrotyAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
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

        ConsumerDetailsAdapter.Holder myViewHolder = null;
        if (convertView == null) {
            myViewHolder = new ConsumerDetailsAdapter.Holder();
            convertView = View.inflate(context, R.layout.histrotyadapter_itemlayout, null);
//            myViewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (ConsumerDetailsAdapter.Holder) convertView.getTag();
        }

//        TextPaint paint = myViewHolder.name.getPaint();
//        paint.setFakeBoldText(true);
//        final Holder finalMyViewHolder = myViewHolder;
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, MemberManagementModificationActivity.class));
//            }
//        });
        return convertView;
    }

    static class Holder {
        LinearLayout cxbj;
        private ImageView cancle;
        private TextView name;
        private TextView number;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }
}
