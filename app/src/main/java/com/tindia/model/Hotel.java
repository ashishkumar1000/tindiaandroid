package com.tindia.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Hotel implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("hotel_image")
    private String hotel_image;
    @SerializedName("hotel_name")
    private String hotel_name;
    @SerializedName("hotel_address")
    private String hotel_address;
    @SerializedName("hotel_rating")
    private Float hotel_rating;
    @SerializedName("hotel_price")
    private int hotel_price;
    @SerializedName("belongs_to")
    private int belongs_to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotel_image() {
        return hotel_image;
    }

    public void setHotel_image(String hotel_image) {
        this.hotel_image = hotel_image;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public Float getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(Float hotel_rating) {
        this.hotel_rating = hotel_rating;
    }

    public int getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(int hotel_price) {
        this.hotel_price = hotel_price;
    }

    public int getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(int belongs_to) {
        this.belongs_to = belongs_to;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.hotel_image);
        dest.writeString(this.hotel_name);
        dest.writeString(this.hotel_address);
        dest.writeFloat(this.hotel_rating);
        dest.writeInt(this.hotel_price);
        dest.writeInt(this.belongs_to);
    }

    public Hotel(){

    }

    protected Hotel(Parcel in){
        this.id = in.readInt();
        this.hotel_image = in.readString();
        this.hotel_name = in.readString();
        this.hotel_address = in.readString();
        this.hotel_rating = in.readFloat();
        this.hotel_price = in.readInt();
        this.belongs_to = in.readInt();
    }

    public static final Parcelable.Creator<Hotel> CREATOR = new Parcelable.Creator<Hotel>(){
        @Override
        public Hotel createFromParcel(Parcel source) {
            return new Hotel(source);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };
}
