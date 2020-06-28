package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;
    Toolbar mToolbar;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //Navigation Drawer
        mDrawerLayout = findViewById(R.id.drawer);
        mNavigationView = findViewById(R.id.navigationView);
        mNavigationView.setNavigationItemSelectedListener(this);

        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.setDrawerIndicatorEnabled(true);
        mToggle.syncState();

        //Loading Default Fragment
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction =mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container_fragment,new Dashboard());
        mFragmentTransaction.commit();



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        if(menuItem.getItemId() ==R.id.dashboard_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Dashboard());
            mFragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.day_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Day());
            mFragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.week_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Week());
            mFragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.tasks_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Tasks());
            mFragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.exams_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Exams());
            mFragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.settings_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Settings());
            mFragmentTransaction.commit();
        }
        if(menuItem.getItemId() == R.id.info_menu){
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction =mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Info());
            mFragmentTransaction.commit();
        }
        return true;
    }
}