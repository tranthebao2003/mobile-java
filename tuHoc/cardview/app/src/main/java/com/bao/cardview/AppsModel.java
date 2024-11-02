package com.bao.cardview;

public class AppsModel {
//    step 1: variables
    private String name;
    private int numofDownloads;
    private int thumbnail;

//    step 2: contructors


    public AppsModel() {
    }

    public AppsModel(String name, int numofDownloads, int thumbnail) {
        this.name = name;
        this.numofDownloads = numofDownloads;
        this.thumbnail = thumbnail;
    }

//   step 3: getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumofDownloads() {
        return numofDownloads;
    }

    public void setNumofDownloads(int numofDownloads) {
        this.numofDownloads = numofDownloads;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
