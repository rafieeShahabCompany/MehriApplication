
package com.example.mehriapplication.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Responses {

    @SerializedName("200")
    @Expose
    private com.example.mehriapplication._200 _200;
    @SerializedName("401")
    @Expose
    private com.example.mehriapplication._401 _401;

    public com.example.mehriapplication._200 get200() {
        return _200;
    }

    public void set200(com.example.mehriapplication._200 _200) {
        this._200 = _200;
    }

    public com.example.mehriapplication._401 get401() {
        return _401;
    }

    public void set401(com.example.mehriapplication._401 _401) {
        this._401 = _401;
    }

}
