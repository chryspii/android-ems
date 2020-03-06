package com.example.richard.ems_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class View_Chart_Payment_1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    BarChart barchart_payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__chart__payment_1);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        barchart_payment = (BarChart) findViewById(R.id.chart_payment_1);

        barchart_payment.setDrawBarShadow(false);
        barchart_payment.setDrawValueAboveBar(true);
        barchart_payment.getDescription().setEnabled(false);

        ArrayList<BarEntry> barEntries_usage_1 = new ArrayList<>();
        barEntries_usage_1.add(new BarEntry(0, 320.397f));
        barEntries_usage_1.add(new BarEntry(1, 320.131f));
        barEntries_usage_1.add(new BarEntry(2, 293.797f));
        barEntries_usage_1.add(new BarEntry(3, 291.403f));
        barEntries_usage_1.add(new BarEntry(4, 304.703f));
        barEntries_usage_1.add(new BarEntry(5, 941.916f));
        barEntries_usage_1.add(new BarEntry(6, 1261.188f));

        BarDataSet barDataSet_1 = new BarDataSet(barEntries_usage_1, "Cost(NTD)");
        barDataSet_1.setColor(Color.parseColor("#5cb85c"));

        ArrayList<BarEntry> barEntries_usage_2 = new ArrayList<>();
        barEntries_usage_2.add(new BarEntry(0, 331.037f));
        barEntries_usage_2.add(new BarEntry(1, 325.451f));
        barEntries_usage_2.add(new BarEntry(2, 304.437f));
        barEntries_usage_2.add(new BarEntry(3, 303.373f));
        barEntries_usage_2.add(new BarEntry(4, 308.693f));
        barEntries_usage_2.add(new BarEntry(5, 951.456f));
        barEntries_usage_2.add(new BarEntry(6, 1248.468f));

        BarDataSet barDataSet_2 = new BarDataSet(barEntries_usage_2, "Previous Cost(NTD)");
        barDataSet_2.setColor(Color.parseColor("#a6a6a6"));

        BarData data = new BarData(barDataSet_1, barDataSet_2);

        float groupSpace = 0.06f;
        float barSpace = 0.02f;

        data.setBarWidth(0.45f);
        barchart_payment.setData(data);
        barchart_payment.groupBars(-0.5f, groupSpace, barSpace);

        final ArrayList<String> xlabel = new ArrayList<>();
        xlabel.add("03:00");
        xlabel.add("04:00");
        xlabel.add("05:00");
        xlabel.add("06:00");
        xlabel.add("07:00");
        xlabel.add("08:00");
        xlabel.add("09:00");
        xlabel.add("10:00");

        XAxis xAxis = barchart_payment.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xlabel.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1);

        YAxis rightAxis = barchart_payment.getAxisRight();
        rightAxis.setEnabled(false);

        Legend legend = barchart_payment.getLegend();
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        legend.setTextSize(12);
        
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.nav_account)
        {
            Intent intent_MainHome = new Intent(View_Chart_Payment_1.this, MainActivity.class);
            startActivity(intent_MainHome);
        }
        else if (item.getItemId() == R.id.nav_usage)
        {
            Intent intent_MainUsage = new Intent(View_Chart_Payment_1.this, Usage_MainActivity.class);
            startActivity(intent_MainUsage);
        }
        else if (item.getItemId() == R.id.nav_demand)
        {
            Intent intent_MainDemand = new Intent(View_Chart_Payment_1.this, Demand_MainActivity.class);
            startActivity(intent_MainDemand);
        }
        else if (item.getItemId() == R.id.nav_pf)
        {
            Intent intent_MainPF = new Intent(View_Chart_Payment_1.this, PF_MainActivity.class);
            startActivity(intent_MainPF);
        }
        else if (item.getItemId() == R.id.nav_sensor)
        {
            Intent intent_MainSensor = new Intent(View_Chart_Payment_1.this, Sensor_MainActivity.class);
            startActivity(intent_MainSensor);
        }
        else if (item.getItemId() == R.id.nav_event)
        {
            Intent intent_MainEvent = new Intent(View_Chart_Payment_1.this, Event_MainActivity.class);
            startActivity(intent_MainEvent);
        }
        else if (item.getItemId() == R.id.nav_saving)
        {
            Intent intent_MainSaving = new Intent(View_Chart_Payment_1.this, Saving_MainActivity.class);
            startActivity(intent_MainSaving);
        }
        else if (item.getItemId() == R.id.nav_payment)
        {
            Intent intent_MainPayment = new Intent(View_Chart_Payment_1.this, Payment_MainActivity.class);
            startActivity(intent_MainPayment);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
        {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
