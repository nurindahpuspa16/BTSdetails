package com.example.bts_details;

import android.os.Parcel;
import android.os.Parcelable;

public class BTSDetails {
    private String name, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BTSDetails() {
    }
    protected BTSDetails(Parcel in) {
        this.name = in.readString();
        this.photo = in.readString();
    }
    public static final Parcelable.Creator<BTS> CREATOR = new Parcelable.Creator<BTS>() {
        @Override
        public BTS createFromParcel(Parcel source) {
            return new BTS(source);
        }
        @Override
        public BTS[] newArray(int size) {
            return new BTS[size];
        }
    };
}