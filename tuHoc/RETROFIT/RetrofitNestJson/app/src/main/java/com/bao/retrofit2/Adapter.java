package com.bao.retrofit2;

import android.content.Context;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> moviesList;

    public Adapter(Context mContext, List<Movie> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(String.valueOf(moviesList.get(position).getTitle()));
        holder.category.setText(moviesList.get(position).getMoreDetails().getCategory());
        holder.release.setText(moviesList.get(position).getMoreDetails().getRelease());
        holder.duration.setText(moviesList.get(position).getMoreDetails().getDuration());


        // adding glide library to display images
        Glide.with(mContext)
                .load(moviesList.get(position).getPoster())
                .into(holder.img);

//        setting the rating bar value
        // setRating(float value)
        // rating bar is 5 and rating is over 10
        holder.ratingBar.setRating(moviesList.get(position).getRating() / 2);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, duration, release, category;
        ImageView img;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            duration = itemView.findViewById(R.id.duration);
            release = itemView.findViewById(R.id.release);
            category = itemView.findViewById(R.id.category);
            img = itemView.findViewById(R.id.imageView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
