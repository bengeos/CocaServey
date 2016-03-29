package com.victorshub.coca.cocastock.Shop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.victorshub.coca.cocastock.Model.Shop;
import com.victorshub.coca.cocastock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BENGEOS-PC on 3/27/2016.
 */
public class Shops_Adapter extends RecyclerView.Adapter<Shops_Adapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Shop> NewsFeeds;
    private static MyClickListener myClickListener;
    private static Context myContext;

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView Title,Content;
        TextView dateTime;
        ImageView Image;

        public DataObjectHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.txt_news_title);
            Content = (TextView) itemView.findViewById(R.id.txt_news_title);
            dateTime = (TextView) itemView.findViewById(R.id.txt_news_title);

            Log.i(LOG_TAG, "Adding Listener");
        }
    }
    public Shops_Adapter(Context context, ArrayList<Shop> newsFeeds){
        this.NewsFeeds = newsFeeds;
        this.myContext = context;
    }
    @Override
    public int getItemCount() {
        return NewsFeeds.size();
    }
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item,parent,false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }
    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
      //  holder.Title.setText(NewsFeeds.get(position).getName());
      //  holder.Content.setText(NewsFeeds.get(position).getName());
      //  holder.dateTime.setText(NewsFeeds.get(position).getName());

    }
    public void addItem(Shop news){
        NewsFeeds.add(news);
    }
    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}
