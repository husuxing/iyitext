package jdhe.iyibank.com.iyimeal.costomview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.io.File;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.ProductListAdapter;


/**
 * Created by Administrator on 2017/1/12.
 */
public class ProductDetailsPopupWindow extends PopupWindow implements View.OnClickListener{

    private View mMenuView,kong;
    private Activity activity;
    private ListView listView;
    private ProductListAdapter productListAdapter0;
    RelativeLayout rll;
    LinearLayout ll;

    public ProductDetailsPopupWindow(Activity context, View.OnClickListener itemsOnClick, String type) {
        super(context);
        try {
            activity=context;

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mMenuView = inflater.inflate(R.layout.productdetails_popupwindowlayout, null);

            intview(mMenuView);



            this.setContentView(mMenuView);
            this.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
            this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            this.setFocusable(true);
//            this.setAnimationStyle(R.style.AnimBottom);
            ColorDrawable dw = new ColorDrawable(0x00000000);
            this.setBackgroundDrawable(dw);
//            mMenuView.setOnTouchListener(new View.OnTouchListener() {
//                public boolean onTouch(View v, MotionEvent event) {
//                    int height = mMenuView.findViewById(R.id.pop_layout).getTop();
//                    int y = (int) event.getY();
//                    if (event.getAction() == MotionEvent.ACTION_UP) {
//                        if (y < height) {
//                            dismiss();
//                        }
//                    }
//                    return true;
//                }
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void intview(View v) {
        rll= (RelativeLayout) v.findViewById(R.id.rll);
        ll= (LinearLayout) v.findViewById(R.id.ll);
        rll.setOnClickListener(this);
        ll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rll:
                if(v != ll){
                    this.dismiss();
                }
                break;
        }
    }


}
