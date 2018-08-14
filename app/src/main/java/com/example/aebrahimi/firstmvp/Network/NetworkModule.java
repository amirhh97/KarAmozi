package com.example.aebrahimi.firstmvp.Network;

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
public class NetworkModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }
    @Provides
    @Singleton
    Gson gsonProvider()
    {
        return new GsonBuilder().create();
    }   
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient)
    {
        return new Retrofit.Builder().baseUrl("").client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
    @Provides
    @Singleton
    GiphyApi provideApi(Retrofit retrofit)
    {
        return retrofit.create(GiphyApi.class);
    }
}
