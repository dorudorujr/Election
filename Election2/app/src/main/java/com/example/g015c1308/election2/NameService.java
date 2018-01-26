package com.example.g015c1308.election2;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by G015C1308 on 2018/01/06.
 */

public interface NameService {
    @GET("/Api")
    Call<Example> getExample();
}
