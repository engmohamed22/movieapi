package com.example.movieapi.data.api.response;


import com.example.movieapi.data.model.filtersModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class filtersResponse {
    @SerializedName("genres")
    @Expose
    private final List<filtersModel> genres;

    public filtersResponse(List<filtersModel> genres) {

        this.genres = genres;
    }

    public List<filtersModel> getGenres() {
        return genres;
    }
}
