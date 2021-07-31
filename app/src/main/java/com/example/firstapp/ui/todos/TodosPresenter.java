package com.example.firstapp.ui.todos;

import java.util.List;

public class TodosPresenter implements TodosOnFinishedListener{
    private TodosContract todosContract;
    private TodosModel todosModel = new TodosModel(this);

    public TodosPresenter (TodosContract todosContract){
        this.todosContract = todosContract;
    }

    public void getTodos(){
        todosContract.showProgress();
        todosModel.getTodos();
    }

    @Override
    public void onFinished(List<Todos> list) {
        todosContract.hideProgress();
        todosContract.onTodosLoaded(list);
    }

    @Override
    public void onFailure(Throwable throwable) {
        todosContract.hideProgress();
        todosContract.onFail(throwable);
    }
}
