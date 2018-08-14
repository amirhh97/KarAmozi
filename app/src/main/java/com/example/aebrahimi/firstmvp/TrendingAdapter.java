package com.example.aebrahimi.firstmvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aebrahimi.firstmvp.Model.GifModel;
import com.example.aebrahimi.firstmvp.Model.Item;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aebrahimi on 8/13/2018 AD.
 */

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.Holder> {

    ArrayList<Item>items;

    Context c;
    public TrendingAdapter(Context c, ArrayList<Item> items)
    {
        this.c=c;
        this.items=items;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(c).inflate(R.layout.list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        holder.user.setText(items.get(position).getTitle());
        Glide.with(c).load(items.get(position).getUrl()).into(holder.gif);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        ImageView gif;
        TextView user;
        public Holder(View itemView) {
            super(itemView);
            gif=itemView.findViewById(R.id.gif);
            user=itemView.findViewById(R.id.usertxt);
        }
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
public void Additems(List<Item> newItems)
{
    items.addAll(newItems);
    
}
}
