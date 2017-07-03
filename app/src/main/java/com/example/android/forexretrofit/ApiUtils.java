package com.example.android.forexretrofit;

import com.example.android.forexretrofit.data.remote.ForexService;
import com.example.android.forexretrofit.data.remote.RetroFitClient;

/**
 * Created by Nissan on 7/2/2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://earthquake.usgs.gov/";

    public static ForexService getForexService(){
        return RetroFitClient.getClient(BASE_URL).create(ForexService.class);
    }
}
