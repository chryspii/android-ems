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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class View_Chart_Demand_1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    LineChart linechart_demand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__chart__demand_1);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linechart_demand = (LineChart) findViewById(R.id.chart_demand_1);
        linechart_demand.getDescription().setEnabled(false);

        ArrayList<Entry> lineEntries_demand_1 = new ArrayList<>();
        lineEntries_demand_1.add(new Entry(0, 0.288f));
        lineEntries_demand_1.add(new Entry(1, 0.288f));
        lineEntries_demand_1.add(new Entry(2, 0.288f));
        lineEntries_demand_1.add(new Entry(3, 0.289f));
        lineEntries_demand_1.add(new Entry(4, 0.289f));
        lineEntries_demand_1.add(new Entry(5, 0.289f));
        lineEntries_demand_1.add(new Entry(6, 0.289f));

        LineDataSet lineDataSet_1 = new LineDataSet(lineEntries_demand_1, "Demand(MW)");
        lineDataSet_1.setColor(Color.parseColor("#f0ad4e"));
        lineDataSet_1.setLineWidth(2f);

        LineData data = new LineData(lineDataSet_1);
        linechart_demand.setData(data);

        final ArrayList<String> xlabel = new ArrayList<>();
        xlabel.add("03:00");
        xlabel.add("04:00");
        xlabel.add("05:00");
        xlabel.add("06:00");
        xlabel.add("07:00");
        xlabel.add("08:00");
        xlabel.add("09:00");
        xlabel.add("10:00");

        XAxis xAxis = linechart_demand.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xlabel.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1);

        YAxis rightAxis = linechart_demand.getAxisRight();
        rightAxis.setEnabled(false);

        Legend legend = linechart_demand.getLegend();
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        legend.setTextSize(12);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.nav_account)
        {
            Intent intent_MainHome = new Intent(View_Chart_Demand_1.this, MainActivity.class);
            startActivity(intent_MainHome);
        }
        else if (item.getItemId() == R.id.nav_usage)
        {
            Intent intent_MainUsage = new Intent(View_Chart_Demand_1.this, Usage_MainActivity.class);
            startActivity(intent_MainUsage);
        }
        else if (item.getItemId() == R.id.nav_demand)
        {
            Intent intent_MainDemand = new Intent(View_Chart_Demand_1.this, Demand_MainActivity.class);
            startActivity(intent_MainDemand);
        }
        else if (item.getItemId() == R.id.nav_pf)
        {
            Intent intent_MainPF = new Intent(View_Chart_Demand_1.this, PF_MainActivity.class);
            startActivity(intent_MainPF);
        }
        else if (item.getItemId() == R.id.nav_sensor)
        {
            Intent intent_MainSensor = new Intent(View_Chart_Demand_1.this, Sensor_MainActivity.class);
            startActivity(intent_MainSensor);
        }
        else if (item.getItemId() == R.id.nav_event)
        {
            Intent intent_MainEvent = new Intent(View_Chart_Demand_1.this, Event_MainActivity.class);
            startActivity(intent_MainEvent);
        }
        else if (item.getItemId() == R.id.nav_saving)
        {
            Intent intent_MainSaving = new Intent(View_Chart_Demand_1.this, Saving_MainActivity.class);
            startActivity(intent_MainSaving);
        }
        else if (item.getItemId() == R.id.nav_payment)
        {
            Intent intent_MainPayment = new Intent(View_Chart_Demand_1.this, Payment_MainActivity.class);
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
