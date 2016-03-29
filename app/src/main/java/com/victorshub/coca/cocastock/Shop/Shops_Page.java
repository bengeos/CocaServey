package com.victorshub.coca.cocastock.Shop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.victorshub.coca.cocastock.Model.Shop;
import com.victorshub.coca.cocastock.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BENGEOS-PC on 3/27/2016.
 */
public class Shops_Page extends Fragment {
    private static RecyclerView myRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static Context myContext;
    private FloatingActionButton AddShop;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_list_page,container,false);
        myContext = getActivity();
        myRecyclerView = (RecyclerView) view.findViewById(R.id.shop_recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(mLayoutManager);

        AddShop = (FloatingActionButton) view.findViewById(R.id.add_shop);
        AddShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, Add_Shop_Page.class);
                myContext.startActivity(intent);
            }
        });
        ArrayList<Shop> bb = new ArrayList<>();
        bb.add(new Shop());
        bb.add(new Shop());
        bb.add(new Shop());
        bb.add(new Shop());
        mAdapter = new Shops_Adapter(getActivity(),bb);
        myRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
