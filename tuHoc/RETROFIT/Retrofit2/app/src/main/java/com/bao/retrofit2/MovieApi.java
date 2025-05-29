package com.bao.retrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {
//    @GET("v3/93f05937-65de-4d72-9714-89624f8a1019")
//    Call<List<Movie>> getMovies();

    @GET("v3/7c3e25b7-f395-45b3-bdd4-cf010d95e9a7")
    Call<JSONResponse> getMoviz();
}
