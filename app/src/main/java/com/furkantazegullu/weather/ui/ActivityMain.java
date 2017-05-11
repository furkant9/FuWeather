/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:11
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.ui.ActivityMain
 * File Name           : ActivityMain.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:11
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.furkantazegullu.weather.R;
import com.furkantazegullu.weather.base.BaseActivity;
import com.furkantazegullu.weather.helpers.Utility;

public class ActivityMain extends BaseActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    NavigationView navigationView;
    SharedPreferences preferences;
    private String cityName;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, new FragmentHome(), "visible_fragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        drawerLayout.closeDrawers();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        cityName = preferences.getString("currentcityname", "Gölcük");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.home_screen_drawer_layout);
        //actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {


            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                Utility.getInstance(getApplicationContext())
                        .hideSoftKeyboard(getWindow().getDecorView().getRootView().getWindowToken());

            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentByTag("visible_fragment");
                if (fragment instanceof FragmentHome) {
                    cityName = preferences.getString("currentcityname", "Gölcük");
                    getSupportActionBar().setTitle(cityName + " Hava durumu");
                    navigationView.setCheckedItem(R.id.home_item);

                }
                if (fragment instanceof FragmentSettings) {
                    getSupportActionBar().setTitle("Ayarlar");
                    navigationView.setCheckedItem(R.id.settings_item);
                }
                if (fragment instanceof FragmentSearch) {
                    getSupportActionBar().setTitle("Şehir Arama");
                    navigationView.setCheckedItem(R.id.search_item);
                }
            }
        });
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new FragmentHome(), "visible_fragment");
        fragmentTransaction.commit();
        getSupportActionBar().setTitle(cityName + " Hava Durumu");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_item:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new FragmentHome(), "visible_fragment");
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        cityName = preferences.getString("currentcityname", "Gölcük");
                        getSupportActionBar().setTitle(cityName + " Hava Durumu");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.search_item:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new FragmentSearch(), "visible_fragment");
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Şehir Arama");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.settings_item:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new FragmentSettings(), "visible_fragment");
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Ayarlar");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.about_item:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new FragmentAbout(), "visible_fragment");
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Hakkında");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });


    }
}
