package com.example.spy.mainFragments;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spy.R;
import com.example.spy.appRunner;
import com.example.spy.models.SpyGameModel;

public class SpiesFragment extends Fragment {

    Button plus_btn;
    Button minus_btn;
    TextView count;
    int numberOfPlayers, numberOfSpies;
    Context context;
    SpyGameModel spyGameModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.spies_fragment, container, false);

        plus_btn = (Button) v.findViewById(R.id.plus_btn);
        minus_btn = (Button) v.findViewById(R.id.minus_btn);
        count = (TextView) v.findViewById(R.id.spies_counter);

        context = getActivity().getApplicationContext();
        spyGameModel = ((appRunner) context).getSpyGameModel();

        numberOfSpies = spyGameModel.getNumberOfSpies();
        numberOfPlayers = spyGameModel.getNumberOfPlayers();

        count.setText(String.valueOf(numberOfSpies));

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOfSpies < numberOfPlayers - 2 ){
                    numberOfSpies++;
                    count.setText(String.valueOf(numberOfSpies));
                }
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOfSpies > 1 )
                {
                    numberOfSpies--;
                count.setText(String.valueOf(numberOfSpies));
                }
            }
        });
        return v;

    }
}
