package com.example.aebrahimi.firstmvp.ListContract;

import android.util.Log;

import com.example.aebrahimi.firstmvp.App;
import com.example.aebrahimi.firstmvp.BaseContract.BaseContract;
import com.example.aebrahimi.firstmvp.Constants;
import com.example.aebrahimi.firstmvp.Model.GifModel;
import com.example.aebrahimi.firstmvp.Model.Item;
import com.example.aebrahimi.firstmvp.Model.ItemsModel;
import com.example.aebrahimi.firstmvp.Network.GiphyApi;
import com.example.aebrahimi.firstmvp.Network.RetrofitBuilder;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by aebrahimi on 8/13/2018 AD.
 */

public class ListPresenterImp  implements ListContract.Presenter {
   WeakReference< ListContract.View> view;
    int Offset=0;
    @Inject
    GiphyApi Api;
    public ListPresenterImp(GiphyApi api)
    {
     this.Api=api;
    }
    @Override
    public void getListItems() {
        Api.getTrending(Constants.key,Offset,20).enqueue(new Callback<ItemsModel>() {
            @Override
            public void onResponse(Call<ItemsModel> call, Response<ItemsModel> response) {
               List<Item> item=new ArrayList<>();
               ItemsModel model= response.body();
               for(int i=0;i<model.getData().size();i++)
               {
                    GifModel.User u=model.getData().get(i).getUser();
                       Item a = new Item();
                       if(u!=null)
                        a.setTitle(model.getData().get(i).getUser().getDisplay_name());
                       a.setUrl(model.getData().get(i).getImage().getFixed_heightObject().getUrl());
                       a.setOriginalUrl(model.getData().get(i).getImage().getOriginalImage().getUrl());
                    a.setOriginalUrl(a.getOriginalUrl().replace("giphy_s","200w"));
                       Log.d("passed", a.getUrl() + "  " + a.getOriginalUrl());
                       item.add(a);
               }
               Offset= (int) (model.getPagination().getOffset()+20);
               view.get().ShowItems(item);

            }

            @Override
            public void onFailure(Call<ItemsModel> call, Throwable t) {
                Log.d(" failed",t.getMessage());
            }
        });

    }

    @Override
    public void attach(BaseContract.View view) {
        this.view=new WeakReference<ListContract.View>((ListContract.View)view);
    }

    @Override
    public void detach() {
        view.clear();
    }
}
