package com.example.spy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class SecondActivity extends AppCompatActivity {

    private NavigationBarView bottomNavigationView;

    TextView secondActivityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondActivityTextView = (TextView) findViewById(R.id.textview_second_activity);

        Intent intent = getIntent();

        secondActivityTextView.setText("Witaj");

    }
}