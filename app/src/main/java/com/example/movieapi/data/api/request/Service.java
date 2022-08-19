package com.example.movieapi.data.api.request;



import com.example.movieapi.data.api.Constant;
import com.example.movieapi.data.api.movieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {


    private static final Retrofit.Builder retrofitBuilder=new Retrofit.Builder()
            .baseUrl(Constant.Base_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit=retrofitBuilder.build();

    private static final com.example.movieapi.data.api.movieApi movieApi=retrofit.create(movieApi.class);



    public static movieApi getMovieApi() {
        return movieApi;
    }



}
