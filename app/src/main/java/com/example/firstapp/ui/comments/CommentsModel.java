package com.example.firstapp.ui.comments;

import com.example.firstapp.network.GetDataService;
import com.example.firstapp.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface OnFinishedListener {
    void onFinished(List<Comment> list);
    void onFailure(Throwable throwable);
}
public class CommentsModel {
    private com.example.firstapp.ui.comments.OnFinishedListener onFinishedListener;

    public CommentsModel(com.example.firstapp.ui.comments.OnFinishedListener onFinishedListener) {
        this.onFinishedListener = onFinishedListener;
    }
    public void getComments(){

        /** Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<List<Comment>> call = service.getComments();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}