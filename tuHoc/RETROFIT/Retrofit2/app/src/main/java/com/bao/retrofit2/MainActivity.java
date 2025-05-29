package com.bao.retrofit2;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> moveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        moveList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);


        Call<JSONResponse> call = movieApi.getMoviz();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                moveList = new ArrayList<>(Arrays.asList(jsonResponse.getMoviz()));

                PutDataIntoRecyclerView(moveList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

        //        Call<List<Movie>> call = movieApi.getMovies();
//        call.enqueue(new Callback<List<Movie>>() {
//            @Override
//            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//                if(response.code() != 200){
//                    // handle the error & display it
//                    return;
//                }
//
//                List<Movie> movies = response.body();
//
//                for (Movie movie : movies) {
////                    String responseTest = "";
////                    responseTest += movie.getId();
////                    Log.v("TAG", "" + responseTest);
//
//                    moveList.add(movie);
//                }
//
//                PutDataIntoRecyclerView(moveList);
//            }
//
//            @Override
//            public void onFailure(Call<List<Movie>> call, Throwable t) {
//
//            }
//        });
    }

    private void PutDataIntoRecyclerView(List<Movie> moveList) {
        Adapter adapter = new Adapter(this, moveList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}