package com.barahona.gamenewsv2.Data.Remote;

import com.barahona.gamenewsv2.Data.Model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIService {
    @POST("/login")
    @FormUrlEncoded
    Call<Post> savePost(@Field("user") String user,
                              @Field("password") String pass);

    @GET("/news")
    Call<Post[]> get(
            @Header("Authorization: ") String token
    );
}
