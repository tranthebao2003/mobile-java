package com.bao.retrofit;

import com.google.gson.annotations.SerializedName;

// 1 model class
// json trả về trường của nó phải giống với những trường mình làm trong model
public class DataModel {
    // this class will be as a template for the data tha we are going to parse

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
