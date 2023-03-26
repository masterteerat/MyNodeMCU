package com.example.mynodemcu;

import com.google.gson.annotations.SerializedName;

public class DataReq {
    @SerializedName("cmd")
    private String cmd;

    public DataReq() {}

    public DataReq(String cmd) {

        this.cmd = cmd;
    }

    public void setCmd(String cmd) {this.cmd = cmd;};

}
