package com.example.spy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.spy.mainFragments.CategoriesFragment;
import com.example.spy.mainFragments.PlayersFragment;
import com.example.spy.mainFragments.RulesFragment;
import com.example.spy.mainFragments.SpiesFragment;
import com.example.spy.mainFragments.TimerFragment;
import com.example.spy.models.SpyGameModel;
import com.google.android.material.navigation.NavigationBarView;

public class SecondActivity extends AppCompatActivity {

    private NavigationBarView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();


        bottomNavigationView = (NavigationBarView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnItemSelectedListener(listener);
        bottomNavigationView.setItemIconTintList(null);

        Fragment defaultFragment = new RulesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_second_activity, defaultFragment)
                .commit();


    }

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
            }else if(id == R.id.players){
                fragment = new PlayersFragment();
            }else if(id == R.id.spies){
                fragment = new SpiesFragment();
            }else if(id == R.id.timer){
                fragment = new TimerFragment();
            }else if(id == R.id.categories){
                fragment = new CategoriesFragment();
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_second_activity, fragment)
                    .commit();

            return true;
        }
    };

    public void initializeSpyGameController(SpyGameModel spyGameModel){
        ((appRunner) this.getApplication()).setSpyGameModel(spyGameModel);
    }

}