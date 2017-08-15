package jdhe.iyibank.com.iyimeal.costomview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yalantis.ucrop.UCrop;

import java.io.File;

import jdhe.iyibank.com.iyimeal.R;

/**
 * Created by Administrator on 2017/8/15.
 */

public class YhPopupWindow extends PopupWindow {

    private TextView biaot;
    private Button btnzk, btnyh;
    private View mMenuView, kong;
    private Activity activity;
    public static Uri photoUri;
    private File file;
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage.jpg";
    private Uri mDestinationUri;//目标uri

    public YhPopupWindow(Activity context, View.OnClickListener itemsOnClick, String type) {
        super(context);
        try {
            activity = context;

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mMenuView = inflater.inflate(R.layout.yh_items_pop, null);
            kong = mMenuView.findViewById(R.id.kon);
            kong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        YhPopupWindow.this.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            btnzk = (Button) mMenuView.findViewById(R.id.btnzk);
            btnyh = (Button) mMenuView.findViewById(R.id.btnyh);
            btnyh.setOnClickListener(itemsOnClick);
            btnzk.setOnClickListener(itemsOnClick);
            this.setContentView(mMenuView);
            this.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
            this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            this.setFocusable(true);
            this.setAnimationStyle(R.style.AnimBottom);
            ColorDrawable dw = new ColorDrawable(0x00000000);
            this.setBackgroundDrawable(dw);
            mMenuView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                    int y = (int) event.getY();
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        if (y < height) {
                            dismiss();
                        }
                    }
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

