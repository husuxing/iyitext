package jdhe.iyibank.com.iyimeal.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017/8/18.
 */

public class BatchAddTableBean implements Parcelable{
    public BatchAddTableBean(Parcel in) {
        nub = in.readString();
        seatNum = in.readString();
        areaet = in.readString();
        down_nub = in.readString();
        room_charge = in.readString();
        mealfee = in.readString();
    }
    public BatchAddTableBean() {
    }

    public BatchAddTableBean(String nub,String seatNum, String areaet, String down_nub, String room_charge, String mealfee) {
        this.nub = nub;
        this.seatNum = seatNum;
        this.areaet = areaet;
        this.down_nub = down_nub;
        this.room_charge = room_charge;
        this.mealfee = mealfee;
    }

    private String nub;
    private String seatNum;
    private String areaet;
    private String down_nub;
    private String room_charge;
    private String mealfee;

    public String getAreaet() {
        return areaet;
    }

    public void setAreaet(String areaet) {
        this.areaet = areaet;
    }

    public String getDown_nub() {
        return down_nub;
    }
    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }
    public void setDown_nub(String down_nub) {
        this.down_nub = down_nub;
    }

    public String getRoom_charge() {
        return room_charge;
    }

    public void setRoom_charge(String room_charge) {
        this.room_charge = room_charge;
    }

    public String getMealfee() {
        return mealfee;
    }

    public void setMealfee(String mealfee) {
        this.mealfee = mealfee;
    }
    public String getNub() {
        return nub;
    }

    public void setNub(String nub) {
        this.nub = nub;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nub);
        parcel.writeString(seatNum);
        parcel.writeString(areaet);
        parcel.writeString(down_nub);
        parcel.writeString(room_charge);
        parcel.writeString(mealfee);
    }

    public static final Creator<BatchAddTableBean> CREATOR = new Creator<BatchAddTableBean>() {
        @Override
        public BatchAddTableBean createFromParcel(Parcel in) {
            return new BatchAddTableBean(in);
        }

        @Override
        public BatchAddTableBean[] newArray(int size) {
            return new BatchAddTableBean[size];
        }
    };
}
