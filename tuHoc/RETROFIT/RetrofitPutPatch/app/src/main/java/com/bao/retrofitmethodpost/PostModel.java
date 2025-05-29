package com.bao.retrofitmethodpost;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    private String  title;

    @SerializedName("data")
    private String bodyPost;

    public PostModel(String title, String bodyPost) {
        this.title = title;
        this.bodyPost = bodyPost;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyPost() {
        return bodyPost;
    }

}
