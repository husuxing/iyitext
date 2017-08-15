package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;

/**
 * Created by Administrator on 2017/8/5.
 */

public class ReceivablesAdapter extends BaseAdapter {
    private Activity context;
    private Receivables_items_Adapter receivables_items_adapter;

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
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }
        receivables_items_adapter = new Receivables_items_Adapter(context);
        myViewHolder.expandListView.setAdapter(receivables_items_adapter);
        return convertView;
    }

    static class Holder {
        LinearLayout cxbj;
        private ImageView cancle;
        private ExpandListView expandListView;
        private TextView number;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }
}

