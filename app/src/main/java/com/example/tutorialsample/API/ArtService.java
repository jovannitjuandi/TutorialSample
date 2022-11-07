package com.example.tutorialsample.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName; // adds a query without a key

// https://collectionapi.metmuseum.org/public/collection/v1/search?q=te&hasImages=true
// https://collectionapi.metmuseum.org/public/collection/v1/objects/549236
public interface ArtService {
    @GET("search")
    Call<ArtResponse> getArtIds(@Query("hasImages") boolean hasImages, @Query("q") String q);

    @GET("objects/{objectId}")
    Call<ArtObjectResponse> getArtById(@Path("objectId") Integer objectId);

}
