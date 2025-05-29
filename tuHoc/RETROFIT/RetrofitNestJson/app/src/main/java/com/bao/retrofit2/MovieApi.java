package com.bao.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("v3/6a822cf3-078a-454d-ada0-fb8112a0207b")
    Call<JSONResponse> getMoviz();
}
