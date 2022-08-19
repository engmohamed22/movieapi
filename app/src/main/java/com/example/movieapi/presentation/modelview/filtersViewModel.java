package com.example.movieapi.presentation.modelview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.movieapi.data.model.filtersModel;
import com.example.movieapi.domain.repo.filtersRepository;

import java.util.List;

public class filtersViewModel extends ViewModel {

    // this class is used for ViewModel
private final filtersRepository filtersRepositoryInstance;

    public filtersViewModel() {

        filtersRepositoryInstance=  filtersRepository.getInstance();


    }


    public LiveData<List<filtersModel>> getFilters(){
        return filtersRepositoryInstance.getFilters();
    }

//call MoviesAPI in view-model

    public void filters(){
        filtersRepositoryInstance.FilterAPI();
    }


}
