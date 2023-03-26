package com.example.mynodemcu;

import com.google.gson.annotations.SerializedName;

public class DataReq {
    @SerializedName("cmd")
    private String cmd;

    public DataReq() {}

    public void setCmd(String cmd) {this.cmd = cmd;};

}
