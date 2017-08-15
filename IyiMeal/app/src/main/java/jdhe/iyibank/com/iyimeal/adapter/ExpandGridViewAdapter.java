package jdhe.iyibank.com.iyimeal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.activity.AddProductActivity;
import jdhe.iyibank.com.iyimeal.entity.TableGridViewData;
import jdhe.iyibank.com.iyimeal.fragment.DcFragment;

/**
 * Created by Administrator on 2017/5/5.
 */

public class ExpandGridViewAdapter extends BaseAdapter {
    private Context context;
    List<String[]> sArrStrings;
    List<TableGridViewData> tableGridViewDatas;
    int[] stringId = {R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0
            , R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0
            , R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0
            , R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0
            , R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0, R.mipmap.dc_0};
    //    String[] stringName = {"销售订单","扫描收款","统计","店铺管理","员工管理","菜品管理","菜品类别","预定管理","外卖设置","桌台设置","二维码管理","参数配置"};
    private DcFragment dcFragment;

    public ExpandGridViewAdapter(Context context, List<TableGridViewData> tableGridViewDatas, DcFragment dcFragment) {
        this.context = context;
        this.dcFragment = dcFragment;
        this.tableGridViewDatas = tableGridViewDatas;
    }

    public void setsArrStrings(List<String[]> sArrStrings) {
        this.sArrStrings = sArrStrings;
    }

    @Override
    public int getCount() {
        return tableGridViewDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return tableGridViewDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        try {
            MyViewHolder myViewHolder = null;
            if (convertView == null) {
                myViewHolder = new MyViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.dc_expandgridview_layout, null);
                myViewHolder.mIv = (ImageView) convertView.findViewById(R.id.gridview_imageview);
                myViewHolder.mtvg = (ImageView) convertView.findViewById(R.id.imageview);
                convertView.setTag(myViewHolder);
            } else {
                myViewHolder = (MyViewHolder) convertView.getTag();
            }
            if (tableGridViewDatas.get(position).getTag() == 0) {
                myViewHolder.mIv.setImageResource(R.mipmap.dc_0);
            } else if (tableGridViewDatas.get(position).getTag() == 1) {
                myViewHolder.mIv.setImageResource(R.mipmap.dc_1);
            } else if (tableGridViewDatas.get(position).getTag() == 2) {
                myViewHolder.mIv.setImageResource(R.mipmap.dc_2);
            }

            final MyViewHolder finalMyViewHolder = myViewHolder;
            if (tableGridViewDatas.get(position).isChecked()) {
                finalMyViewHolder.mtvg.setVisibility(View.VISIBLE);
            } else {
                finalMyViewHolder.mtvg.setVisibility(View.GONE);
            }
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tableGridViewDatas.get(position).isChecked()) {
                        finalMyViewHolder.mtvg.setVisibility(View.GONE);
                        tableGridViewDatas.get(position).setChecked(false);
                        dcFragment.setTab_main(false, false, false, false,false);
                    } else {
                        finalMyViewHolder.mtvg.setVisibility(View.VISIBLE);
                        for (TableGridViewData tableGridViewData : tableGridViewDatas) {
                            tableGridViewData.setChecked(false);
                        }
                        tableGridViewDatas.get(position).setChecked(true);
                        if (tableGridViewDatas.get(position).getTag() == 0) {
                            dcFragment.setlianllState();
                            dcFragment.setTab_main(true, false, false, false,false);
                        } else if (tableGridViewDatas.get(position).getTag() == 1) {
                            dcFragment.setlianllState();
                            context.startActivity(new Intent(context, AddProductActivity.class).putExtra("who","ExpandGridViewAdapter"));
//                            dcFragment.setTab_main(false, false, false, false);
                        } else if (tableGridViewDatas.get(position).getTag() == 2) {
                            dcFragment.setTab_main(false, true, true, true,true);
                        }
                    }
                    notifyDataSetChanged();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertView;
    }

    public void clear() {
        this.sArrStrings.clear();
    }

    class MyViewHolder {
        private TextView mTextName;
        private ImageView mIv, mtvg;

    }

}
