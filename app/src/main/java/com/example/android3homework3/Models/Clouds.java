package com.example.android3homework3.Models;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    private Long mAll;

    public Long getAll() {
        return mAll;
    }

    public void setAll(Long all) {
        mAll = all;
    }

}
