/*
 * **********************************************************************************************************************
 * Copyright (c) 2016 Furkan Tazegüllü - All Right Reserved.
 *
 * Project             : Weather
 * Created on          : 21.07.2016 12:05
 * Author              : Furkan Tazegüllü
 * Author E-Mail       : furkan.tazegll@gmail.com
 * Module              : com.furkantazegullu.weather.base.BaseManager
 * File Name           : BaseManager.java
 * Last Modified User  : Furkan
 * Last Modified Date  : 21.07.2016 12:05
 * **********************************************************************************************************************
 */

package com.furkantazegullu.weather.base;

import android.content.Context;

import com.furkantazegullu.weather.Constants;
import com.furkantazegullu.weather.restApi.RestApi;
import com.furkantazegullu.weather.restApi.RestApiClient;

public class BaseManager {

    protected RestApi getRestApiClient(Context context) {
        RestApiClient restApiClient = new RestApiClient(Constants.SERVICE_URL);
        return restApiClient.getRestApi();
    }

}
