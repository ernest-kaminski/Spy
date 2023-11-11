package com.example.spy.mainFragments;

import android.content.Context;
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
import com.example.spy.appRunner;

public class PlayersFragment extends Fragment {

    Button plus_btn;
    Button minus_btn;
    TextView count;
    int counter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.players_fragment, container, false);

        plus_btn = (Button) v.findViewById(R.id.player_btn_plus);
        minus_btn = (Button) v.findViewById(R.id.player_btn_minus);
        count = (TextView) v.findViewById(R.id.player_counter);

        Context context = getActivity().getApplicationContext();
        counter = ((appRunner) context).getSpyGameModel().getNumberOfPlayers();
        count.setText(String.valueOf(counter));

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter <= 8){
                    counter++;
                    ((appRunner) context).getSpyGameModel().setNumberOfPlayers(counter);
                    count.setText(String.valueOf(counter))
                    ;
                }
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter > 1 )
                {
                    counter--;
                    ((appRunner) context).getSpyGameModel().setNumberOfPlayers(counter);
                    count.setText(String.valueOf(counter));
            }
        }});


        return v;

    }
}