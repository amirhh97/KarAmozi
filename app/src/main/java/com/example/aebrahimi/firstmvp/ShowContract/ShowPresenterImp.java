package com.example.aebrahimi.firstmvp.ShowContract;

import android.content.Intent;
import android.util.Log;

import com.example.aebrahimi.firstmvp.ListContract.ListContract;
import com.example.aebrahimi.firstmvp.Model.Item;
import com.example.aebrahimi.firstmvp.Model.ItemsModel;
import com.example.aebrahimi.firstmvp.Model.RandomModel;
import com.example.aebrahimi.firstmvp.Network.GiphyApi;
import com.example.aebrahimi.firstmvp.Network.RetrofitBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by aebrahimi on 8/14/2018 AD.
 */

public class ShowPresenterImp implements ShowContract.Presenter {
    ShowContract.View showActivity;
    public ShowPresenterImp(ShowContract.View view)
    {
        this.showActivity=view;
    }
    @Override
    public void getRandomItems() {
        GiphyApi api=new RetrofitBuilder().getApi();
        api.getRandoms(RetrofitBuilder.key).enqueue(new Callback<RandomModel>() {
            @Override
            public void onResponse(Call<RandomModel> call, Response<RandomModel> response) {
                RandomModel model=response.body();
                Item item=new Item();
                if(model.getData().getUser()!=null)
                item.setTitle(model.getData().getUser().getDisplay_name());
                item.setUrl(model.getData().getImage().getOriginalImage().getUrl());
                item.setOriginalUrl(model.getData().getImage().getOriginalImage().getUrl());
                item.setOriginalUrl(item.getOriginalUrl().replace("giphy_s","200w"));
                Log.d("showp",item.getUrl()+" "+item.getOriginalUrl());
                    showActivity.ShowRandomItem(item);
            }

            @Override
            public void onFailure(Call<RandomModel> call, Throwable t) {
                Log.d("response failed",t.getMessage());
            }
        });

    }
}
