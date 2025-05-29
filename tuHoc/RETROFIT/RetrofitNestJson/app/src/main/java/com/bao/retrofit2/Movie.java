package com.bao.retrofit2;

import com.google.gson.annotations.SerializedName;

public class Movie {
    //model class
    private int id;
    private String title;
    private float rating;
    private String poster;

    //we need to make object of class details
    // Different name from json, so we need to serialize it
    @SerializedName("details")
    private MoreDetails moreDetails;

//    constructor


    public Movie(int id, String title, float rating, String poster, MoreDetails moreDetails) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.poster = poster;
        this.moreDetails = moreDetails;
    }

    //    getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(MoreDetails moreDetails) {
        this.moreDetails = moreDetails;
    }
}
