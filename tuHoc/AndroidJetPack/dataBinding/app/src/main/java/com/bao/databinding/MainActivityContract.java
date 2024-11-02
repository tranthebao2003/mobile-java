package com.bao.databinding;

public interface MainActivityContract {

//    interface con ben trong interface MainActivityContract
    public interface Presenter{
        void onShowData(StudentData studentData);
    }

//    interface con ben trong interface MainActivityContract
    public interface View{
        void showData(StudentData studentData);
    }
}
