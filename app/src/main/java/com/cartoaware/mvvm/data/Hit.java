package com.cartoaware.mvvm.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit {

    @SerializedName("largeImageURL")
    @Expose
    public String largeImageURL;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("user")
    @Expose
    public String user;
    @SerializedName("userImageURL")
    @Expose
    public String userImageURL;


    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }


    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}
