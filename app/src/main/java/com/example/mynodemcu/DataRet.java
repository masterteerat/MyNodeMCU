package com.example.mynodemcu;

import com.google.gson.annotations.SerializedName;

public class DataRet {
    @SerializedName("status")
    private String status;
    @SerializedName("temp")
    private String temp;

    public DataRet() {}

    public String getStatus() {
        return status;
    };
    public String getTemp() {
        return temp;
    };


}
