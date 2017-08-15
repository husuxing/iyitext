package jdhe.iyibank.com.iyimeal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddProductActivity;
import jdhe.iyibank.com.iyimeal.costomview.ProductDetailsPopupWindow;
import jdhe.iyibank.com.iyimeal.costomview.ProductPopupWindow;
import jdhe.iyibank.com.iyimeal.costomview.RoundRectImageView;

import static jdhe.iyibank.com.iyimeal.R.id.caidanll;


/**
 * Created by Administrator on 2017/5/8.
 */

public class AddProductListAdapter extends BaseAdapter implements View.OnClickListener{
    private Activity context;
    private ProductDetailsPopupWindow mPopWindow;
    private String partNub;

    public AddProductListAdapter(Activity context) {//, List<User> users, boolean isNearPeople) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return 20;
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
            convertView = View.inflate(context, R.layout.add_productitemlayout, null);
            myViewHolder.image= (RoundRectImageView) convertView.findViewById(R.id.imageview);
            myViewHolder.image_jia = (ImageView) convertView.findViewById(R.id.jiaimage);
            myViewHolder.image_jian = (ImageView) convertView.findViewById(R.id.jianimage);
            myViewHolder.parttv = (TextView) convertView.findViewById(R.id.parttv);
            convertView.setTag(myViewHolder);
        } else {
            myViewHolder = (ProductHolder) convertView.getTag();
        }
        myViewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopWindow = new ProductDetailsPopupWindow(context, this, "");
//                mPopWindow.showAsDropDown(view,1,1, Gravity.BOTTOM);
                mPopWindow.showAtLocation(view , Gravity.CENTER, 0, 0);
            }
        });
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

    @Override
    public void onClick(View view) {

    }

    static class ProductHolder{
        private RoundRectImageView image;
        private ImageView image_jia,image_jian;
        private TextView parttv;
        private TextView price;
        private TextView xiaolian;
        private TextView ranknub;
        private TextView state;
    }



}

