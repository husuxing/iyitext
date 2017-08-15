package jdhe.iyibank.com.iyimeal.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/4/12.
 */
public class FilterGridData implements Parcelable {
    public FilterGridData(String values, boolean isLastColums, boolean isChecked, int tag, int supid, String payWayId) {
        this.values = values;
        this.isLastColums = isLastColums;
        this.isChecked = isChecked;
        this.tag = tag;
        this.supid = supid;
        this.payWayId = payWayId;
    }
    private String values;

    public String getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(String payWayId) {
        this.payWayId = payWayId;
    }

    private String payWayId;



    private boolean isLastColums;
    private boolean isChecked;
    private int tag = -1;
    private int supid;

    public int getSupid() {
        return supid;
    }

    public void setSupid(int supid) {
        this.supid = supid;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isLastColums() {
        return isLastColums;
    }

    public void setLastColums(boolean lastColums) {
        isLastColums = lastColums;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

//    public FilterGridData() {
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.values);
        dest.writeByte(isLastColums ? (byte) 1 : (byte) 0);
        dest.writeByte(isChecked ? (byte) 1 : (byte) 0);
        dest.writeInt(this.tag);
        dest.writeInt(this.supid);
        dest.writeString(this.payWayId);
    }

    protected FilterGridData(Parcel in) {
        this.values = in.readString();
        this.isLastColums = in.readByte() != 0;
        this.isChecked = in.readByte() != 0;
        this.tag = in.readInt();
        this.supid = in.readInt();
        this.payWayId = in.readString();
    }

    public static final Creator<FilterGridData> CREATOR = new Creator<FilterGridData>() {
        @Override
        public FilterGridData createFromParcel(Parcel source) {
            return new FilterGridData(source);
        }

        @Override
        public FilterGridData[] newArray(int size) {
            return new FilterGridData[size];
        }
    };
}
