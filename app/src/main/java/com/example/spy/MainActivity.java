package com.example.spy;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private Button mainbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainbtn = (Button) findViewById(R.id.main_activity_btn);
        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToSecondActivity();
            }
        });
    }

    private void sendToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();
    }



}