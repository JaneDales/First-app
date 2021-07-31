package com.example.firstapp.ui.todos;

import java.util.List;

public interface TodosContract {
    void showProgress();
    void hideProgress();
    void onTodosLoaded(List<Todos> list);
    void onFail(Throwable throwable);
}
