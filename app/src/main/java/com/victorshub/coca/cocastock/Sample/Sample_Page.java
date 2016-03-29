package com.victorshub.coca.cocastock.Sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.victorshub.coca.cocastock.Model.Sample;
import com.victorshub.coca.cocastock.Model.Shop;
import com.victorshub.coca.cocastock.R;
import com.victorshub.coca.cocastock.Shop.Add_Shop_Page;
import com.victorshub.coca.cocastock.Shop.Shops_Adapter;

import java.util.ArrayList;

/**
 * Created by BENGEOS-PC on 3/28/2016.
 */
public class Sample_Page extends Fragment {
    private static RecyclerView myRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static Context myContext;
    private FloatingActionButton AddSample;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report_list_page,container,false);
        myContext = getActivity();
        myRecyclerView = (RecyclerView) view.findViewById(R.id.sample_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);

        AddSample = (FloatingActionButton) view.findViewById(R.id.add_sample);
        AddSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, Add_Sample_Page.class);
                myContext.startActivity(intent);
            }
        });
        ArrayList<Sample> bb = new ArrayList<>();
        bb.add(new Sample());
        bb.add(new Sample());
        bb.add(new Sample());
        bb.add(new Sample());
        mAdapter = new Samples_Adapter(getActivity(),bb);
        myRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
