package com.example.firstapp.ui.comments;
import java.util.List;

public interface CommentsContract {
    void getCats(List<Comment> list);
    void showProgress();
    void hideProgress();
    void onFailure(Throwable throwable);
}
