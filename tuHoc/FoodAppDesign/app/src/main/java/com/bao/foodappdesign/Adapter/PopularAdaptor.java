package com.bao.foodappdesign.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bao.foodappdesign.Activity.ShowDetailActivity;
import com.bao.foodappdesign.Domain.CategoryDomain;
import com.bao.foodappdesign.Domain.FoodDomain;
import com.bao.foodappdesign.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder> {
    ArrayList<FoodDomain> popularFood;

    // khởi tạo với data được truyền vào
    public PopularAdaptor(ArrayList<FoodDomain> popularFood) {
        this.popularFood = popularFood;
    }

    // method trả về ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // chuyển đổi file xml thành view để có thể thao túng những thành phần bên trong
        View inflate = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_popular, parent, false);
        // trả về 1 instance của ViewHolder (gọi constructor)
        return new ViewHolder(inflate);
    }

    // bind data vào những viewHolder, onBindViewHolder nó sẽ chạy từ vị trí
    // 0 đến categoryDomains.size() - 1
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(popularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));

        // getIdentifier(): Hàm này dùng để tìm ID của tài nguyên (resource) dựa vào tên, loại tài nguyên, và package của ứng dụng.
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
                (popularFood.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        // Sử dụng Glide để tải và hiển thị hình ảnh
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        // add btn
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),
                        ShowDetailActivity.class);
                intent.putExtra("object", popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    // kích thước của recycleView
    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    // mapping với những thành phần bên trong viewholder_category.xml
    // mỗi item này là 1 ConstraintLayout bên trong chứa textview và imageview
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, fee, addBtn;
        ImageView pic;

        // constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
