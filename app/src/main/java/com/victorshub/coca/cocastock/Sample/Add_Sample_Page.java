package com.victorshub.coca.cocastock.Sample;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.victorshub.coca.cocastock.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by BENGEOS-PC on 3/28/2016.
 */
public class Add_Sample_Page extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Button btn_Add,EXP_date,PRO_date;
    private Context myContext;
    private int Year,Month,Day,state;
    private TextView txt_ExpDate,txt_ProDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_list_add_sample);
        state = 0;
        toolbar = (Toolbar) findViewById(R.id.add_sample_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Coca Cola");
        getSupportActionBar().setSubtitle("Add New Sample");
        txt_ExpDate = (TextView) findViewById(R.id.txt_exp_date);
        txt_ProDate = (TextView) findViewById(R.id.txt_pro_date);
        btn_Add = (Button) findViewById(R.id.btn_add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        EXP_date = (Button) findViewById(R.id.btn_exp_date);
        EXP_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 0;
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Add_Sample_Page.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "CocaCola Date Picker");
                Toast.makeText(Add_Sample_Page.this,"Date Picked",Toast.LENGTH_LONG).show();
            }
        });
        PRO_date = (Button) findViewById(R.id.btn_pro_date);
        PRO_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 1;
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Add_Sample_Page.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "CocaCola Date Picker");
                Toast.makeText(Add_Sample_Page.this,"Date Picked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        this.Year = year;
        this.Month = monthOfYear;
        this.Day = dayOfMonth;
        if(state == 0){
            txt_ExpDate.setText(Month+"/"+Day+"/"+Year);
        }else{
            txt_ProDate.setText(Month + "/" + Day + "/" + Year);
        }
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {

    }
}
