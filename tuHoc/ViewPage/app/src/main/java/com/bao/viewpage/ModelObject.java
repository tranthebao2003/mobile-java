package com.bao.viewpage;

public enum ModelObject {
//    defining layout colors:
    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.blue, R.layout.view_blue),
    GREEN(R.string.green, R.layout.view_green);

    private int mTitleResId;
    private int mLayoutResId;

//    constructor
//    giá trị R.string.green ("GREEN") sẽ duoc gán cho titleResId
//    sau do thong quan constructor gan cho this.mTitleResId
//    tuong tu R.layout.view_green se duoc gan cho layoutResId
//    cung thong qua constructor gan cho mLayoutResId
    ModelObject(int titleResId, int layoutResId){
        this.mTitleResId = titleResId;
        this.mLayoutResId = layoutResId;
    }

    public int getmTitleResId() {
        return mTitleResId;
    }

    public void setmTitleResId(int mTitleResId) {
        this.mTitleResId = mTitleResId;
    }

    public int getmLayoutResId() {
        return mLayoutResId;
    }

    public void setmLayoutResId(int mLayoutResId) {
        this.mLayoutResId = mLayoutResId;
    }
}
