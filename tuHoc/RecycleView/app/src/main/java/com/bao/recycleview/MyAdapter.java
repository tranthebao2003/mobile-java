package com.bao.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//MyAdapter.MyViewHolder chỉ để 1 class MyViewHolder nằm trong
//class MyAdapter
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
//      tạo 1 list kiểu movie
    private List<Movie> movieList;

//    contructor
    public MyAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
//    layout cho tung item
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        lấy ra từng bộ phim trong movieList tại vị trí position
//        sau đó gán dự liệu của bộ phim đó cho từng textview để show lên màn hình
        Movie movie = movieList.get(position);
//        mấy cái thuộc tính này bình thường mình phải lấy thông qua
//        set,get đúng ko? nhưng ở đây mình de no public luon nen
//        minh co the lay bang cach . như thế
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.date.setText(movie.getDate());
    }

//    lấy kích thước của movieList
    @Override
    public int getItemCount() {
        return movieList.size();
    }

    //    create a new class called: MyViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{
//        create widgets
        public TextView title, genre, date;

//        initializing the Views
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.textViewTitle);
            this.genre = itemView.findViewById(R.id.textViewGenre);
            this.date = itemView.findViewById(R.id.textViewDate);
        }
    }
}
