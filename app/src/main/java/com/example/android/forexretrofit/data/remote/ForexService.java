package com.example.android.forexretrofit.data.remote;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.android.forexretrofit.data.model.ForexAnswerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Nissan on 7/2/2017.
 */

public interface ForexService {

    @GET
    Call<ForexAnswerResponse> getAnswers(@Url String url);


}
