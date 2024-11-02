package com.bao.listviewnangcao;

public class City {
    private String cityName;
    private int hinh;
    private String link;

    public City() {
    }

    public City(String cityName, int hinh, String link) {
        this.cityName = cityName;
        this.hinh = hinh;
        this.link = link;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
