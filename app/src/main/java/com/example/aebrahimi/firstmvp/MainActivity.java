package com.example.aebrahimi.firstmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.aebrahimi.firstmvp.Contract.Contract;
import com.example.aebrahimi.firstmvp.Contract.PresenterImp;
import com.example.aebrahimi.firstmvp.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

 public class MainActivity extends AppCompatActivity implements Contract.View{
   Contract.Presenter presenter;
   TrendingAdapter adapter;
   RecyclerView recyclerView;
   GridLayoutManager layoutManager;
   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_trend);
        progressBar=findViewById(R.id.progressBar);
        presenter = new PresenterImp(this);
        adapter=new TrendingAdapter(this,new ArrayList<Item>()) ;
        layoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TrendingAdapter(this,new ArrayList<Item>());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(layoutManager.findLastCompletelyVisibleItemPosition()==adapter.getItemCount()-1)
                {
                    progressBar.setVisibility(View.VISIBLE);
                    presenter.getListItems();
                }
            }
        });
        presenter.getListItems();
    }

    @Override
    public void ShowItems(List<Item> items) {
        adapter.Additems(items);
        adapter.notifyItemRangeInserted(adapter.getItemCount()-items.size(),adapter.getItemCount());
        progressBar.setVisibility(View.GONE);
    }
}
