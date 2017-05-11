/*
 *  **********************************************************************************************************************
 *  * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *  *
 *  * Project             : Weather
 *  * Created on          : 26.07.2016 21:55
 *  * Author              : Furkan Tazegüllü
 *  * Author E-Mail       : furkan.tazegll@gmail.com
 *  * Module              : com.furkantazegullu.weather.restApi.models.Clouds
 *  * File Name           : Clouds.java
 *  * Last Modified User  : Furkan
 *  * Last Modified Date  : 26.07.2016 21:55
 *  * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.restApi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

@SerializedName("all")
@Expose
public Integer all;

}