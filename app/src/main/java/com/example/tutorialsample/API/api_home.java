package com.example.tutorialsample.API;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.tutorialsample.R;

public class api_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_home);

        // PLANET API SECTION
        // https://rapidapi.com/koukoulina001/api/astronomy-picture-of-the-day/
        // https://api-ninjas.com/api/planets
        ImageView planet_image = findViewById(R.id.planet_image);
        TextView planet_img_url = findViewById(R.id.planet_img_url);

        // TRANSLATE API SECTION
        // https://rapidapi.com/googlecloud/api/google-translate1
        EditText input_text = findViewById(R.id.input_text);
        TextView input_language_detected = findViewById(R.id.input_language_detected);
        TextView output_text = findViewById(R.id.output_text);
        RadioButton toChinese = findViewById(R.id.toChinese);
        RadioButton toIndonesia = findViewById(R.id.toIndonesia);
        Button translate_button = findViewById(R.id.translate_button);
    }
}