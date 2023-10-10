package com.example.spy;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mainbtn;
    private EditText edittext;
    private String stringFromEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringFromEditText = "";

        mainbtn = (Button) findViewById(R.id.main_activity_btn);
        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringFromEditText = edittext.getText().toString();
                sendToSecondActivity(stringFromEditText);
            }
        });

        edittext = (EditText) findViewById(R.id.edittext);

    }

    private void sendToSecondActivity(String stringFromEditText) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", stringFromEditText);
        startActivity(intent);
        finish();
    }
}