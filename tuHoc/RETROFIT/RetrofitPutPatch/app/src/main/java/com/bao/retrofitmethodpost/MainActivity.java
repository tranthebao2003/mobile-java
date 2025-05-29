package com.bao.retrofitmethodpost;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editTextText);
        btn = findViewById(R.id.button);
        txt = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                CallRetrofit();
//                UpdateRetrofitData();
                PatchRetrofitData();
            }
        });

    }

    private void CallRetrofit() {
        String postBody = ed1.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostRequestApi postRequestApi = retrofit.create(PostRequestApi.class);

        // mock data to test
        PostModel postModel = new PostModel("post1", postBody);
        Call<PostModel> call = postRequestApi.postDataIntoServer(postModel);

        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                // display the result
                txt.setText(response.body().getBodyPost());
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t);
            }
        });
    }

    private void UpdateRetrofitData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostRequestApi postRequestApi = retrofit.create(PostRequestApi.class);
        PostModel postModel = new PostModel("post55", "post changed successfully");

        Call<PostModel> call = postRequestApi.UpdateData(postModel);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                txt.setText(response.body().getBodyPost());

                Toast.makeText(MainActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });
    }

    private void PatchRetrofitData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostRequestApi postRequestApi = retrofit.create(PostRequestApi.class);
        PostModel postModel = new PostModel("post patch data", "post changed successfully equal patch");

        Call<PostModel> call = postRequestApi.PatchData(postModel);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                txt.setText(response.body().getBodyPost());

                Toast.makeText(MainActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {

            }
        });
    }
}