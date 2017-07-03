package com.example.android.forexretrofit.data.remote;

import com.example.android.forexretrofit.data.model.ForexAnswerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nissan on 7/2/2017.
 */

public interface ForexService {
    @GET("/fdsnws/event/1/query?format=geojson&starttime=2017-01-01&endtime=2017-07-02&minmagnitude=5.0&limit=20")
    Call<ForexAnswerResponse> getAnswers();


}
