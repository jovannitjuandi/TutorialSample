package com.example.tutorialsample.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tutorialsample.R;
import com.google.firebase.auth.FirebaseAuth;

public class firebase_display extends AppCompatActivity {
    private Button logout_button;
    private TextView current_user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_display);

        current_user_email = findViewById(R.id.current_user_email);
        current_user_email.setText(GetCurrentUserEmail());

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            BackToFirebaseHome();
        });
    }

/**************************************************************************************************/
/*                                         HELPER METHODS                                         */
/**************************************************************************************************/

    private void BackToFirebaseHome() {
        Intent backHome = new Intent(firebase_display.this, firebase_login.class);
        startActivity(backHome);
    }

    private String GetCurrentUserEmail() {
        Intent intent = getIntent();
        String currentUserEmail = intent.getStringExtra(getResources().getString(R.string.current_user_intent));

        return currentUserEmail;
    }
}