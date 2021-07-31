package com.example.firstapp.ui.comments;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Comment implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("body")
    private String body;

    private String link = "https://i.ytimg.com/vi/1Ne1hqOXKKI/maxresdefault.jpg";

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }

    public String getEmail() {
        return email;
    }

    public String getLink() {
        return link;
    }
}
