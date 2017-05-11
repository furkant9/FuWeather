/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:38
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.restApi.RestApi
 * File Name           : RestApi.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:38
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi;

import com.furkantazegullu.weather.restApi.models.Current;
import com.furkantazegullu.weather.restApi.models.Daily;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {

    @GET("data/2.5/forecast/daily?APPID=API_KEY&mode=json&lang=tr")
    Call<Daily> getDailyById(@Query("id") Integer cityId, @Query("cnt") String count, @Query("units") String unitType);

    @GET("data/2.5/weather?APPID=API_KEY&mode=json&lang=tr")
    Call<Current> getCurrentById(@Query("id") Integer cityId, @Query("units") String unitType);

    @GET("data/2.5/weather?APPID=API_KEY&mode=json&lang=tr")
    Call<Current> isCityValid(@Query("q") String cityName);
}

