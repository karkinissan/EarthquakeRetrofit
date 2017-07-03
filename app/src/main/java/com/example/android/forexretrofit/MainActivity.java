package com.example.android.forexretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.android.forexretrofit.data.model.ForexAnswerResponse;
import com.example.android.forexretrofit.data.remote.ForexService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ForexService mService;
    EarthquakeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getForexService();
        loadAnswers();

    }

    private void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<ForexAnswerResponse>() {
            @Override
            public void onResponse(Call<ForexAnswerResponse> call, Response<ForexAnswerResponse> response) {
                Log.v("MainActivity", "URL: " + call.request().url());
                if (response.isSuccessful()) {
                mAdapter = new EarthquakeAdapter(MainActivity.this,response.body().getFeatures());
//                    List<Feature> features = response.body().getFeatures();
//                    System.out.println(features.size());
                ListView listView = (ListView) findViewById(R.id.list_view);
                listView.setAdapter(mAdapter);
                } else {
                    int statusCode = response.code();
                    Log.v("MainActivity", "Status Code: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<ForexAnswerResponse> call, Throwable t) {

                Log.v("MainActivity", "URL: " + call.request().url());
                Log.d("MainActivity", "error loading from API "+t.getMessage());

            }
        });
    }
}
