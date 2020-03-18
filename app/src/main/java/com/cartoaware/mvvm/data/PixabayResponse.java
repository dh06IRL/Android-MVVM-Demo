package com.cartoaware.mvvm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PixabayResponse {

    @SerializedName("hits")
    @Expose
    private List<Hit> hits;

    public List<Hit> getHits() {
        return hits;
    }

}
