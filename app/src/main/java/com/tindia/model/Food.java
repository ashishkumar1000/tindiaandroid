package com.tindia.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Food implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("food_image")
    private String food_image;
    @SerializedName("food_name")
    private String food_name;
    @SerializedName("food_desc")
    private String food_desc;
    @SerializedName("food_rating")
    private Float food_rating;
    @SerializedName("belongs_to")
    private int belongs_to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_desc() {
        return food_desc;
    }

    public void setFood_desc(String food_desc) {
        this.food_desc = food_desc;
    }

    public Float getFood_rating() {
        return food_rating;
    }

    public void setFood_rating(Float food_rating) {
        this.food_rating = food_rating;
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
        dest.writeString(this.food_image);
        dest.writeString(this.food_name);
        dest.writeString(this.food_desc);
        dest.writeFloat(this.food_rating);
        dest.writeInt(this.belongs_to);
    }

    public Food(){

    }

    protected Food(Parcel in){
        this.id = in.readInt();
        this.food_image = in.readString();
        this.food_name = in.readString();
        this.food_desc = in.readString();
        this.food_rating = in.readFloat();
        this.belongs_to = in.readInt();
    }

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>(){
        @Override
        public Food createFromParcel(Parcel source) {
            return new Food(source);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };
}
