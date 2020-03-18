package com.cartoaware.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cartoaware.mvvm.network.PixabayRepository;
import com.cartoaware.mvvm.data.PixabayResponse;
import com.cartoaware.mvvm.utils.Constants;

public class PixabayPhotosViewModel extends ViewModel {

    private MutableLiveData<PixabayResponse> pixabayLiveData;
    private PixabayRepository pixabayRepository;

    public void init() {
        if (pixabayLiveData != null) {
            return;
        }
        pixabayRepository = PixabayRepository.getInstance();
        pixabayLiveData = pixabayRepository.getPixabayPhotos(Constants.API_IMAGE_TYPE_PHOTO, Constants.API_PER_PAGE_LIMIT);
    }

    public LiveData<PixabayResponse> getPixabayRepository() {
        return pixabayLiveData;
    }

}
