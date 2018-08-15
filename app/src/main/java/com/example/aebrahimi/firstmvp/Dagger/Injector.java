package com.example.aebrahimi.firstmvp.Dagger;

import com.example.aebrahimi.firstmvp.ListContract.ListView;
import com.example.aebrahimi.firstmvp.ShowContract.ShowView;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by aebrahimi on 8/15/2018 AD.
 */
@Singleton
@Component(modules = {NetworkModule.class, PresenterModule.class})
public interface Injector {
    void inject(ListView view);

    void inject(ShowView view);

}
