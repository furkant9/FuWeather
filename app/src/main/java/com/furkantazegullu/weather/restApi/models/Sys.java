/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 26.07.2016 21:58
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.restApi.models.Sys
 *  * File Name           : Sys.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 26.07.2016 21:58
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys {

@SerializedName("type")
@Expose
public Integer type;
@SerializedName("id")
@Expose
public Integer id;
@SerializedName("message")
@Expose
public Float message;
@SerializedName("country")
@Expose
public String country;
@SerializedName("sunrise")
@Expose
public Integer sunrise;
@SerializedName("sunset")
@Expose
public Integer sunset;

}