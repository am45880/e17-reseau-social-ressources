package com.arachidsocial.models;

/**
 * Created by yassine on 2017-05-31.
 */

import org.springframework.data.annotation.Id;

public class Ticket {

    @Id
    private String id;
    private String showName,artistName,date,place,price,buyerName;

    public Ticket() {}

    public Ticket(String id, String showName, String artistName, String date, String place, String price, String buyerName) {
        this.id = id;
        this.showName = showName;
        this.artistName = artistName;
        this.date = date;
        this.place = place;
        this.price = price;
        this.buyerName = buyerName;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerFirstName) {
        this.buyerName = buyerFirstName;
    }

}
