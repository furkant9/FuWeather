/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 29.07.2016 09:29
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.ui.FragmentSettings
 *  * File Name           : FragmentSettings.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 29.07.2016 09:29
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.ui;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.furkantazegullu.weather.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSettings extends PreferenceFragmentCompat {


    public FragmentSettings() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.app_preferences);
    }



}
