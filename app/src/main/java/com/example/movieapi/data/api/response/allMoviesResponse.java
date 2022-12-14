package com.example.movieapi.data.api.response;


import com.example.movieapi.data.model.movieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class allMoviesResponse {
    @SerializedName("results")
    @Expose
    private final List<movieModel> movies;

    public allMoviesResponse(List<movieModel> movies) {
        this.movies = movies;
    }

    public List<movieModel> getMovies() {
        return movies;
    }
}
