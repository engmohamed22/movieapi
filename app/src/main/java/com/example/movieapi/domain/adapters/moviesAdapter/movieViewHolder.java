package com.example.movieapi.domain.adapters.moviesAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapi.R;


public class movieViewHolder extends RecyclerView.ViewHolder  {
    TextView title,yearOfProduction;
    ImageView poster;

    public movieViewHolder(@NonNull View itemView) {
        super(itemView);
title=itemView.findViewById(R.id.movieTitle);
yearOfProduction=itemView.findViewById(R.id.movieYearOfProduction);
poster=itemView.findViewById(R.id.moviePoster);

    }


}
