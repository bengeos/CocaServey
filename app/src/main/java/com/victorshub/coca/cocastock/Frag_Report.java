package com.victorshub.coca.cocastock;

import android.content.Context;
import android.graphics.Color;
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

import com.victorshub.coca.cocastock.Model.Report;

import java.util.ArrayList;
import java.util.List;

public class Frag_Report extends Fragment {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Button newsBut;
    private ListView lv_report;
    FloatingActionButton actionButton;
    public Frag_Report() {
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
        View view = inflater.inflate(R.layout.fragment_report_list, container, false);

        actionButton = (FloatingActionButton) view.findViewById(R.id.fab_report);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add Report touched", Toast.LENGTH_SHORT).show();
            }
        });
        lv_report = (ListView) view.findViewById(R.id.lv_report);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            lv_report.setNestedScrollingEnabled(true);
        }
        Report d = new Report("1","12-12-2016","Coca Cola","50","Abraham","Shemsu Shop","2");
        Report e = new Report("1","12-12-2016","Sprite","50","Abraham","Shemsu Shop","2");
        Report f = new Report("1","12-12-2016","Fanta Ananas","50","Abraham","Shemsu Shop","2");
        Report g = new Report("1","12-12-2016","Fanta Orange","50","Abraham","Shemsu Shop","2");

        List<Report> reportList = new ArrayList<Report>();
        reportList.add(d);
        reportList.add(e);
        reportList.add(f);
        reportList.add(g);
        reportList.add(d);
        reportList.add(e);
        reportList.add(f);
        reportList.add(g);

        lv_report.setAdapter(new MyReportListAdapter(getContext(), (ArrayList<Report>) reportList));
        return view;
    }

    public class MyReportListAdapter extends BaseAdapter
    {
        Context context;
        ArrayList<Report> reports;
        public int currentNum = 0;
        public MyReportListAdapter(Context context,ArrayList<Report> report)
        {
            this.context = context;
            reports = report;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return reports.size();
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
            convertView = inflate.inflate(R.layout.single_layout_report,null);

            TextView tv_title = (TextView) convertView.findViewById(R.id.report_tv_title);
            TextView tv_date = (TextView) convertView.findViewById(R.id.report_date);
            TextView tv_remaining = (TextView) convertView.findViewById(R.id.report_remaining_day);
            TextView tv_shop = (TextView) convertView.findViewById(R.id.report_shop_name);
            TextView tv_number = (TextView) convertView.findViewById(R.id.report_tv_number);


            final String title = reports.get(position).getProduct_name();
            final String date = reports.get(position).getDate();
            final String remaining = reports.get(position).getRemaining_day();
            final int id = Integer.parseInt(reports.get(position).getId());
            final String shop = reports.get(position).getShop_name();
            currentNum = position + 1;
            Log.i("Coca Stock", currentNum+"");

            tv_title.setText(title);
            tv_date.setText(date);
            tv_remaining.setText("Remaining day: "+ remaining);
            tv_shop.setText("Shop name: " +shop);
            tv_number.setText(currentNum+"");

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getActivity(),"Report Number "+currentNum+" Touched",Toast.LENGTH_SHORT).show();
                    /*Snackbar.make(v, "Report Number "+ currentNum + " has been touched", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();*/
                    Snackbar snackbar = Snackbar
                            .make(v, "No internet connection!", Snackbar.LENGTH_LONG)
                            .setAction("RETRY", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

// Changing message text color
                    snackbar.setActionTextColor(Color.RED);

// Changing action button text color
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();
                }
            });

            return convertView;
        }
    }



}
