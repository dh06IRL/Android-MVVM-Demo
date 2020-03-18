package com.cartoaware.mvvm.network;

import com.cartoaware.mvvmdemo.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .baseUrl(BuildConfig.PIXABAY_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createApiService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
