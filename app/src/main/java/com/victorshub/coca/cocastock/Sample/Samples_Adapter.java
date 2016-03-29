package com.victorshub.coca.cocastock.Sample;

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

import com.victorshub.coca.cocastock.Model.Sample;
import com.victorshub.coca.cocastock.Model.Shop;
import com.victorshub.coca.cocastock.R;
import com.victorshub.coca.cocastock.Shop.Add_Shop_Page;

import java.util.ArrayList;

/**
 * Created by BENGEOS-PC on 3/28/2016.
 */
public class Samples_Adapter extends RecyclerView.Adapter<Samples_Adapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Sample> Samples;
    private static MyClickListener myClickListener;
    private static Context myContext;

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        TextView Title,Content;
        TextView dateTime;
        ImageView Image;

        public DataObjectHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.txt_news_title);
            Content = (TextView) itemView.findViewById(R.id.txt_news_title);
            dateTime = (TextView) itemView.findViewById(R.id.txt_news_title);

            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // myClickListener.onItemClick(getAdapterPosition(), v);
            Intent intent = new Intent(myContext,Add_Sample_Page.class);
         //   myContext.startActivity(intent);
            Toast.makeText(myContext, "Position: " + getPosition(), Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }
    public static void setOnItemClickListener(MyClickListener myClickListener) {
        myClickListener = myClickListener;
    }
    public Samples_Adapter(Context context, ArrayList<Sample> samples){
        this.Samples = samples;
        this.myContext = context;
    }
    @Override
    public int getItemCount() {
        return Samples.size();
    }
    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_list_item,parent,false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }
    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        //  holder.Title.setText(NewsFeeds.get(position).getName());
        //  holder.Content.setText(NewsFeeds.get(position).getName());
        //  holder.dateTime.setText(NewsFeeds.get(position).getName());

    }
    public void addItem(Sample news){
        Samples.add(news);
    }
    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
