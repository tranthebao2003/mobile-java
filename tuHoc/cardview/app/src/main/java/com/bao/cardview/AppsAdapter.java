package com.bao.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.MyViewHolder> {

    private Context context;
    private List<AppsModel> appList;


    //    step 1: create MyView holder class
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, appDown;
        public ImageView thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //        initializing the views
            title = itemView.findViewById(R.id.title);
            appDown = itemView.findViewById(R.id.count);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

//  step 2: variable and constructor
    public AppsAdapter(Context context, List<AppsModel> appList) {
        this.context = context;
        this.appList = appList;
    }

//  step 3: implementing methods of Adapter
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_app, parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AppsModel appsModel = appList.get(position);

        holder.title.setText(appsModel.getName());
        holder.appDown.setText(appsModel.getNumofDownloads() + "Users");

//        display the image using glide library
//        add 2 line in file build.gradle (module : app)

// nhan vao context load anh tu appsModel.getThumbnail() den holder.thumbnail
        Glide.with(context)
                .load(appsModel.getThumbnail())
                .into(holder.thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                display a toast method to the user
//                display the title of card clicked
                Toast.makeText(context, "You clicked" + appsModel.getName(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }
}
