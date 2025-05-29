package com.bao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    Button button;
    int count = 0;
    FragmentB.Counter counter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v;
        v = inflater.inflate(R.layout.fragment_a, container, false);

        button = v.findViewById(R.id.btn_clickMe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
//                use activity
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.incrementValue(count);

//                user interface
//               getActivity Trả về context của Activity mà fragment đang liên kết.
                counter = (FragmentB.Counter) getActivity();
                counter.incrementValue(count);
            }
        });

        return v;
    }
}
