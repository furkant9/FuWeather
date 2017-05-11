/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 12:17
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.managers.WeatherManager
 * File Name           : WeatherManager.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 12:17
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.managers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.furkantazegullu.weather.R;
import com.furkantazegullu.weather.base.BaseManager;
import com.furkantazegullu.weather.restApi.models.Current;
import com.furkantazegullu.weather.restApi.models.Daily;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;

public class WeatherManager extends BaseManager {

    private static Context mContext;
    private static WeatherManager ourInstance = new WeatherManager();
    private String unitType;

    public WeatherManager() {
    }

    public static synchronized WeatherManager getInstance(Context context) {
        mContext = context;
        return ourInstance;
    }

    public Call<Daily> getDailyForecastById(Integer cityId, boolean isMetric) {
        if (isMetric)
            unitType = "metric";
        else unitType = "imperial";
        Call<Daily> call = getRestApiClient(mContext).getDailyById(cityId, "5", unitType);
        return call;
    }

    public Call<Current> getCurrentForecastById(Integer cityId, boolean isMetric) {
        if (isMetric)
            unitType = "metric";
        else unitType = "imperial";
        Call<Current> call = getRestApiClient(mContext).getCurrentById(cityId, unitType);
        return call;
    }

    public Call<Current> isCityValid(String searchedCityName) {
        Call<Current> call = getRestApiClient(mContext).isCityValid(searchedCityName);
        return call;
    }

    public Drawable getWeatherIconFromDrawable(String icon) {

        switch (icon.substring(0, 2)) {

            case "01":
                return ContextCompat.getDrawable(mContext, R.drawable.sun);

            case "02":
                return ContextCompat.getDrawable(mContext, R.drawable.cloudy);

            case "03":
                return ContextCompat.getDrawable(mContext, R.drawable.cloudy);

            case "04":
                return ContextCompat.getDrawable(mContext, R.drawable.cloudy);

            case "09":
                return ContextCompat.getDrawable(mContext, R.drawable.rain);

            case "10":
                return ContextCompat.getDrawable(mContext, R.drawable.sunnyrain);

            case "11":
                return ContextCompat.getDrawable(mContext, R.drawable.thunderstorm);

            case "13":
                return ContextCompat.getDrawable(mContext, R.drawable.snow);

            case "50":
                return ContextCompat.getDrawable(mContext, R.drawable.fog);

            default:
                return ContextCompat.getDrawable(mContext, R.drawable.cloud);

        }
    }

    public String getDayName(Long timeStamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        Date date = new Date(timeStamp * 1000);
        return formatter.format(date);
    }

    public String getDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm:ss");
        return formatter.format(new Date());
    }
}
