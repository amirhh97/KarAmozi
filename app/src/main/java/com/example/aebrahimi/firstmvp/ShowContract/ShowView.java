package com.example.aebrahimi.firstmvp.ShowContract;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.aebrahimi.firstmvp.App;
import com.example.aebrahimi.firstmvp.Model.Item;
import com.example.aebrahimi.firstmvp.R;

import javax.inject.Inject;


public class ShowView extends AppCompatActivity implements ShowContract.View {
    ImageView gifPreview;
    ProgressBar progressBar;
    Button randomButton;

    @Inject
    ShowContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //inject
        App.getInjector().inject(this);
        presenter.attach(this);
        gifPreview = findViewById(R.id.gif_preview);
        progressBar = findViewById(R.id.progressBarShow);
        randomButton = findViewById(R.id.button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getRandomItems();
                Log.d("click", "ok");

            }
        });
        Item item = (Item) getIntent().getSerializableExtra("item");
        Glide.with(this).load(item.getOriginalUrl()).into(gifPreview);
        hideProgress();
    }

    @Override
    public void ShowRandomItem(Item item) {
        Glide.with(ShowView.this).load(item.getOriginalUrl()).into(gifPreview);
        Log.d("show", "ok");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
