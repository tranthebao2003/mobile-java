package com.bao.cardview;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AppsModel> appsList;
    private AppsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        recyclerview Widget
        recyclerView = findViewById(R.id.recycler_view);

        appsList = new ArrayList<>();
        adapter = new AppsAdapter(this, appsList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

//        item decoration
        recyclerView.addItemDecoration(new MainActivity.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        //    preparing the cards
        InsertDataIntoCards();
    }

    private void InsertDataIntoCards() {
//        add the cards data and display them

        int[] appscovers = new int[]{
                R.drawable.facebook,    //appscovers[0]
                R.drawable.facebook_1,
                R.drawable.facebook_2,
                R.drawable.facebook_3,
                R.drawable.facebookffff,
                R.drawable.linkedin,
                R.drawable.messenger,
                R.drawable.tik_tok,
                R.drawable.youtube,
        };

        AppsModel a = new AppsModel("facebook", 80000, appscovers[0]);
        appsList.add(a);

        a = new AppsModel("facebook_1", 800, appscovers[1]);
        appsList.add(a);
        a = new AppsModel("facebook_2", 800, appscovers[2]);
        appsList.add(a);
        a = new AppsModel("facebook_3", 800, appscovers[3]);
        appsList.add(a);
        a = new AppsModel("facebook_ff ff", 800, appscovers[4]);
        appsList.add(a);
        a = new AppsModel("linkedin", 800, appscovers[5]);
        appsList.add(a);
        a = new AppsModel("messenger", 800, appscovers[6]);
        appsList.add(a);
        a = new AppsModel("tik_tok", 800, appscovers[7]);
        appsList.add(a);
        a = new AppsModel("youtube", 800, appscovers[8]);
        appsList.add(a);

//        don't miss to notify the data change
        adapter.notifyDataSetChanged();
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

//        phan getItemOffsets nay tam thoi chua can tim hieu ki
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // lay vi tri cua item
            int column = position % spanCount; // tinh cot hien tai

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount) { //top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, r.getDisplayMetrics()));
    }
}
