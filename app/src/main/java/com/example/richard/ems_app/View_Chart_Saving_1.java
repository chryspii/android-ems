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

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class View_Chart_Saving_1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    CombinedChart Chart_saving;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__chart__saving_1);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Chart_saving = (CombinedChart) findViewById(R.id.chart_saving_1);
        Chart_saving.setDrawBarShadow(false);
        Chart_saving.setDrawValueAboveBar(false);
        Chart_saving.getDescription().setEnabled(false);

        ArrayList<BarEntry> barEntries_saving_1 = new ArrayList<>();
        barEntries_saving_1.add(new BarEntry(0, 320.397f));
        barEntries_saving_1.add(new BarEntry(1, 320.131f));
        barEntries_saving_1.add(new BarEntry(2, 293.797f));
        barEntries_saving_1.add(new BarEntry(3, 291.403f));
        barEntries_saving_1.add(new BarEntry(4, 304.703f));
        barEntries_saving_1.add(new BarEntry(5, 941.916f));
        barEntries_saving_1.add(new BarEntry(6, 1261.188f));

        BarDataSet barDataSet_1 = new BarDataSet(barEntries_saving_1, "Cost(NTD)");
        barDataSet_1.setColor(Color.parseColor("#5cb85c"));

        BarData bar_data = new BarData(barDataSet_1);
        bar_data.setBarWidth(0.75f);
        bar_data.setDrawValues(false);

        ArrayList<Entry> lineEntries_saving_1 = new ArrayList<>();
        lineEntries_saving_1.add(new Entry(0, 288.357f));
        lineEntries_saving_1.add(new Entry(1, 358.546f));
        lineEntries_saving_1.add(new Entry(2, 381.936f));
        lineEntries_saving_1.add(new Entry(3, 352.597f));
        lineEntries_saving_1.add(new Entry(4, 353.455f));
        lineEntries_saving_1.add(new Entry(5, 1064.365f));
        lineEntries_saving_1.add(new Entry(6, 945.891f));

        LineDataSet lineDataSet_1 = new LineDataSet(lineEntries_saving_1, "Demand(MW)");
        lineDataSet_1.setColor(Color.parseColor("#8497b0"));
        lineDataSet_1.setLineWidth(3f);
        lineDataSet_1.setValueTextSize(10f);

        LineData line_data = new LineData(lineDataSet_1);

        Chart_saving.setDrawOrder(new CombinedChart.DrawOrder[]{ CombinedChart.DrawOrder.BAR,  CombinedChart.DrawOrder.LINE });

        CombinedData data = new CombinedData();
        data.setData(bar_data);
        data.setData(line_data);

        Chart_saving.setData(data);

        final ArrayList<String> xlabel = new ArrayList<>();
        xlabel.add("2017/10/20");
        xlabel.add("2017/10/21");
        xlabel.add("2017/10/22");
        xlabel.add("2017/10/23");
        xlabel.add("2017/10/24");
        xlabel.add("2017/10/25");
        xlabel.add("2017/10/26");
        xlabel.add("2017/10/27");

        XAxis xAxis = Chart_saving.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xlabel.get((int)value);
            }
        });
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMaximum(data.getXMax() + 0.5f);
        xAxis.setAxisMinimum(data.getXMin() - 0.5f);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1);

        YAxis rightAxis = Chart_saving.getAxisRight();
        rightAxis.setEnabled(false);

        Legend legend = Chart_saving.getLegend();
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        legend.setTextSize(12);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.nav_account)
        {
            Intent intent_MainHome = new Intent(View_Chart_Saving_1.this, MainActivity.class);
            startActivity(intent_MainHome);
        }
        else if (item.getItemId() == R.id.nav_usage)
        {
            Intent intent_MainUsage = new Intent(View_Chart_Saving_1.this, Usage_MainActivity.class);
            startActivity(intent_MainUsage);
        }
        else if (item.getItemId() == R.id.nav_demand)
        {
            Intent intent_MainDemand = new Intent(View_Chart_Saving_1.this, Demand_MainActivity.class);
            startActivity(intent_MainDemand);
        }
        else if (item.getItemId() == R.id.nav_pf)
        {
            Intent intent_MainPF = new Intent(View_Chart_Saving_1.this, PF_MainActivity.class);
            startActivity(intent_MainPF);
        }
        else if (item.getItemId() == R.id.nav_sensor)
        {
            Intent intent_MainSensor = new Intent(View_Chart_Saving_1.this, Sensor_MainActivity.class);
            startActivity(intent_MainSensor);
        }
        else if (item.getItemId() == R.id.nav_event)
        {
            Intent intent_MainEvent = new Intent(View_Chart_Saving_1.this, Event_MainActivity.class);
            startActivity(intent_MainEvent);
        }
        else if (item.getItemId() == R.id.nav_saving)
        {
            Intent intent_MainSaving = new Intent(View_Chart_Saving_1.this, Saving_MainActivity.class);
            startActivity(intent_MainSaving);
        }
        else if (item.getItemId() == R.id.nav_payment)
        {
            Intent intent_MainPayment = new Intent(View_Chart_Saving_1.this, Payment_MainActivity.class);
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
