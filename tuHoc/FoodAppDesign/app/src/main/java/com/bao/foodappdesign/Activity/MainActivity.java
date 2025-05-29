package com.bao.foodappdesign.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bao.foodappdesign.Adapter.CategoryAdaptor;
import com.bao.foodappdesign.Adapter.PopularAdaptor;
import com.bao.foodappdesign.Domain.CategoryDomain;
import com.bao.foodappdesign.Domain.FoodDomain;
import com.bao.foodappdesign.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewCategory() {
        /*
        RecyclerView hiển thị danh sách theo chiều ngang (cuộn ngang).
        Các mục trong danh sách sẽ được căn chỉnh theo thứ tự được cung cấp bởi Adapter của RecyclerView.
        */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);

        // Gắn LinearLayoutManager vừa tạo vào RecyclerView để xác định cách hiển thị danh sách.
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Hotdog", "cat_3"));
        category.add(new CategoryDomain("Drink", "cat_4"));
        category.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
                );

        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain(
                "Pepperoni pizza",
                "pop_1",
                "slices, pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",
                9.76));
        foodList.add(new FoodDomain(
                "Pepperoni pizza",
                "pop_2",
                "slices, pepperoni, mozzarella cheese, fresh oregano, ground black pepper, pizza sauce",
                9.76));
        foodList.add(new FoodDomain(
                "Cheese Burger",
                "pop_3",
                "beef patty, cheddar cheese, lettuce, tomato, pickles, burger sauce, sesame bun",
                8.50));
        foodList.add(new FoodDomain(
                "Vegetable Salad",
                "pop_1",
                "lettuce, cucumber, cherry tomatoes, red onion, feta cheese, olives, vinaigrette",
                7.25));
        foodList.add(new FoodDomain(
                "Spaghetti Carbonara",
                "pop_3",
                "spaghetti, pancetta, eggs, parmesan cheese, black pepper, parsley",
                11.40));
        foodList.add(new FoodDomain(
                "Tacos",
                "pop_2",
                "soft tortilla, grilled chicken, lettuce, cheese, salsa, guacamole",
                6.95));
        foodList.add(new FoodDomain(
                "Sushi Platter",
                "pop_1",
                "assorted sushi rolls, soy sauce, wasabi, pickled ginger",
                14.50));
        foodList.add(new FoodDomain(
                "Grilled Salmon",
                "pop_3",
                "grilled salmon fillet, lemon butter sauce, steamed vegetables, rice",
                15.20));
        foodList.add(new FoodDomain(
                "Chocolate Cake",
                "pop_2",
                "moist chocolate cake, chocolate ganache, whipped cream, strawberries",
                5.75));
        foodList.add(new FoodDomain(
                "Ice Cream Sundae",
                "pop_1",
                "vanilla ice cream, chocolate sauce, nuts, whipped cream, cherry",
                4.80));
        foodList.add(new FoodDomain(
                "Fried Chicken",
                "pop_3",
                "crispy fried chicken, coleslaw, mashed potatoes, gravy",
                9.00));
        foodList.add(new FoodDomain(
                "Pancakes",
                "pop_2",
                "fluffy pancakes, maple syrup, butter, blueberries",
                6.50));

        adapter2 = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}