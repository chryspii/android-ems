package com.example.richard.ems_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;

public class Event_MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView time_date = (TextView) findViewById(R.id.time_date);
        long date = System.currentTimeMillis();
        String dataString = "PF for:\nAll Campus, " + DateFormat.getDateInstance(2).format(date);
        time_date.setText(dataString);

        Spinner spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        ArrayAdapter<CharSequence> adapter_1 = ArrayAdapter.createFromResource(this, R.array.list_event, android.R.layout.simple_spinner_item);
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1.setAdapter(adapter_1);

        Spinner spinner_2 = (Spinner) findViewById(R.id.spinner_2);
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this, R.array.list_sort_event, android.R.layout.simple_spinner_item);
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_2.setAdapter(adapter_2);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_account)
        {
            Intent intent_MainHome = new Intent(Event_MainActivity.this, MainActivity.class);
            startActivity(intent_MainHome);
        }
        else if (item.getItemId() == R.id.nav_usage)
        {
            Intent intent_MainUsage = new Intent(Event_MainActivity.this, Usage_MainActivity.class);
            startActivity(intent_MainUsage);
        }
        else if (item.getItemId() == R.id.nav_demand)
        {
            Intent intent_MainDemand = new Intent(Event_MainActivity.this, Demand_MainActivity.class);
            startActivity(intent_MainDemand);
        }
        else if (item.getItemId() == R.id.nav_pf)
        {
            Intent intent_MainPF = new Intent(Event_MainActivity.this, PF_MainActivity.class);
            startActivity(intent_MainPF);
        }
        else if (item.getItemId() == R.id.nav_sensor)
        {
            Intent intent_MainSensor = new Intent(Event_MainActivity.this, Sensor_MainActivity.class);
            startActivity(intent_MainSensor);
        }
        else if (item.getItemId() == R.id.nav_event)
        {
            finish();
            startActivity(getIntent());
        }
        else if (item.getItemId() == R.id.nav_saving)
        {
            Intent intent_MainSaving = new Intent(Event_MainActivity.this, Saving_MainActivity.class);
            startActivity(intent_MainSaving);
        }
        else if (item.getItemId() == R.id.nav_payment)
        {
            Intent intent_MainPayment = new Intent(Event_MainActivity.this, Payment_MainActivity.class);
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
