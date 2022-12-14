package com.example.movieapi.domain.repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.movieapi.AppExecutors;
import com.example.movieapi.data.api.Constant;
import com.example.movieapi.data.api.request.Service;
import com.example.movieapi.data.api.response.allMoviesResponse;
import com.example.movieapi.data.model.movieModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class movieRepository {
//this class for allMoviesRepository

    private static movieRepository instance;
        private final MutableLiveData<List<movieModel>> movies;

    public movieRepository() {

        movies=new MutableLiveData<>();

    }

    public static movieRepository getInstance() {
        if (instance == null){
        instance =new movieRepository();
    }
        return instance;
    }

    public LiveData<List<movieModel>> getMovies() {
        return movies;
    }

    //method to return all movies using restAPI
        public void moviesAPI(int page,String genres){

            //Retrieve data from Rest API
            AppExecutors.getInstance().NetworkIO().submit(() -> CallMovieAPI(page,genres));



        }

    private void CallMovieAPI(int page,String genres) {
        Call<allMoviesResponse>  allMovies= Service.getMovieApi().allMovies(Constant.API_KEY,page,genres);
        allMovies.enqueue(new Callback<allMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<allMoviesResponse> call, @NonNull Response<allMoviesResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    List<movieModel> allMoviesResponse = new ArrayList<>(response.body().getMovies());
                    if (page==1){
                        movies.postValue(allMoviesResponse);
                    }
                    else{
                        List<movieModel> currentMovies=movies.getValue();
                        if (currentMovies != null) {
                            currentMovies.addAll(allMoviesResponse);
                        }
                        movies.postValue(currentMovies);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<allMoviesResponse> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure: "+t.getMessage());
                movies.postValue(null);
            }
        });
    }




}



