package com.example.tutorialsample.Firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tutorialsample.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebase_display extends AppCompatActivity {
    private Button logout_button, update_content_button;
    private TextView current_user_email, read_content;
    private EditText reference_input, write_value_input;
    private String TAG = "APP_GENERATED_Firebase_Display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_display);

        current_user_email = findViewById(R.id.current_user_email);
        current_user_email.setText(GetCurrentUserEmail());

        read_content = findViewById(R.id.read_content);
        reference_input = findViewById(R.id.reference_input);
        write_value_input = findViewById(R.id.write_value_input);

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            BackToFirebaseHome();
        });

        update_content_button = findViewById(R.id.update_content_button);
        update_content_button.setOnClickListener(view -> {
            if (IsValidInput()) {
                WriteToFirebase(GetReferenceInput(), GetContentInput());
                ReadFromFirebase(GetReferenceInput());
            }
        });
    }

/**************************************************************************************************/
/*                                         HELPER METHODS                                         */
/**************************************************************************************************/

    private void BackToFirebaseHome() {
        Intent backHome = new Intent(firebase_display.this, firebase_login.class);
        startActivity(backHome);
    }

    private boolean IsValidInput() {
        String reference = reference_input.getText().toString();
        if (reference == null || reference.length() == 0) {
            read_content.setText("No Reference Input");
            read_content.setTextColor(getResources().getColor(R.color.error_pink));
            return false;
        }

        String content = write_value_input.getText().toString();
        if (content == null || content.length() == 0) {
            read_content.setText("No content Input");
            read_content.setTextColor(getResources().getColor(R.color.error_pink));
            return false;
        }

        return true;
    }

    private String GetReferenceInput() {
        String reference = reference_input.getText().toString();
        if (reference == null || reference.length() == 0) {
            reference = "Error/Path";
        }

        return reference;
    }

    private String GetContentInput() {
        String content = write_value_input.getText().toString();
        if (content == null || content.length() == 0) {
            content = "Lorem Ipsum Dolor Sit Amet";
        }

        return content;
    }

    private String GetCurrentUserEmail() {
        Intent intent = getIntent();
        String currentUserEmail = intent.getStringExtra(getResources().getString(R.string.current_user_intent));

        return currentUserEmail;
    }

    private String GetCurrentUserId() {
        Intent intent = getIntent();
        String currentUserEmail = intent.getStringExtra(getResources().getString(R.string.current_user_id));

        return currentUserEmail;
    }

    private void WriteToFirebase(String reference, String value) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(GetCurrentUserId() + "/" + reference);

        myRef.setValue(value);
    }

    private void ReadFromFirebase(String reference) {
        String finalReference = GetCurrentUserId() + "/" + reference;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(finalReference);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                read_content.setTextColor(getResources().getColor(R.color.black));
                read_content.setText("value in '" + reference + "' is: " + value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                String message = error.getMessage();
                Log.w(TAG, "Failed to read value.", error.toException());
                Log.d(TAG, "Write Error - " + message);
            }
        });
    }
}