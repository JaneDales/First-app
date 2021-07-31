package com.example.firstapp.ui.users;

import java.util.List;

public interface UsersContract {
    void showProgress();
    void hideProgress();
    void getUsers(List<User> list);
    void onFailure(Throwable throwable);
}
