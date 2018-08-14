package com.example.aebrahimi.firstmvp.Network;


import com.example.aebrahimi.firstmvp.Model.GifModel;
import com.example.aebrahimi.firstmvp.Model.ItemsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aebrahimi on 8/13/2018 AD.
 */

public interface GiphyApi {
    @GET("v1/gifs/trending")
    Call<ItemsModel> getTrending(@Query("api_key")String ApiKey,@Query("offset")int offset,@Query("limit")int limit);
}
