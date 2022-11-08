package com.example.tutorialsample.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tutorialsample.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**************************************************************************************************/
// 01. go to https://firebase.google.com/ then login and 'get started'
// 02. in https://console.firebase.google.com/u/0/ click 'add project'
// 03. name the project and click continue (check the confirmation checkbox)
// 04. use default account for firebase then click 'create project'
// 05. in the newly created project select 'authentication' then 'get started'
// 06. choose login methods (you can add more later)
// 07. go to Tools -> Firebase
// 08. expand the 'Authentication' section
// 09. choose 'Authenticate using a custom authentication system'
// 10. follow the steps
/**************************************************************************************************/


public class firebase_login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView email_input, password_input, error_message;
    Button authenticate_button, create_user_button;
    private String TAG = "APP_GENERATED_Firebase_Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_login);

        mAuth = FirebaseAuth.getInstance();
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        error_message = findViewById(R.id.error_message);

        authenticate_button = findViewById(R.id.authenticate_button);
        authenticate_button.setOnClickListener(view -> {
            error_message.setText("");
            if (IsValidInput()) {
                AuthenticateUser(GetEmail(), GetPassword());
            }
        });

        create_user_button = findViewById(R.id.create_user_button);
        create_user_button.setOnClickListener(view -> {
            error_message.setText("");
            if (IsValidInput()) {
                CreateUser(GetEmail(), GetPassword());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            GoToDisplay();
        }
    }


    // FIREBASE HELPER METHODS
    private String GetEmail() {
        String email = email_input.getText().toString();
        if (email == null || email.length() == 0) {
            email = "";
        }

        return email;
    }

    private String GetPassword() {
        String password = password_input.getText().toString();
        if (password == null || password.length() == 0) {
            password = "";
        }

        return password;
    }

    private boolean IsValidInput() {
        String email = email_input.getText().toString();
        if (email == null || email.length() == 0) {
            error_message.setText("Email cannot be empty");
            return false;
        }

        String password = password_input.getText().toString();
        if (password == null || password.length() == 0) {
            error_message.setText("Password cannot be empty");
            return false;
        }

        return true;
    }

    private boolean AuthenticateUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "SIGNIN SUCCESS!");
                    GoToDisplay();
                } else {
                    String failCause = task.getException().getMessage();
                    error_message.setText(failCause);
                    Log.d(TAG, "SIGNIN - " + failCause);
                }
            }
        });

        return true;
    }

    private boolean CreateUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "SIGNUP SUCCESS!");

                    // Assign an image and a username for newly created users
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    database.getReference("Gravatars/" + task.getResult().getUser().getUid()).setValue(0);
                    database.getReference(task.getResult().getUser().getUid() + "/username")
                            .setValue(task.getResult().getUser().getEmail().substring(0, email.indexOf("@")));

                    GoToDisplay();
                } else {
                    String failCause = task.getException().getMessage();
                    error_message.setText(failCause);
                    Log.d(TAG, "SIGNUP FAILED - " + failCause);
                }
            }
        });

        return true;
    }

    private void GoToDisplay() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        Intent intent = new Intent(firebase_login.this, firebase_display.class);
        intent.putExtra(getResources().getString(R.string.current_user_intent), currentUser.getEmail());
        intent.putExtra(getResources().getString(R.string.current_user_id), currentUser.getUid());
        startActivity(intent);
    }
}