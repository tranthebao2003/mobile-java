package com.bao.foodappdesign.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bao.foodappdesign.Domain.CategoryDomain;
import com.bao.foodappdesign.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    // khởi tạo với data được truyền vào
    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    // method trả về ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // chuyển đổi file xml thành view để có thể thao túng những thành phần bên trong
        View inflate = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.viewholder_category, parent, false);
        // trả về 1 instance của ViewHolder (gọi constructor)
        return new ViewHolder(inflate);
    }

    // bind data vào những viewHolder, onBindViewHolder nó sẽ chạy từ vị trí
    // 0 đến categoryDomains.size() - 1
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0: {
                // Lưu tên của hình ảnh trong thư mục drawable tương ứng với từng vị trí
                picUrl = "cat_1";
                // Sử dụng ContextCompat.getDrawable() để lấy hình nền từ thư mục drawable và
                // gắn vào mainLayout (Layout của mục trong RecyclerView).
                holder.mainLayout.setBackground(ContextCompat
                        .getDrawable(holder.itemView.getContext(),
                                R.drawable.cat_background1));
                break;
            }
            case 1: {
                picUrl = "cat_2";
                holder.mainLayout.setBackground(ContextCompat
                        .getDrawable(holder.itemView.getContext(),
                                R.drawable.cat_background2));
                break;
            }
            case 2: {
                picUrl = "cat_3";
                holder.mainLayout.setBackground(ContextCompat
                        .getDrawable(holder.itemView.getContext(),
                                R.drawable.cat_background3));
                break;
            }
            case 3: {
                picUrl = "cat_4";
                holder.mainLayout.setBackground(ContextCompat
                        .getDrawable(holder.itemView.getContext(),
                                R.drawable.cat_background4));
                break;
            }
            case 4: {
                picUrl = "cat_5";
                holder.mainLayout.setBackground(ContextCompat
                        .getDrawable(holder.itemView.getContext(),
                                R.drawable.cat_background5));
                break;
            }
        }

        // getIdentifier(): Hàm này dùng để tìm ID của tài nguyên (resource) dựa vào tên, loại tài nguyên, và package của ứng dụng.
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier
                (picUrl, "drawable", holder.itemView.getContext().getPackageName());

        // Sử dụng Glide để tải và hiển thị hình ảnh
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);
    }

    // kích thước của recycleView
    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    // mapping với những thành phần bên trong viewholder_category.xml
    // mỗi item này là 1 ConstraintLayout bên trong chứa textview và imageview
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        // constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
