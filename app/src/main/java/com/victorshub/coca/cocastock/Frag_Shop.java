package com.victorshub.coca.cocastock;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.victorshub.coca.cocastock.Model.Shop;

import java.util.ArrayList;
import java.util.List;

public class Frag_Shop extends Fragment {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button newsBut;
    private ListView lv_shop;
    FloatingActionButton actionButton;

    public Frag_Shop() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_list, container, false);

        actionButton = (FloatingActionButton) view.findViewById(R.id.fab_shop);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add Report touched", Toast.LENGTH_SHORT).show();
            }
        });
        lv_shop = (ListView) view.findViewById(R.id.lv_shop);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            lv_shop.setNestedScrollingEnabled(true);
        }
        Shop d = new Shop("1","Bediru Shop","Biniyam Kasssahun","Kazanchis, Menharia");
        Shop e = new Shop("1","Shemisu Asche Shop","Mihret Aschalew","22 Mazoria, tirunesh Building");
        Shop f = new Shop("1","Mamo Wolde Shop","Bereket Mamo", "Gurid shola, Holy city center");
        Shop g = new Shop("1","Befikir Gezahegn Shop","Robel Fikre","Megenagna, CBE Building");

        List<Shop> shopList = new ArrayList<Shop>();
        shopList.add(d);
        shopList.add(e);
        shopList.add(f);
        shopList.add(g);
        shopList.add(d);
        shopList.add(e);
        shopList.add(f);
        shopList.add(g);

        lv_shop.setAdapter(new MyShopListAdapter(getContext(), (ArrayList<Shop>) shopList));
        return view;

    }


    public class MyShopListAdapter extends BaseAdapter
    {
        Context context;
        ArrayList<Shop> shops;
        public int currentNum = 0;
        public MyShopListAdapter(Context context,ArrayList<Shop> shop)
        {
            this.context = context;
            shops = shop;
        }


        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return shops.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflate = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflate.inflate(R.layout.single_layout_shop,null);

            TextView tv_title = (TextView) convertView.findViewById(R.id.shop_tv_title);
            TextView tv_owner = (TextView) convertView.findViewById(R.id.shop_owner);
            TextView tv_location = (TextView) convertView.findViewById(R.id.shop_location);
            TextView tv_number = (TextView) convertView.findViewById(R.id.shop_tv_number);


            final String title = shops.get(position).getName();
            final String owner = shops.get(position).getOwner();
            final String location = shops.get(position).getLocation();
            final int id = Integer.parseInt(shops.get(position).getId());
            currentNum = position + 1;
            Log.i("Coca Stock", currentNum + "");

            tv_title.setText(title);
            tv_owner.setText("Owner: " +owner);
            tv_location.setText("Location: " +location);
            tv_number.setText(currentNum+"");

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(),"Shop Number "+currentNum+" Touched",Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "Shop Number "+ currentNum + " has been touched", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
            });

            return convertView;
        }
    }



}
