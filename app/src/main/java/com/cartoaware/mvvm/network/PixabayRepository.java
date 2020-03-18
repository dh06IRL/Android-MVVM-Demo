package com.cartoaware.mvvm.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.cartoaware.mvvm.data.PixabayResponse;
import com.cartoaware.mvvmdemo.BuildConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixabayRepository {

    private static PixabayRepository pixabayRepository;

    public static PixabayRepository getInstance() {
        if (pixabayRepository == null) {
            pixabayRepository = new PixabayRepository();
        }
        return pixabayRepository;
    }

    private SearchApi searchApi;

    public PixabayRepository() {
        searchApi = ApiService.createApiService(SearchApi.class);
    }

    public MutableLiveData<PixabayResponse> getPixabayPhotos(String imageType, Integer perPageLimit) {
        MutableLiveData<PixabayResponse> pixabayData = new MutableLiveData<>();
        Call<PixabayResponse> call = searchApi.getPhotosList(BuildConfig.PIXABAY_KEY,
                "formula+1",
                imageType,
                true,
                perPageLimit);
        call.enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("RESPONSE", response.raw().toString());
                    pixabayData.setValue(response.body());
                } else {
                    Log.d("RESPONSE", "NOT Successful");
                }
            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {
                pixabayData.setValue(null);
            }
        });
        return pixabayData;
    }

}
