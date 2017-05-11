/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 28.07.2016 21:29
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.ui.HomeFragment
 *  * File Name           : HomeFragment.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 28.07.2016 21:29
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.furkantazegullu.weather.R;
import com.furkantazegullu.weather.managers.WeatherManager;
import com.furkantazegullu.weather.restApi.models.Current;
import com.furkantazegullu.weather.restApi.models.Daily;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    SwipeRefreshLayout mSwipeRefreshLayout;
    SharedPreferences preferences;
    private TextView textView_today_degree, textView_today_text, textView_today_max, textView_today_min, text_view_last_update,textView_humidty,
            textview_tomorrow_degree, textview_dayafter_degree, textview_verydayafter_degree, textview_tomorrow, textview_dayafter, textview_verydayafter;
    private ImageView imageView_today_logo, imageview_tomorrow_logo, imageview_dayafterlogo, imageview_verydayafter_logo;
    private WeatherManager weatherManager;
    private Boolean isMetric;
    private String cityName;
    private Integer cityId;

    public FragmentHome() {
        // Required empty public constructor
    }

    private void initializeViews(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_home_swipe_refresh_layout);
        textview_tomorrow_degree = (TextView) view.findViewById(R.id.textview_tomorrow_degree);
        textview_dayafter_degree = (TextView) view.findViewById(R.id.textview_dayafter_degree);
        textview_verydayafter_degree = (TextView) view.findViewById(R.id.textview_verydayafter_degree);
        textView_today_degree = (TextView) view.findViewById(R.id.textView_today_degree);
        textView_today_text = (TextView) view.findViewById(R.id.textview_today_text);
        textView_today_max = (TextView) view.findViewById(R.id.textView_today_max);
        textView_today_min = (TextView) view.findViewById(R.id.textView_today_min);
        textView_humidty=(TextView)view.findViewById(R.id.textView_humidity);
        imageView_today_logo = (ImageView) view.findViewById(R.id.imageview_today_logo);
        imageview_dayafterlogo = (ImageView) view.findViewById(R.id.imageview_dayafterlogo);
        imageview_tomorrow_logo = (ImageView) view.findViewById(R.id.imageview_tomorrow_logo);
        imageview_verydayafter_logo = (ImageView) view.findViewById(R.id.imageview_verydayafter_logo);
        textview_verydayafter = (TextView) view.findViewById(R.id.textview_verydayafter);
        textview_dayafter = (TextView) view.findViewById(R.id.textview_dayafter);
        textview_tomorrow = (TextView) view.findViewById(R.id.textview_tomorrow);
        text_view_last_update = (TextView) view.findViewById(R.id.text_view_last_update);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLiveUpdates();
            }
        });
        mSwipeRefreshLayout.post(new Runnable() {
                                     @Override
                                     public void run() {
                                         mSwipeRefreshLayout.setRefreshing(true);
                                         getLiveUpdates();

                                     }
                                 }
        );
        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View myInflatedView = inflater.inflate(R.layout.fragment_home, container, false);
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        isMetric = preferences.getBoolean("use_metric", true);
        cityId = preferences.getInt("currentcityid", 746666);
        cityName = preferences.getString("currentcityname", "Gölcük");
        initializeViews(myInflatedView);
        weatherManager = new WeatherManager();
        return myInflatedView;
    }

    private void getLiveUpdates() {


        Call<Current> currentCall = WeatherManager.getInstance(getActivity())
                .getCurrentForecastById(cityId, isMetric);
        currentCall.enqueue(new Callback<Current>() {
            @Override
            public void onResponse(Call<Current> call, Response<Current> response) {
                Current current = response.body();

                if (current.cod == 200) {
                    textView_today_min.setText(current.main.tempMin.toString() + "°");
                    textView_today_max.setText(current.main.tempMax.toString() + "°");
                    textView_today_text.setText(current.weather.get(0).description);
                    textView_today_degree.setText(current.main.temp.intValue() + "°");
                    textView_humidty.setText("Nem: "+current.main.humidity.intValue()+" %");
                    imageView_today_logo.setImageDrawable(weatherManager.getWeatherIconFromDrawable(current.weather.get(0).icon));
                }
            }

            @Override
            public void onFailure(Call<Current> call, Throwable t) {
                Toast.makeText(getContext(), " Anlık Veri Çekilemedi", Toast.LENGTH_LONG).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        Call<Daily> dailyCall = WeatherManager.getInstance(getActivity()).getDailyForecastById(cityId, isMetric);
        dailyCall.enqueue(new Callback<Daily>() {
            @Override
            public void onResponse(Call<Daily> call, Response<Daily> response) {
                Daily daily = response.body();
                textview_tomorrow_degree.setText(daily.forecast.get(1).temperature.min.intValue() + "°/" + daily.forecast.get(1).temperature.max.intValue() + "°");
                textview_dayafter_degree.setText(daily.forecast.get(2).temperature.min.intValue() + "°/" + daily.forecast.get(2).temperature.max.intValue() + "°");
                textview_verydayafter_degree.setText(daily.forecast.get(3).temperature.min.intValue() + "°/" + daily.forecast.get(3).temperature.max.intValue() + "°");
                imageview_tomorrow_logo.setImageDrawable(weatherManager.getWeatherIconFromDrawable(response.body().forecast.get(1).weather.get(0).icon));
                imageview_dayafterlogo.setImageDrawable(weatherManager.getWeatherIconFromDrawable(response.body().forecast.get(2).weather.get(0).icon));
                imageview_verydayafter_logo.setImageDrawable(weatherManager.getWeatherIconFromDrawable(response.body().forecast.get(3).weather.get(0).icon));
                textview_tomorrow.setText(weatherManager.getDayName(daily.forecast.get(1).dt));
                textview_dayafter.setText(weatherManager.getDayName(daily.forecast.get(2).dt));
                textview_verydayafter.setText(weatherManager.getDayName(daily.forecast.get(3).dt));
                text_view_last_update.setText("Son Güncelleme: " + weatherManager.getDateTime());
                mSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onFailure(Call<Daily> call, Throwable t) {
                Toast.makeText(getContext(), " Haftalık Veri Çekilemedi", Toast.LENGTH_LONG).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }


        });
    }


}
