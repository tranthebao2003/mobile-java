package com.bao.databinding;

import android.content.Context;

//Class nay chính là presenter

//MainActivityContract.Presenter: Presenter là interface con ben trong interface MainActivityContract
public class MainActivityPresenter implements MainActivityContract.Presenter{

    //MainActivityContract.View: View là interface con ben trong interface MainActivityContract
    private MainActivityContract.View view;
    private Context context;

    public MainActivityPresenter(MainActivityContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

//    no xai duoc method nay do no implements MainActivityContract.Presenter
    @Override
    public void onShowData(StudentData studentData) {
//      view.showData: được viết bên trong class mainActivity
        view.showData(studentData);
    }
}
