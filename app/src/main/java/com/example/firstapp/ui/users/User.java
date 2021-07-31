package com.example.firstapp.ui.users;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String nickName;

    @SerializedName("phone")
    private String phone;

    private String link = "https://images.squarespace-cdn.com/content/v1/53226684e4b08a6c35f84cbe/1512971655960-25Z9DWXDYJESSZ5W1ZWP/Batman.jpg";

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getNickName() {
        return nickName;
    }
}

