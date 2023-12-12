package com.example.spy.mainFragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class SummaryFragment extends Fragment {

    private TextView numberOfPlayersTextView, numberOfSpiesTextView, chosenCategoriesTextView;
    private String numberOfPlayersString, numberOfSpiesString, chosenCategoriesString;
    private LinearLayoutCompat linearLayoutWithNames;
    private ArrayList<String> playersNames;
    private String lastRemovedName = "";
    private SpyGameModel spyGameModel;
    private Context context;
    int counter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.summary_fragment, container, false);
        linearLayoutWithNames = (LinearLayoutCompat) v.findViewById(R.id.summary_fragment_linear_layout_content_names);

        numberOfPlayersTextView = (TextView) v.findViewById(R.id.summary_fragmment_textview_number_of_players);
        numberOfSpiesTextView = (TextView) v.findViewById(R.id.summary_fragmment_textview_number_of_spies);
        chosenCategoriesTextView = (TextView) v.findViewById(R.id.summary_fragmment_textview_chosen_categories);



        context = getActivity().getApplicationContext();
        spyGameModel = ((appRunner) context).getSpyGameModel();
        playersNames = spyGameModel.getPlayersNames();

        numberOfPlayersString = numberOfPlayersTextView.getText().toString() + " " + spyGameModel.getNumberOfPlayers();
        numberOfSpiesString = numberOfSpiesTextView.getText().toString() + " " + spyGameModel.getNumberOfSpies();


        chosenCategoriesString = chosenCategoriesTextView.getText().toString() + " ";
        for(int i=0; i< spyGameModel.getCategories().size(); i++){
            if(spyGameModel.getCategories().get(i).isChecked()){
                chosenCategoriesString = chosenCategoriesString + ", " + spyGameModel.getCategories().get(i).getCategoryName();
            }
        }

        numberOfPlayersTextView.setText(numberOfPlayersString);
        numberOfSpiesTextView.setText(numberOfSpiesString);
        chosenCategoriesTextView.setText(chosenCategoriesString);

        counter = spyGameModel.getNumberOfPlayers();
        //initializePlayersNamesViews(counter);
        return v;
    }

    private void initializePlayersNamesViews(int numberOfPlayers){
        for(int i=0; i<numberOfPlayers; i++){
            View nameContent = getLayoutInflater().inflate(R.layout.name_row, null, false);
            EditText name_row_content = (EditText) nameContent.findViewById(R.id.name_row_content);
            linearLayoutWithNames.addView(nameContent);
        }
    }

    private void updateSpyGameModel(SpyGameModel spyGameModel){
        ((appRunner) context).setSpyGameModel(spyGameModel);
    }
}