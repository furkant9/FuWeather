/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 11:41
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.restApi.models.Coord
 * File Name           : Coord.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 11:41
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordinate {

    @SerializedName("lon")
    @Expose
    public Double lon;

    @SerializedName("lat")
    @Expose
    public Double lat;

}