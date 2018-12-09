package com.example.bobby.mvptutorial.Utilities;

import com.example.bobby.mvptutorial.Model.AndroidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("jsonandroid/")
    Call<AndroidResponse> getAndroidDetails();
}
