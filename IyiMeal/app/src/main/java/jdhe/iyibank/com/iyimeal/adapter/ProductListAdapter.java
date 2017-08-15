package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;


/**
 * Created by Administrator on 2017/5/8.
 */

public class ProductListAdapter extends BaseAdapter {
    private Activity context;
    private String partNub;

    public ProductListAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
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
            convertView = View.inflate(context, R.layout.productlistitemlayout, null);
            myViewHolder.image_jia = (ImageView) convertView.findViewById(R.id.jiaimage);
            myViewHolder.image_jian = (ImageView) convertView.findViewById(R.id.jianimage);
            myViewHolder.parttv = (TextView) convertView.findViewById(R.id.parttv);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (ProductHolder) convertView.getTag();
        }

        final ProductHolder finalMyViewHolder = myViewHolder;
        myViewHolder.image_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    partNub = finalMyViewHolder.parttv.getText().toString();
                    int partI = Integer.valueOf(partNub);
                    if (partI < 99) {//限制范围0到99
                        partI++;
                        finalMyViewHolder.parttv.setText(partI + "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        myViewHolder.image_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    partNub = finalMyViewHolder.parttv.getText().toString();
                    int partI = Integer.valueOf(partNub);
                    if (partI > 0) {
                        partI--;
                        finalMyViewHolder.parttv.setText(partI + "");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return convertView;
    }

    static class ProductHolder {
        private ImageView image_jian, image_jia;
        private TextView parttv;
        private TextView price;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }


}

