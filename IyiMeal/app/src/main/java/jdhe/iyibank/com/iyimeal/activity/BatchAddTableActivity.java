package jdhe.iyibank.com.iyimeal.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.entity.BatchAddTableBean;
import jdhe.iyibank.com.iyimeal.interface_all.IBatchAddTableView;
import jdhe.iyibank.com.iyimeal.mvp.presenter.BatchAddTablePresenter;

public class BatchAddTableActivity extends BaseActivity implements IBatchAddTableView {
    @BindView(R.id.nub)
    EditText nub;

    @BindView(R.id.areaet)
    EditText areaet;

    @BindView(R.id.down_nub)
    EditText down_nub;

    @BindView(R.id.room_charge)
    EditText room_charge;

    @BindView(R.id.mealfee)
    EditText mealfee;
    private BatchAddTablePresenter batchAddTablePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_batch);
        super.onCreate(savedInstanceState);
        initTitle();
        logo.setVisibility(View.GONE);
        title_wen.setVisibility(View.VISIBLE);
        initview();
    }

    private void initview() {
        batchAddTablePresenter = new BatchAddTablePresenter(this);
        title_wen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                batchAddTablePresenter.setModle(getAddNub(), getArea(), getdownNub(), getRoomFee(), getMealFee());
                try {
                    batchAddTablePresenter.startActivivty();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.nub, R.id.areaet, R.id.down_nub, R.id.room_charge, R.id.mealfee};
        return ids;
    }

    @Override
    public String getAddNub() {
        return nub.getText().toString().trim();
    }

    @Override
    public String getArea() {
        return areaet.getText().toString().trim();
    }

    @Override
    public String getdownNub() {
        return down_nub.getText().toString().trim();
    }

    @Override
    public String getRoomFee() {
        return room_charge.getText().toString().trim();
    }

    @Override
    public String getMealFee() {
        return mealfee.getText().toString().trim();
    }

    @Override
    public void startNextActivity(BatchAddTableBean batchAddTableBean) {
        try {
            startActivity(new Intent(this, BatchTablelistActivity.class).putExtra("Bean", batchAddTableBean));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
