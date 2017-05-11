/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 26.07.2016 21:59
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.restApi.models.Wind
 *  * File Name           : Wind.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 26.07.2016 21:59
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {

@SerializedName("speed")
@Expose
public Float speed;
@SerializedName("deg")
@Expose
public Float deg;

}