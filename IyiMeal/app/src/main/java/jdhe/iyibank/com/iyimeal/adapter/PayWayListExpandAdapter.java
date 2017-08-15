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
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;

/**
 * Created by Administrator on 2017/8/7.
 */

public class PayWayListExpandAdapter extends BaseAdapter {
    private Activity context;
    private String who;

    public PayWayListExpandAdapter(Activity context,String who) {//, List<User> users, boolean isNearPeople) {
        this.context = context;
        this.who = who;

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
            convertView = View.inflate(context, R.layout.paywaylistexpand_layout, null);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (Holder) convertView.getTag();
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("Receivables_ConsumerActivity".equals(who)){
                    context.startActivity(new Intent(context, DialogActivity.class)
                            .putExtra("title", "收款").putExtra("msg", "")
                            .putExtra("isbutton", true).putExtra("isreceiabkles_shou", "0")
                    );
                }else if("ProductRenewFragment".equals(who)){
                    context.startActivity(new Intent(context, DialogActivity.class)
                            .putExtra("title", "支付宝付款").putExtra("msg", "需要付款：100元"+"\n"+"购买时间：2个月")
                            .putExtra("isbutton", true)
                    );
                }

            }
        });
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
