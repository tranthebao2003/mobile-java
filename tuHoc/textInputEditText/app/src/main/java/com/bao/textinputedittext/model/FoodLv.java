package com.bao.textinputedittext.model;

public class FoodLv {
    private int img;
    private String title;
    private String subTitle;
    private String price;

    public FoodLv(int img, String title, String subTitle, String price) {
        this.img = img;
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getPrice() {
        return price;
    }
}
