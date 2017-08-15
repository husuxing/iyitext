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
 * Created by Administrator on 2017/1/12.
 */
public class CameraPopupWindow extends PopupWindow implements View.OnClickListener{

    private TextView biaot;
    private Button btnUpload, btnEdit, btnRecord,btnCancel;
    private View mMenuView,kong;
    private Activity activity;
    public static Uri photoUri;
    private File file;
    private static final String SAMPLE_CROPPED_IMAGE_NAME = "SampleCropImage.jpg";
    private Uri mDestinationUri;//目标uri

    public CameraPopupWindow(Activity context, View.OnClickListener itemsOnClick, String type) {
        super(context);
        try {
            activity=context;

            mDestinationUri = Uri.fromFile(new File(activity.getCacheDir(), System.currentTimeMillis()+SAMPLE_CROPPED_IMAGE_NAME));
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mMenuView = inflater.inflate(R.layout.diy_zone_items_pop, null);
            kong= mMenuView.findViewById(R.id.kon);
            kong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        CameraPopupWindow.this.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            btnUpload = (Button) mMenuView.findViewById(R.id.btnUpload);
            btnEdit = (Button) mMenuView.findViewById(R.id.btnEditTone);
            btnRecord = (Button) mMenuView.findViewById(R.id.btnRecord);
            btnCancel = (Button) mMenuView.findViewById(R.id.btnCancel);
            if ("CAMERA".equals(type)) {
                btnUpload.setText("从手机相册选择");
//                btnEdit.setText("相册");
                btnRecord.setText("拍摄");
                btnCancel.setText("取消");
                btnEdit.setVisibility(View.GONE);

//                btnRecord.setTextColor(context.getResources().getColor(R.color.map_closs));
                btnEdit.setOnClickListener(itemsOnClick);
                btnUpload.setOnClickListener(itemsOnClick);
                btnRecord.setOnClickListener(itemsOnClick);
                btnCancel.setOnClickListener(itemsOnClick);
            }
            if ("CAMERA_onclick".equals(type)) {
                btnUpload.setText("从手机相册选择");
//                btnEdit.setText("相册");
                btnRecord.setText("拍摄");
                btnCancel.setText("取消");
                btnEdit.setVisibility(View.GONE);

//                btnRecord.setTextColor(context.getResources().getColor(R.color.map_closs));
                btnEdit.setOnClickListener(this);
                btnUpload.setOnClickListener(this);
                btnRecord.setOnClickListener(this);
                btnCancel.setOnClickListener(this);
            }


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
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRecord://相机
//                requestPermission(1, Manifest.permission.CAMERA, new Runnable() {
//                    @Override
//                    public void run() {
                        takePhoto();
//                    }
//                }, new Runnable() {
//                    @Override
//                    public void run() {
//                        ToastUtils.makeText(ImageViewPick.this, "取消操作");
//                    }
//                });
                dismiss();
                break;
            case R.id.btnUpload://图片选择
                pickFromGallery();
                dismiss();
                break;
            case R.id.btnCancel:
                dismiss();
                break;
        }
    }

    /**从相册取**/
    private void pickFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0x01);

    }
    /**拍照**/
    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + "camera.jpg");
        photoUri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        activity.startActivityForResult(intent, 1008);

//        Intent intentm = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + "camera.jpg");
//        photoUri = Uri.fromFile(file);
//        intentm.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
//        startActivityForResult(intentm, REQUEST_CODE_CAMERA);
    }

    public void startCropActivity(@NonNull Uri uri) {
//        switch (index) {
//            case 0:
                UCrop.of(uri, mDestinationUri)
                        .withAspectRatio(1, 1)
                        .start(activity);
//                break;
//            case 1:
//                UCrop.of(uri, mDestinationUri)
//                        .withAspectRatio(8, 5)
//                        .start(this);
//                break;
//            case 2:
//                break;
//        }
    }

}
