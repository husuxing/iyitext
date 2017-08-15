package jdhe.iyibank.com.iyimeal.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/8/7.
 */

public class TableGridViewData implements Parcelable {


    public TableGridViewData(String values, String payWayId, boolean isChecked, int tag,int imageid) {
        this.values = values;
        this.payWayId = payWayId;
        this.isChecked = isChecked;
        this.tag = tag;
        this.imageid = imageid;
    }

    private String payWayId;
    private boolean isChecked;
    private int tag = -1;
    private String values;
    private int imageid ;



    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(String payWayId) {
        this.payWayId = payWayId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.values);
        dest.writeByte(isChecked ? (byte) 1 : (byte) 0);
        dest.writeInt(this.tag);
        dest.writeInt(this.imageid);
        dest.writeString(this.payWayId);
    }

    protected TableGridViewData(Parcel in) {
        this.values = in.readString();
        this.isChecked = in.readByte() != 0;
        this.tag = in.readInt();
        this.imageid = in.readInt();
        this.payWayId = in.readString();
    }

    public static final Creator<TableGridViewData> CREATOR = new Creator<TableGridViewData>() {
        @Override
        public TableGridViewData createFromParcel(Parcel source) {
            return new TableGridViewData(source);
        }

        @Override
        public TableGridViewData[] newArray(int size) {
            return new TableGridViewData[size];
        }
    };
}
