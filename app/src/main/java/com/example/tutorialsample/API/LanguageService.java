package com.example.tutorialsample.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface LanguageService {
    @POST("translate")
    Call<LanguageResponse> GetResponse(@Header("X-RapidAPI-Key") String key,
                                       @Header("X-RapidAPI-Host") String host,
                                       @Header("content-type") String contentType,
                                       @Body LanguageRequest body);
}
