package com.bao.gridviewcustom.model;

public class Logo {
    private final Integer inconId;
    private final String letters;

    public Logo(Integer inconId, String letters) {
        this.inconId = inconId;
        this.letters = letters;
    }

    public Integer getInconId() {
        return inconId;
    }

    public String getLetters() {
        return letters;
    }
}
