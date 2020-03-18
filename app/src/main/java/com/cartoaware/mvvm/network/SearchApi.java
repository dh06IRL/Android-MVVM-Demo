package com.cartoaware.mvvm.network;

import com.cartoaware.mvvm.data.PixabayResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchApi {
    //Adding passing in page + page limit, may not get time to include
    //Adding flexibility for various search input, add search bar?
    @GET("api")
    Call<PixabayResponse> getPhotosList(@Query("key") String apiKey,
                                      @Query("q") String searchQuery,
                                      @Query("image_type") String imageType,
                                      @Query("safesearch") Boolean safeSearch,
                                      @Query("per_page") Integer perPageLimit);
}
