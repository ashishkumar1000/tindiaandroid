package com.tindia.model;

import com.google.gson.annotations.SerializedName;

public class Destination {
    @SerializedName("id")
    private int id;
    @SerializedName("dest_name")
    private String dest_name;
    @SerializedName("image_url")
    private String image_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDest_name() {
        return dest_name;
    }

    public void setDest_name(String dest_name) {
        this.dest_name = dest_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
