package com.example.spy;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.spy.mainFragments.SummaryFragment;
import com.example.spy.mainFragments.PlayersFragment;
import com.example.spy.mainFragments.RulesFragment;
import com.example.spy.mainFragments.SpiesFragment;
import com.example.spy.mainFragments.DetailsFragment;
import com.example.spy.models.SpyGameModel;
import com.google.android.material.navigation.NavigationBarView;

public class SecondActivity extends AppCompatActivity {

    private NavigationBarView bottomNavigationView;
    private Button proceedBtn, backBtn;
    private int fragmentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        proceedBtn = (Button) findViewById(R.id.second_activity_continue_button);
        backBtn = (Button) findViewById(R.id.second_activity_back_button);

        bottomNavigationView = (NavigationBarView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnItemSelectedListener(listener);

        proceedBtn.setOnClickListener(proceedBtnListener);
        backBtn.setOnClickListener(backBtnListener);

        Fragment defaultFragment = new RulesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_second_activity, defaultFragment)
                .commit();

        fragmentNumber = 0;
    }

    View.OnClickListener proceedBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            if(fragmentNumber == 0){
                fragment = new PlayersFragment();
                fragmentNumber++;
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.players);
            }else if(fragmentNumber == 1){
                fragment = new SpiesFragment();
                fragmentNumber++;
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.spies);
            }else if(fragmentNumber == 2){
                fragment = new DetailsFragment();
                fragmentNumber++;
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.details);
            }else if(fragmentNumber == 3){
                fragment = new SummaryFragment();
                fragmentNumber++;
                proceedBtn.setText(R.string.string_begin_game);
                bottomNavigationView.setSelectedItemId(R.id.summary);
            }else{
                sendToGameActivity();
                return;
            }

            backBtn.setEnabled(true);

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                    .replace(R.id.frame_second_activity, fragment)
                    .commit();

            //Log.d(TAG, String.valueOf(fragmentNumber));
        }
    };

    View.OnClickListener backBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            if(fragmentNumber == 1){
                fragment = new RulesFragment();
                backBtn.setEnabled(false);
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.rules);
            }else if(fragmentNumber == 2){
                fragment = new PlayersFragment();
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.players);
            }else if(fragmentNumber == 3){
                fragment = new SpiesFragment();
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.spies);
            }else if(fragmentNumber == 4){
                fragment = new DetailsFragment();
                proceedBtn.setText(R.string.string_proceed);
                bottomNavigationView.setSelectedItemId(R.id.details);
            }else{

            }
            //fragmentNumber--;

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
                    .replace(R.id.frame_second_activity, fragment)
                    .commit();

            Log.d(TAG, String.valueOf(fragmentNumber));
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        SpyGameModel spyGameModel = new SpyGameModel(3,1);
        initializeSpyGameController(spyGameModel);
    }

    private final NavigationBarView.OnItemSelectedListener listener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            int id = item.getItemId();
            if(id == R.id.rules){
                fragment = new RulesFragment();
                fragmentNumber = 0;
                backBtn.setEnabled(false);
                proceedBtn.setText(R.string.string_proceed);
            }else if(id == R.id.players){
                fragment = new PlayersFragment();
                fragmentNumber = 1;
                proceedBtn.setText(R.string.string_proceed);
            }else if(id == R.id.spies){
                fragment = new SpiesFragment();
                fragmentNumber = 2;
                proceedBtn.setText(R.string.string_proceed);
            }else if(id == R.id.details){
                fragment = new DetailsFragment();
                fragmentNumber = 3;
                proceedBtn.setText(R.string.string_proceed);
            }else if(id == R.id.summary){
                fragment = new SummaryFragment();
                fragmentNumber = 4;
                proceedBtn.setText(R.string.string_begin_game);
            }

            if(fragmentNumber != 0){backBtn.setEnabled(true);}

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in, R.anim.fade_out)
                    .replace(R.id.frame_second_activity, fragment)
                    .commit();

            return true;
        }
    };

    public void initializeSpyGameController(SpyGameModel spyGameModel){
        ((appRunner) this.getApplication()).setSpyGameModel(spyGameModel);
    }
    
    private void sendToGameActivity(){
        Log.d(TAG, "sendToGameActivity: sended");
    }

}