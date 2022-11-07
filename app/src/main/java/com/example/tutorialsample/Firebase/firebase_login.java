package com.example.tutorialsample.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tutorialsample.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_login);

    }
}