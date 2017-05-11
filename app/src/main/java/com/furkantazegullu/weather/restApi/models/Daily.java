/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:42
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.restApi.models.Daily
 * File Name           : Daily.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:42
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Daily {

    @SerializedName("city")
    @Expose
    public City city;

    @SerializedName("cod")
    @Expose
    public String code;

    @SerializedName("message")
    @Expose
    public Double message;

    @SerializedName("cnt")
    @Expose
    public Integer count;

    @SerializedName("list")
    @Expose
    public List<Forecast> forecast = new ArrayList<>();

}