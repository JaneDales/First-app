package com.example.firstapp.ui.users;

import java.util.List;

public class UsersPresenter implements OnFinishedListener {
    private UsersContract contract;
    private UsersModel model = new UsersModel(this);

    public UsersPresenter(UsersContract contract) {
        this.contract = contract;
    }
    public void getUsers(){
        contract.showProgress();
        model.getUsers();
    }

    @Override
    public void onFinished(List<User> list) {
        contract.hideProgress();
        contract.getUsers(list);
    }

    @Override
    public void onFailure(Throwable throwable) {
        contract.hideProgress();
        contract.onFailure(throwable);
    }
}
