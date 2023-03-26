package com.example.mynodemcu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Timer myTimer;
    private String status;
    private String temp;
    private TextView txtTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTemp = findViewById(R.id.textnum);

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getTemp();
            }

        }, 500, 500);

    }

    void getTemp() {
        checkTemp();
        if (status.equals("yes")) {
            txtTemp.setText(temp);
        } else {
            txtTemp.setText("error has occurred");
        }

    }

    void checkTemp() {

        Retrofit api = new Retrofit.Builder()

                .baseUrl()
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRequests service = api.create(ApiRequests.class);
        Call<com.example.mynodemcu.DataRet> call = service.postReq(new DataReq("checktemp"));

        call.enqueue(new Callback<com.example.mynodemcu.DataRet>() {

            @Override
            public void onResponse(Call<com.example.mynodemcu.DataRet> call, Response<com.example.mynodemcu.DataRet> response) {
                com.example.mynodemcu.DataRet response1 = response.body();

                status = response1.getStatus();
                temp = response1.getTemp();

            }

            @Override
            public void onFailure(Call<com.example.mynodemcu.DataRet> call, Throwable t) {
                Log.d("artoy", t.toString());
            }
        });
    }
}