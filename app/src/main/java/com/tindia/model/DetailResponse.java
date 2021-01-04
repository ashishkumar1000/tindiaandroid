package com.tindia.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailResponse {
    private List<DetailPlace> place;
    private List<Hotel> hotel;
    private List<Transport> transport;
    private List<Food> food;

    public List<DetailPlace> getPlace() {
        return place;
    }

    public void setPlace(List<DetailPlace> place) {
        this.place = place;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public List<Transport> getTransport() {
        return transport;
    }

    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
