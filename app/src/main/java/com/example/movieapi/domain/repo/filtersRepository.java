package com.example.movieapi.domain.repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.movieapi.AppExecutors;
import com.example.movieapi.data.api.Constant;
import com.example.movieapi.data.api.request.Service;
import com.example.movieapi.data.api.response.filtersResponse;
import com.example.movieapi.data.model.filtersModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class filtersRepository {

//this class for Filter repository
    private static filtersRepository instance;
        private final MutableLiveData<List<filtersModel>> filters;

    public filtersRepository() {

        filters=new MutableLiveData<>();

    }

    public static filtersRepository getInstance() {
        if (instance == null){
        instance =new filtersRepository();
    }
        return instance;
    }

    public LiveData<List<filtersModel>> getFilters() {
        return filters;
    }


    //method to return Filtered movies using restAPI
        public void FilterAPI(){

            //Retrieve data from Rest API
            AppExecutors.getInstance().NetworkIO().submit(this::callFilterAPI);

        }

    private void callFilterAPI() {
        Call<filtersResponse>  allMovies= Service.getMovieApi().filters(Constant.API_KEY);
        allMovies.enqueue(new Callback<filtersResponse>() {
            @Override
            public void onResponse(@NonNull Call<filtersResponse> call, @NonNull Response<filtersResponse> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    List<filtersModel> filtersResponse = new ArrayList<>(response.body().getGenres());
                    filtersResponse.add(0,new filtersModel(0,"All"));
                    filters.postValue(filtersResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<filtersResponse> call, @NonNull Throwable t) {
                Log.d("TAG", "onFailure: "+t.getMessage());
                filters.postValue(null);
            }
        });
    }


}



