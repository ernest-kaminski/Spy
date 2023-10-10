package com.example.spy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView secondActivityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondActivityTextView = (TextView) findViewById(R.id.textview_second_activity);

        Intent intent = getIntent();
        String krystianName = intent.getStringExtra("name");

        secondActivityTextView.setText("Witaj " + krystianName);

    }
}