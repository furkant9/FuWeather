/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:41
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.restApi.models.City
 * File Name           : City.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:41
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    public Integer id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("coord")
    @Expose
    public Coordinate coord;

    @SerializedName("country")
    @Expose
    public String country;

    @SerializedName("population")
    @Expose
    public Integer population;

}