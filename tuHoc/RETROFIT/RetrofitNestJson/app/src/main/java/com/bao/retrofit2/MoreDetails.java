package com.bao.retrofit2;

public class MoreDetails {
    // model class for details details data
    private String release;
    private String category;
    private String duration;

    public MoreDetails(String release, String category, String duration) {
        this.release = release;
        this.category = category;
        this.duration = duration;
    }

    //getters
    public String getRelease() {
        return release;
    }

    public String getCategory() {
        return category;
    }

    public String getDuration() {
        return duration;
    }
}
