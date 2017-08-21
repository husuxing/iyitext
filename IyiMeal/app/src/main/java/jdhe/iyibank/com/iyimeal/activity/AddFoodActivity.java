package jdhe.iyibank.com.iyimeal.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.yalantis.ucrop.UCrop;
import com.zhy.base.fileprovider.FileProvider7;

import java.io.File;
import java.util.List;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.costomview.CameraPopupWindow;
import jdhe.iyibank.com.iyimeal.util.LogTool;
import jdhe.iyibank.com.iyimeal.util.ToastUtils;

public class AddFoodActivity extends BaseActivity implements View.OnClickListener {
    private CameraPopupWindow mPopWindow;
    private int REQUEST_CODE_CAMERA = 1000;
    private File file;
    private Uri photoUri;
    private boolean tag;
    private Uri uri = null;
    private RelativeLayout imagell;

    private static final int REQUEST_SELECT_PICTURE = 0x01;
    private static final int TAKE_PHOTO = 1008;
    ImageView image;
    Button comfirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        initTitle();
        logo.setVisibility(View.GONE);
//        title_sc.setVisibility(View.VISIBLE);


//        title_wen.setVisibility(View.VISIBLE);
        initview();
    }

    private void initview() {
        comfirmBtn = (Button) findViewById(R.id.comfirmBtn);
        image = (ImageView) findViewById(R.id.imageiv);
        imagell = (RelativeLayout) findViewById(R.id.imagell);
        onclickWay();
        String who = getIntent().getExtras().getString("who", "");
        if ("FootFragmentAdapter".equals(who)) {
            mBaseTitle.setText("编辑菜品");
            comfirmBtn.setText("保存");
        } else {
            mBaseTitle.setText("添加菜品");
        }
    }

    private void onclickWay() {
        imagell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                //6.0权限处理
                Acp.getInstance(AddFoodActivity.this).request(new AcpOptions.Builder().setPermissions(
                        Manifest.permission.CAMERA).build(), new AcpListener() {
                    @Override
                    public void onGranted() {
                        mPopWindow = new CameraPopupWindow(AddFoodActivity.this, AddFoodActivity.this, "CAMERA_onclick");//"CAMERA_onclick"
                        mPopWindow.showAtLocation(view, Gravity.BOTTOM
                                | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
                    }


                    @Override
                    public void onDenied(List<String> permissions) {
//                        ToastUtils.makeText(AddFoodActivity.this, permissions.get(0));
                    }
                });


            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (resultCode == RESULT_OK) {
                if (requestCode == REQUEST_SELECT_PICTURE) {//相册返回
                    final Uri selectedUri = data.getData();
                    if (selectedUri != null) {
                        LogTool.i("相册path---->" + selectedUri.getPath());
                        mPopWindow.startCropActivity(selectedUri);
                    } else {
                    }
                } else if (requestCode == TAKE_PHOTO) {
                    Uri uri = null;
                    if (data != null && data.getData() != null) {
                        uri = data.getData();
                    } else {
                        if (CameraPopupWindow.photoUri != null) {
                            uri = CameraPopupWindow.photoUri;
                        }
                    }
                    mPopWindow.startCropActivity(uri);
                } else if (requestCode == 1000) {

                    if (data != null && data.getData() != null) {
                        uri = data.getData();
                    } else {
                        if (photoUri != null) {
                            uri = photoUri;
                        }
                    }
//                    Glide.with(AddProductActivity.this).load(uri)
//                            .into(imageView);
                    tag = true;
                } else if (requestCode == UCrop.REQUEST_CROP) {//裁剪
                    uri = UCrop.getOutput(data);
                    Glide.with(AddFoodActivity.this).load(uri)
                            .into(image);
                    tag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.chinese_name, R.id.english_name, R.id.pinying, R.id.product_nmb, R.id.product_xh, R.id.product_unitprice
                , R.id.consumerprice, R.id.Special_Offer, R.id.measurement_unit, R.id.subordinate_classification, R.id.dishes_specifications};
        return ids;
    }

    @Override

    public void onRequestPermissionsResult
            (int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //权限获取成功
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + "camera.jpg");
                photoUri = FileProvider7.getUriForFile(this, file);//FileProvider7.getUriForFile(activity   Uri.fromFile
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, 1008);

            } else {
                //权限被拒绝
                ToastUtils.makeText(this, "Permission Denied");
            }

        }

    }
}