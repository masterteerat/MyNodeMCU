package com.example.mynodemcu;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface ApiRequests {

    @Headers("Content-Type: application/json")
    @POST("/api")
    Call<DataRet> postReq(@Body DataReq userData);

}
