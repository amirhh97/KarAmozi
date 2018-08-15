package com.example.aebrahimi.firstmvp.Dagger;

import com.example.aebrahimi.firstmvp.ListContract.ListContract;
import com.example.aebrahimi.firstmvp.ListContract.ListPresenterImp;
import com.example.aebrahimi.firstmvp.Network.GiphyApi;
import com.example.aebrahimi.firstmvp.ShowContract.ShowContract;
import com.example.aebrahimi.firstmvp.ShowContract.ShowPresenterImp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aebrahimi on 8/14/2018 AD.
 */
@Module
public class PresenterModule {

    @Provides
    ListContract.Presenter provideShowPresenter(GiphyApi api) {
        return new ListPresenterImp(api) ;
    }

    @Provides
    ShowContract.Presenter provideListPresenter(GiphyApi api) {
        return new ShowPresenterImp(api) ;
    }

}
