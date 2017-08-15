package jdhe.iyibank.com.iyimeal.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.entity.FilterGridData;
import jdhe.iyibank.com.iyimeal.util.ViewHolder;

/**
 * Created by Administrator on 2017/8/4.
 */

public class ProductRenewGridAdapter extends BaseAdapter {
    private Context context;
    private List<FilterGridData> filterGridDataList;
    private int flag;

    public ProductRenewGridAdapter(Context context, List<FilterGridData> filterGridDataList, int flag) {
        this.context = context;
        this.filterGridDataList = filterGridDataList;
        this.flag = flag;
    }

    public void setFilterGridDataList(List<FilterGridData> filterGridDataList) {
        this.filterGridDataList = filterGridDataList;
    }

    @Override
    public int getCount() {
        return filterGridDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return filterGridDataList.get(i).getValues();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.list_grid_item, null);
        FilterGridData filterGridData = filterGridDataList.get(i);

        TextView mTextVlues = ViewHolder.get(view, R.id.txt_filter_people_value);
        mTextVlues.setText(filterGridData.getValues());
        if ((i + 1) % 3 == 0) {
//            view1.setVisibility(View.GONE);
        } else {
//            view1.setVisibility(View.VISIBLE);
        }
        if (filterGridData.isLastColums()) {
//            paltView.setVisibility(View.GONE);
        } else {
//            paltView.setVisibility(View.VISIBLE);
        }
        if (flag == 1)
            if (filterGridData.isChecked()) {
//                mImageChecked.setVisibility(View.VISIBLE);
            } else {
//                mImageChecked.setVisibility(View.GONE);
            }
        if (flag == 0) {
            if (filterGridData.getTag() == i) {
//                mTextVlues.setBackgroundColor(context.getResources().getColor(R.color.red));
                mTextVlues.setBackground(ContextCompat.getDrawable(context, R.drawable.corners_red_4));
                mTextVlues.setTextColor(ContextCompat.getColor(context, R.color.white));
            } else {
//                mTextVlues.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
                mTextVlues.setBackground(ContextCompat.getDrawable(context, R.drawable.corners_wthit_4));
                mTextVlues.setTextColor(ContextCompat.getColor(context, R.color.text_medium_gray_color));
            }

        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int j = 0; j < filterGridDataList.size(); j++) {
                    filterGridDataList.get(j).setTag(-1);
                }
                filterGridDataList.get(i).setTag(i);
                if (filterGridDataList.get(i).isChecked()) {
                    filterGridDataList.get(i).setChecked(false);
                } else {
                    filterGridDataList.get(i).setChecked(true);
                }
                if (flag == 1) {
//                    NearShopFilter.getInstance().notifyText(filterGridDataList);
                } else if (flag == 0) {
//                    mTextSubmit.setText("确定");
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }


    public int getTag(List<FilterGridData> filterGridDataList) {
        int i = 0;
        for (int j = 0; j < filterGridDataList.size(); j++) {
            if (filterGridDataList.get(j).getTag() == j) {
                i=j;
            }
        }
        return i;
    }
}