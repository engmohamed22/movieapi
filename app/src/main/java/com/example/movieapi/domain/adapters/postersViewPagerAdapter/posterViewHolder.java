package com.example.movieapi.domain.adapters.postersViewPagerAdapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapi.R;


public class posterViewHolder extends RecyclerView.ViewHolder  {
    ImageView poster;

    public posterViewHolder(@NonNull View itemView) {
        super(itemView);

poster=itemView.findViewById(R.id.moviePosterItem);

    }


}
