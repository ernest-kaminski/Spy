package com.example.spy.mainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spy.R;

public class SpiesFragment extends Fragment {

    Button plus_btn;
    Button minus_btn;
    TextView count;
    int count_value = 1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.spies_fragment, container, false);

        plus_btn = (Button) v.findViewById(R.id.plus_btn);
        minus_btn = (Button) v.findViewById(R.id.minus_btn);
        count = (TextView) v.findViewById(R.id.spies_counter);

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count_value <= 8){
                    count_value++;
                    count.setText(String.valueOf(count_value));
                }
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count_value > 1 )
                {
                count_value--;
                count.setText(String.valueOf(count_value));}
            }
        });
        return v;

    }
}
