package com.example.firstapp.ui.todos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Todos implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("completed")
    private Boolean completed;

    public String getTitle() {
        return title;
    }
    public Boolean getCompleted() {
        return completed;
    }

}
