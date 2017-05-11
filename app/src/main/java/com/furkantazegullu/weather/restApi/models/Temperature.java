/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:43
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.restApi.models.Temp
 * File Name           : Temp.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:43
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("day")
    @Expose
    public Double day;

    @SerializedName("min")
    @Expose
    public Double min;

    @SerializedName("max")
    @Expose
    public Double max;

    @SerializedName("night")
    @Expose
    public Double night;

    @SerializedName("eve")
    @Expose
    public Double eve;

    @SerializedName("morn")
    @Expose
    public Double morn;

}