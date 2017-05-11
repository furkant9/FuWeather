/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 29.07.2016 09:25
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.ui.FragmentSearch
 *  * File Name           : FragmentSearch.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 29.07.2016 09:25
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.furkantazegullu.weather.R;
import com.furkantazegullu.weather.helpers.Utility;
import com.furkantazegullu.weather.managers.WeatherManager;
import com.furkantazegullu.weather.restApi.models.Current;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearch extends Fragment {

    Button searchButton;
    EditText searchedCityName;
    String foundCityName;
    Integer foundCityId;

    public FragmentSearch() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchButton = (Button) view.findViewById(R.id.button_city_search);
        searchedCityName = (EditText) view.findViewById(R.id.editText_CityName);
        searchedCityName.requestFocus();
        Utility.getInstance(getContext()).showSoftKeyboard();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utility.getInstance(getContext()).hideSoftKeyboard(searchedCityName.getWindowToken());
                Call<Current> currentCall = WeatherManager.getInstance(getContext()).isCityValid(searchedCityName.getText().toString());
                currentCall.enqueue(new Callback<Current>() {
                    @Override
                    public void onResponse(Call<Current> call, Response<Current> response) {
                        Current currentCall = response.body();
                        if (currentCall.cod >= 200 && currentCall.cod <= 300) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("cityid", currentCall.id);
                            bundle.putString("cityname", currentCall.name);
                            bundle.putDouble("latitude", currentCall.coord.lat);
                            bundle.putDouble("longitude", currentCall.coord.lon);
                            foundCityName = currentCall.name;
                            foundCityId = currentCall.id;
                            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                            FragmentGMap fragmentGMap = new FragmentGMap();
                            fragmentGMap.setArguments(bundle);
                            fragmentTransaction.replace(R.id.map_container, fragmentGMap);
                            fragmentTransaction.commit();
                        }
                    }

                    @Override
                    public void onFailure(Call<Current> call, Throwable t) {
                        Toast.makeText(getContext(), "Şehir Bulunamadı", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return view;
    }

}
