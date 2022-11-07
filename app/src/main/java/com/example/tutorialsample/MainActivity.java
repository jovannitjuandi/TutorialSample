package com.example.tutorialsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tutorialsample.API.api_home;
import com.example.tutorialsample.DB.database_display;
import com.example.tutorialsample.Firebase.firebase_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // DECLARE UI COMPONENTS
        Button FirebaseButton = findViewById(R.id.FirebaseButton);
        Button ApiButton = findViewById(R.id.ApiButton);
        Button DatabaseButton = findViewById(R.id.DatabaseButton);

        // SET ON CLICK LISTENERS FOR NAVIGATION
        setOnClickListener(FirebaseButton, firebase_login.class);
        setOnClickListener(ApiButton, api_home.class);
        setOnClickListener(DatabaseButton, database_display.class);
    }


    // HELPER METHODS
    private void setOnClickListener(Button button, java.lang.Class<?> destination) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, destination);
                startActivity(intent);
            }
        });
    }
}