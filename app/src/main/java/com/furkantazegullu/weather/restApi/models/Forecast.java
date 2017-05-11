/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:42
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.restApi.models.List
 * File Name           : List.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:42
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Forecast {

    @SerializedName("dt")
    @Expose
    public Long dt;

    @SerializedName("temp")
    @Expose
    public Temperature temperature;

    @SerializedName("pressure")
    @Expose
    public Double pressure;

    @SerializedName("humidity")
    @Expose
    public Integer humidity;

    @SerializedName("weather")
    @Expose
    public List<Weather> weather = new ArrayList<>();

    @SerializedName("speed")
    @Expose
    public Double speed;

    @SerializedName("deg")
    @Expose
    public Integer deg;

    @SerializedName("clouds")
    @Expose
    public Integer clouds;

    @SerializedName("rain")
    @Expose
    public Double rain;

}