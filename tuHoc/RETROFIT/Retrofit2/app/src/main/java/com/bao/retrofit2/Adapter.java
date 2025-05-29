package com.bao.retrofit2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        // vì id là kiểu int mà dùng setText để show lên thì bắt buộc phải có
        // String.valueOf để chuyển qua string nếu ko bị lỗi
        holder.id.setText(String.valueOf(moviesList.get(position).getId()));
        holder.name.setText(moviesList.get(position).getName());

        // adding glide library to display images
        Glide.with(mContext)
                .load(moviesList.get(position).getImage())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, id;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
