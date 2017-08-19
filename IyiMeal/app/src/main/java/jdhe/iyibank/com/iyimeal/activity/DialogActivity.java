package jdhe.iyibank.com.iyimeal.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import jdhe.iyibank.com.iyimeal.R;
import jdhe.iyibank.com.iyimeal.adapter.ReceivablesAdapter;
import jdhe.iyibank.com.iyimeal.adapter.Receivables_items_Adapter;
import jdhe.iyibank.com.iyimeal.app.BaseActivity;
import jdhe.iyibank.com.iyimeal.app.MyAppLication;
import jdhe.iyibank.com.iyimeal.costomview.ExpandListView;


public class DialogActivity extends BaseActivity implements OnClickListener {
    private Button confirm, cancel;
    private TextView mTextTitle;
    private TextView mTextMessage, mTextMessage1;
    private ProgressDialog pd1;
    private ScrollView mScrollView, dialog_scrolllist;
    private EditText mEditText, mEdtCode;
    private RadioGroup mRadioGroup;
    private String title, isnum, who, payId, isEdit, addcalss, issetMoneyll,
            isaddconsumer, iddialog_scrolllist, isyouhuijll,
            iszhekourl, isreceiabkles_shou, who_tab,position;
    private boolean isbutton;
    View heng;
    private LinearLayout addclassification, setMoneyll, addconsumer, youhuijll, receiabkles_shou;
    private ExpandListView expandListView;
    private Receivables_items_Adapter receivables_items_adapter;
    private RelativeLayout zhekourl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.dialog);
            receiabkles_shou = (LinearLayout) findViewById(R.id.receiabkles_shou);
            zhekourl = (RelativeLayout) findViewById(R.id.zhekourl);
            youhuijll = (LinearLayout) findViewById(R.id.youhuijll);
            dialog_scrolllist = (ScrollView) findViewById(R.id.dialog_scrolllist);
            setMoneyll = (LinearLayout) findViewById(R.id.setMoneyll);
            addconsumer = (LinearLayout) findViewById(R.id.addconsumer);
            addclassification = (LinearLayout) findViewById(R.id.addclassification);
            confirm = (Button) findViewById(R.id.btn_confirm);
            cancel = (Button) findViewById(R.id.btn_cancel);
            heng = (View) findViewById(R.id.heng);
            mTextTitle = (TextView) findViewById(R.id.dialog_title);
            mTextMessage = (TextView) findViewById(R.id.dialog_message);
//            mTextMessage1= (TextView) findViewById(R.id.dialog_message1);
            mEditText = (EditText) findViewById(R.id.dialog_edit);
//            mRadioGroup = (RadioGroup) findViewById(R.id.dialog_rg);
            mScrollView = (ScrollView) findViewById(R.id.dialog_scroll);
            mScrollView.setLayoutParams(new LayoutParams(MyAppLication.screenW, MyAppLication.screenH / 5 * 2));
            cancel.setOnClickListener(this);
            confirm.setOnClickListener(this);
            pd1 = new ProgressDialog(this);
            pd1.setMessage("请稍等...");
            pd1.setCancelable(true);
            if ("0".equals(isnum)) {
                confirm.setVisibility(View.GONE);
            }
            isreceiabkles_shou = getIntent().getStringExtra("isreceiabkles_shou");
            if ("0".equals(isreceiabkles_shou)) {
                receiabkles_shou.setVisibility(View.VISIBLE);
            }
            who_tab = getIntent().getExtras().getString("who_tab", "");
            iszhekourl = getIntent().getStringExtra("iszhekourl");
            if ("0".equals(iszhekourl)) {
                zhekourl.setVisibility(View.VISIBLE);
            }
            position = getIntent().getExtras().getString("position", "");
            iddialog_scrolllist = getIntent().getStringExtra("iddialog_scrolllist");
            if ("0".equals(iddialog_scrolllist)) {
                dialog_scrolllist.setVisibility(View.VISIBLE);
                expandListView = (ExpandListView) findViewById(R.id.listview);
                receivables_items_adapter = new Receivables_items_Adapter(this);
                expandListView.setAdapter(receivables_items_adapter);
            }

            isyouhuijll = getIntent().getStringExtra("isyouhuijll");
            if ("0".equals(isyouhuijll)) {
                youhuijll.setVisibility(View.VISIBLE);
            }

            isaddconsumer = getIntent().getStringExtra("isaddconsumer");
            if ("0".equals(isaddconsumer)) {
                addconsumer.setVisibility(View.VISIBLE);
            }
            issetMoneyll = getIntent().getStringExtra("issetMoneyll");
            if ("0".equals(issetMoneyll)) {
                setMoneyll.setVisibility(View.VISIBLE);
            }
            addcalss = getIntent().getStringExtra("addcalss");
            if ("0".equals(addcalss)) {
                addclassification.setVisibility(View.VISIBLE);
            }
            isEdit = getIntent().getStringExtra("isedit");
            if ("0".equals(isEdit)) {
                mEditText.setVisibility(View.VISIBLE);
                heng.setVisibility(View.VISIBLE);
            }

            String msg = getIntent().getStringExtra("msg");
//            String msg1 = getIntent().getStringExtra("msg1");

            who = getIntent().getExtras().getString("who", "");
            title = getIntent().getExtras().getString("title", "");
            payId = getIntent().getExtras().getString("payId", "");
            isbutton = getIntent().getExtras().getBoolean("isbutton");
            if (!isbutton) {
                cancel.setVisibility(View.GONE);
            }
            if (title != null) {
                if (title.equals(getResources().getString(R.string.shopTipe))) {
                    cancel.setTextColor(getResources().getColor(R.color.near_shop_time_bg));
                    confirm.setTextColor(getResources().getColor(R.color.pressblue));
                    cancel.setText("继续做生意");
                    confirm.setText("打烊休息");
                    mTextMessage.setTextSize(13);
                    mTextMessage.setTextColor(getResources().getColor(R.color.text_medium_gray_color));
                }
            }
            if (!TextUtils.isEmpty(msg)) {
                mTextMessage.setText(Html.fromHtml(msg));
            }
//            if (!TextUtils.isEmpty(msg1)) {
//                mTextMessage.setText(Html.fromHtml(msg1));
//            }
            if (!TextUtils.isEmpty(title)) {
                mTextTitle.setText(title);
            } else {
                mTextTitle.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_confirm:
                try {
                    if ("delete".equals(who)) {
                        setResult(RESULT_OK, new Intent());
                    }
                    if ("BatchTablelistActivity".equals(who)) {
                        Intent intent = new Intent(this, TableSetActivity.class).putExtra("who","DialogActivity");//.putExtra("who", "DialogActivity");//.putExtra("dataPosition", getIntent().getExtras().getInt("dataPosition")
                        startActivity(intent);
                    }
                    if ("AreaSetAdapterdelete".equals(who)) {
                        setResult(RESULT_OK, new Intent().putExtra("position",position+""));
                    }
                    if ("AreaSetAdapterdelete_2".equals(who)) {
                        setResult(RESULT_OK, new Intent().putExtra("position",position+"").putExtra("name",mEditText.getText().toString()));
                    }

                    if ("ScanColletionActivity".equals(who)) {
                        String name = getIntent().getExtras().getString("payname");
                        setResult(RESULT_OK, new Intent().putExtra("payId", payId).putExtra("payname", name));
                    }
                    if ("tab_main1".equals(who_tab)) {
                        Intent intent = new Intent(this, AddProductActivity.class).putExtra("who", "DialogActivity");//.putExtra("dataPosition", getIntent().getExtras().getInt("dataPosition")
                        startActivity(intent);
                    }
                    if ("tab_main3".equals(who_tab)) {
                        Intent intent = new Intent(this, AddProductActivity.class).putExtra("who", "DialogActivity");//.putExtra("dataPosition", getIntent().getExtras().getInt("dataPosition")
                        startActivity(intent);
                    }

                    if ("0".equals(isEdit)&&"AreaAetActivity".equals(who)) {
                        setResult(RESULT_OK, new Intent().putExtra("areaname", mEditText.getText().toString()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finish();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public int[] hideSoftByEditViewIds() {
        int[] ids = {R.id.dialog_edit};
        return ids;
    }
}
