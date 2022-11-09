package com.example.tutorialsample.API;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tutorialsample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class api_home extends AppCompatActivity {
private String TAG = "APP_GENERATED_Api_Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_home);

        // MUSEUM API SECTION
        // https://metmuseum.github.io/
        ImageView art_image = findViewById(R.id.art_image);
        TextView art_name = findViewById(R.id.art_name);
        TextView art_img_src = findViewById(R.id.art_img_src);

        Retrofit retrofitArt = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.art_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ArtService artService = retrofitArt.create(ArtService.class);
        Call<ArtResponse> artIds = artService.getArtIds(true, "POP");
        artIds.enqueue(new Callback<ArtResponse>() {
            @Override
            public void onResponse(Call<ArtResponse> call, Response<ArtResponse> response) {
                Log.d(TAG, "API SUCCESS 1");
                List<Integer> allIds = response.body().getObjectIDs();
                Integer total = response.body().getTotal();
                Random randomizer = new Random();
                Integer chosenId = allIds.get(randomizer.nextInt(total));
                Integer hasImage = 544740; // Change this if needed, some art does not have an image

                Call<ArtObjectResponse> artObject = artService.getArtById(hasImage);
                artObject.enqueue(new Callback<ArtObjectResponse>() {
                    @Override
                    public void onResponse(Call<ArtObjectResponse> call, Response<ArtObjectResponse> response) {
                        Log.d(TAG, "API SUCCESS 2");

                        ArtObjectResponse artObject = response.body();
                        art_name.setText(artObject.getTitle());
                        art_img_src.setText(artObject.getPrimaryImageSmall());

                        String imageUrl = artObject.getPrimaryImageSmall();
                        if (artObject.getPrimaryImage().length() == 0) {
                            imageUrl = "https://propertywiselaunceston.com.au/wp-content/themes/property-wise/images/no-image.png";
                        }
                        Glide.with(api_home.this)
                                .load(imageUrl)
                                .fitCenter()
                                .into(art_image);

                    }

                    @Override
                    public void onFailure(Call<ArtObjectResponse> call, Throwable t) {
                        Log.d(TAG, "API FAIL 2: " + t.getMessage());
                    }
                });

            }

            @Override
            public void onFailure(Call<ArtResponse> call, Throwable t) {
                Log.d(TAG, "API FAIL 1: " + t.getMessage());
            }
        });

        // TRANSLATE API SECTION
        // https://rapidapi.com/haizibinbin-owyntKc0a48/api/ai-translate/
        EditText input_text = findViewById(R.id.input_text);
        TextView output_text = findViewById(R.id.output_text);
        RadioGroup toLanguage = findViewById(R.id.toLanguage);
        Button translate_button = findViewById(R.id.translate_button);
        RadioButton toIndonesia = findViewById(R.id.toIndonesia);
        toIndonesia.setChecked(true);

        Retrofit retrofitLanguage = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.language_baseurl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LanguageService languageService = retrofitLanguage.create(LanguageService.class);

        translate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int targetLanguage = toLanguage.getCheckedRadioButtonId();
                String languageCode = "id";
                if (targetLanguage == R.id.toChinese) {
                    languageCode = "zh";
                }

                LanguageRequest requestBody = new LanguageRequest();
                requestBody.setSl("en");
                requestBody.setTl(languageCode);

                List<String> toTranslate = new ArrayList<>();
                toTranslate.add(input_text.getText().toString());
                toTranslate.add("Extra");
                requestBody.setTexts(toTranslate);

                Call<LanguageResponse> languageResponse = languageService.GetResponse(
                        getResources().getString(R.string.language_api_token),
                        getResources().getString(R.string.language_api_host),
                        "application/json", requestBody);

                languageResponse.enqueue(new Callback<LanguageResponse>() {
                    @Override
                    public void onResponse(Call<LanguageResponse> call, Response<LanguageResponse> response) {
                        output_text.setText(response.body().getTexts().get(0));
                    }

                    @Override
                    public void onFailure(Call<LanguageResponse> call, Throwable t) {
                        Log.d(TAG, "API FAIL 3: " + t.getMessage());
                    }
                });
            }
        });
    }
}