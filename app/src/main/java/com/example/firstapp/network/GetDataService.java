package com.example.firstapp.network;

import com.example.firstapp.ui.comments.Comment;
import com.example.firstapp.ui.todos.Todos;
import com.example.firstapp.ui.users.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("comments")
    Call<List<Comment>> getComments();
    
    @GET("todos")
    Call<List<Todos>> getTodos();
}
