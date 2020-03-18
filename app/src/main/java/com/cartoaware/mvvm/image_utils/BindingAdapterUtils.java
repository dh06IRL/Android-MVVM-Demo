package com.cartoaware.mvvm.image_utils;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.cartoaware.mvvmdemo.R;
import com.squareup.picasso.Picasso;

public class BindingAdapterUtils {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imgUrl) {
        if(!TextUtils.equals("", imgUrl)) {
            Picasso.get().load(imgUrl)
                    .error(R.mipmap.ic_launcher_web)
                    .into(view);
        }else{
            Picasso.get().load(R.mipmap.ic_launcher_web)
                    .error(R.mipmap.ic_launcher_web)
                    .into(view);
        }
    }

}
