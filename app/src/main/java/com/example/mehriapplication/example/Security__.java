
package com.example.mehriapplication.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security__ {

    @SerializedName("APIKeyQueryParam")
    @Expose
    private List<Object> aPIKeyQueryParam = null;

    public List<Object> getAPIKeyQueryParam() {
        return aPIKeyQueryParam;
    }

    public void setAPIKeyQueryParam(List<Object> aPIKeyQueryParam) {
        this.aPIKeyQueryParam = aPIKeyQueryParam;
    }

}
