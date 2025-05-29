package com.bao.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;


// 2 interface
public interface MyAPICall {

//    https://run.mocky.io/     v3/b59f4d33-44b3-4c5c-b5e7-3082738a5252
    @GET("v3/b59f4d33-44b3-4c5c-b5e7-3082738a5252")
    Call<DataModel> getData();
}
