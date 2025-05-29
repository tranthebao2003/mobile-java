package com.bao.retrofitmethodpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PostRequestApi {
    // https://httpbin.org/post

    @POST("post")
    Call<PostModel>  postDataIntoServer(@Body PostModel postModel);

    // https://httpbin.org/put
    @PUT("put")
    Call<PostModel> UpdateData(@Body PostModel postModel);

    // https://httpbin.org/patch
    @PATCH("patch")
    Call<PostModel> PatchData(@Body PostModel postModel);


}
