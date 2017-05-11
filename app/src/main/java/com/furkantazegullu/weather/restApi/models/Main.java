/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 26.07.2016 21:58
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.restApi.models.Main
 *  * File Name           : Main.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 26.07.2016 21:58
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

@SerializedName("temp")
@Expose
public Float temp;
@SerializedName("pressure")
@Expose
public Float pressure;
@SerializedName("humidity")
@Expose
public Float humidity;
@SerializedName("temp_min")
@Expose
public Float tempMin;
@SerializedName("temp_max")
@Expose
public Float tempMax;

}