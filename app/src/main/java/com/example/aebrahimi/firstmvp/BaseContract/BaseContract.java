package com.example.aebrahimi.firstmvp.BaseContract;

/**
 * Created by aebrahimi on 8/14/2018 AD.
 */

public interface BaseContract {
    interface Presenter
    {

    }
    interface View
    {
        void showProgress();
        void hideProgress();
    }
}
