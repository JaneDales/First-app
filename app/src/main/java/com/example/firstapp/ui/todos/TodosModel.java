package com.example.firstapp.ui.todos;

import com.example.firstapp.network.GetDataService;
import com.example.firstapp.network.RetrofitInstance;
import com.example.firstapp.ui.comments.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

interface TodosOnFinishedListener {
    void onFinished(List<Todos> list);
    void onFailure(Throwable throwable);
}
public class TodosModel {
    private TodosOnFinishedListener todosOnFinishedListener;

    public TodosModel(TodosOnFinishedListener listener){
        todosOnFinishedListener = listener;
    }

    public void getTodos(){
        /** Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<List<Todos>> call = service.getTodos();

        call.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                todosOnFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                todosOnFinishedListener.onFailure(t);
            }
        });
    }
}
