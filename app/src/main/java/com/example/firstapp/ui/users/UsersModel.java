package com.example.firstapp.ui.users;

import com.example.firstapp.network.GetDataService;
import com.example.firstapp.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface OnFinishedListener {
    void onFinished(List<User> list);
    void onFailure(Throwable throwable);
}
public class UsersModel {
    private OnFinishedListener onFinishedListener;

    public UsersModel(OnFinishedListener onFinishedListener) {
        this.onFinishedListener = onFinishedListener;
    }
    public void getUsers(){

        /** Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<List<User>> call = service.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
