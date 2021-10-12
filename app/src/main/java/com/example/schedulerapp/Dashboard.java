package com.example.schedulerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

    CalendarView calendarView;
    DrawerLayout drawerLayout;
    ImageView btMenu;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        calendarView = (CalendarView)  findViewById(R.id.calendarView);

        //assign variable
        drawerLayout = findViewById(R.id.drawerLayout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView = findViewById(R.id.recycler_view);

        //set layout menu
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //set adapter
        recyclerView.setAdapter(new MainAdapter(this,MainActivity.arraylist));
        //set calender
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

            }
        });

        btMenu.setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
    }

    @Override
    protected void onPause() {
        super.onPause();
        //closer drawer
        MainActivity.closeDrawer(drawerLayout);
    }
}