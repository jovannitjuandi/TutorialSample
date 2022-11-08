package com.example.tutorialsample.Firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tutorialsample.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class firebase_display extends AppCompatActivity {
    private Button logout_button, update_content_button;
    private TextView current_user_email, read_content, path_view;
    private EditText reference_input, write_value_input;
    private ImageView gravatar;
    private String TAG = "APP_GENERATED_Firebase_Display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_display);

        current_user_email = findViewById(R.id.current_user_email);
        current_user_email.setText("Hello, " + InitUserProfile(GetCurrentUserEmail()));

        read_content = findViewById(R.id.read_content);
        reference_input = findViewById(R.id.reference_input);
        write_value_input = findViewById(R.id.write_value_input);

        path_view = findViewById(R.id.path_view);
        PrintUserInfo();

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            BackToFirebaseHome();
        });

        update_content_button = findViewById(R.id.update_content_button);
        update_content_button.setOnClickListener(view -> {
            if (IsValidInput()) {
                WriteToFirebase(GetReferenceInput(), GetContentInput());
                ReadStringFromFirebase(GetReferenceInput(), read_content);
            }
        });

        gravatar = findViewById(R.id.gravatar);
        gravatar.setOnClickListener(view -> GenerateUserProfileImage());
        GetUserProfile();
    }

/**************************************************************************************************/
/*                                        FIREBASE METHODS                                        */
/**************************************************************************************************/

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

    private void ReadStringFromFirebase(String reference, TextView textView) {
        String finalReference = GetCurrentUserId() + "/" + reference;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(finalReference);

        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        // The following is taken from firebase documentation on reading data
        // BUT CONSIDER: addListenerForSingleValueEvent (check which is better for you to use)
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // Specify the datatype e.g. (String.class, Integer.class)
                // This can even be a complex object
                String value = dataSnapshot.getValue(String.class);
                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setText("value in '" + reference + "' is: " + value);
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

/**************************************************************************************************/
/*                                         VISUALIZATIONS                                         */
/*                                        IGNORE THIS PART                                        */
/**************************************************************************************************/
    private void PrintUserInfo() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(GetCurrentUserId());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {

                } else {
                    int indent = 0;
                    StringBuilder sb = new StringBuilder();
                    printChildren(dataSnapshot, indent, sb);
                    path_view.setText(sb.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                String message = error.getMessage();
                Log.w(TAG, "Failed to read value.", error.toException());
                Log.d(TAG, "Write Error - " + message);
            }
        });
    }

    private void printChildren(DataSnapshot snapshot, int indent, StringBuilder sb) {
        Iterable<DataSnapshot> snapshots = snapshot.getChildren();
        int size = getIterableSize(snapshots);

        if (size <= 0) {
            // What to do if there are no children
        } else {
            sb.append(getIndentString(indent));
            sb.append("+--- ");
            sb.append(snapshot.getKey());
            sb.append(":");
            sb.append("\n");

            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                if (hasChildren(dataSnapshot)) {
                    printChildren(dataSnapshot, indent + 1, sb);
                } else {
                    printNoChildren(dataSnapshot, indent + 1, sb);
                }
            }
        }
    }

    private void printNoChildren(DataSnapshot snapshot, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--- ");
        sb.append(snapshot.getKey() + ": " + snapshot.getValue(String.class));
        sb.append("\n");
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("       ");
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }

    private boolean hasChildren(DataSnapshot snapshot) {
        Iterable<DataSnapshot> snapshots = snapshot.getChildren();
        int size = getIterableSize(snapshots);
        return (size > 0);
    }

    private int getIterableSize(Iterable<DataSnapshot> snapshots) {
        int count = 0;
        for (DataSnapshot snapshot : snapshots) {
            count++;
        }
        return count;
    }


    private String InitUserProfile(String email) {
        String name = email.substring(0, email.indexOf("@"));
        return name;
    }

    private void GenerateUserProfileImage() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Gravatars/" + GetCurrentUserId());

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int newIndex = snapshot.getValue(Integer.class) + 1;
                myRef.setValue(newIndex);

                String newProfile = "https://robohash.org/" + newIndex;
                Glide.with(firebase_display.this).load(newProfile).fitCenter().into(gravatar);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void GetUserProfile() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Gravatars/" + GetCurrentUserId());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String newProfile = "https://robohash.org/" + snapshot.getValue(Integer.class);
                Glide.with(firebase_display.this).load(newProfile).fitCenter().into(gravatar);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void BackToFirebaseHome() {
        Intent backHome = new Intent(firebase_display.this, firebase_login.class);
        startActivity(backHome);
    }

}
