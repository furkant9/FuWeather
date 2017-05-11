/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 26.07.2016 22:13
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.restApi.models.Current
 *  * File Name           : Current.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 26.07.2016 22:13
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Current {

    @SerializedName("coord")
    @Expose
    public Coordinate coord;
    @SerializedName("weather")
    @Expose
    public List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base")
    @Expose
    public String base;
    @SerializedName("main")
    @Expose
    public Main main;
    @SerializedName("wind")
    @Expose
    public Wind wind;
    @SerializedName("clouds")
    @Expose
    public Clouds clouds;
    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("sys")
    @Expose
    public Sys sys;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("cod")
    @Expose
    public Integer cod;
}
