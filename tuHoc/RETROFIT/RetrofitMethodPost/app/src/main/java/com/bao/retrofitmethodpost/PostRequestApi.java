package com.bao.retrofitmethodpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostRequestApi {
    // https://httpbin.org/post

    @POST("post")
    Call<PostModel>  postDataIntoServer(@Body PostModel postModel);
}
