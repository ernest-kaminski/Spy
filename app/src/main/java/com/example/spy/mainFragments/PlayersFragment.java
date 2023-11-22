package com.example.spy.mainFragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import com.example.spy.R;
import com.example.spy.appRunner;
import com.example.spy.models.SpyGameModel;

import java.util.ArrayList;

public class PlayersFragment extends Fragment {

    Button plus_btn;
    Button minus_btn;
    TextView count;
    int counter;

    private LinearLayoutCompat linearLayoutWithNames;
    private ArrayList<String> playersNames;
    private String lastRemovedName = "";
    private SpyGameModel spyGameModel;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.players_fragment, container, false);

        plus_btn = (Button) v.findViewById(R.id.player_btn_plus);
        minus_btn = (Button) v.findViewById(R.id.player_btn_minus);
        count = (TextView) v.findViewById(R.id.player_counter);
        linearLayoutWithNames = (LinearLayoutCompat) v.findViewById(R.id.player_fragment_linear_layout_content_names);



        context = getActivity().getApplicationContext();
        spyGameModel = ((appRunner) context).getSpyGameModel();
        playersNames = spyGameModel.getPlayersNames();
        counter = spyGameModel.getNumberOfPlayers();
        count.setText(String.valueOf(counter));
        initializePlayersNamesViews(counter);

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter <= 8){
                    counter++;
                    ((appRunner) context).getSpyGameModel().setNumberOfPlayers(counter);
                    count.setText(String.valueOf(counter));
                    addPlayerNameView();
                }
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter > 3 )
                {
                    counter--;
                    ((appRunner) context).getSpyGameModel().setNumberOfPlayers(counter);
                    count.setText(String.valueOf(counter));
                    removePlayerNameView();
            }
        }});

        return v;

    }

    private void initializePlayersNamesViews(int numberOfPlayers){
        for(int i=0; i<numberOfPlayers; i++){
            addPlayerNameView();
        }
    }

    private void addPlayerNameView(){
        int id = linearLayoutWithNames.getChildCount();
        View nameContent = getLayoutInflater().inflate(R.layout.name_row, null, false);
        EditText name_row_content = (EditText) nameContent.findViewById(R.id.name_row_content);

            if(!spyGameModel.getPlayersNames().get(id).equals("") && !spyGameModel.getPlayersNames().get(id).equals(null)){
                String name = spyGameModel.getPlayersNames().get(id);
                name_row_content.setText(name);
                playersNames.add(name);
                lastRemovedName = "";
            }else if(!lastRemovedName.equals("") && !lastRemovedName.equals(null)){
                name_row_content.setText(lastRemovedName);
                playersNames.add(lastRemovedName);
                lastRemovedName = "";
            }else{
                playersNames.add("");
            }

            spyGameModel.setPlayersNames(playersNames);
            updateSpyGameModel(spyGameModel);


        linearLayoutWithNames.addView(nameContent);
        name_row_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                playersNames.set(id, s.toString());
                spyGameModel.setPlayersNames(playersNames);
                updateSpyGameModel(spyGameModel);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void removePlayerNameView(){
        lastRemovedName = playersNames.get(playersNames.size()-1);
        linearLayoutWithNames.removeView(linearLayoutWithNames.getChildAt(linearLayoutWithNames.getChildCount()-1));
        playersNames.remove(playersNames.size()-1);
        spyGameModel.setPlayersNames(playersNames);
        updateSpyGameModel(spyGameModel);
    }

    private void updateSpyGameModel(SpyGameModel spyGameModel){
        ((appRunner) context).setSpyGameModel(spyGameModel);
    }

}