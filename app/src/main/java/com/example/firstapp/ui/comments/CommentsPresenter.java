package com.example.firstapp.ui.comments;
import java.util.List;

public class CommentsPresenter implements OnFinishedListener {
    private CommentsContract contract;
    private CommentsModel model = new CommentsModel(this);

    public CommentsPresenter(CommentsContract contract) {
        this.contract = contract;
    }

    public void getCats(){
        contract.showProgress();
        model.getComments();
    }

    @Override
    public void onFinished(List<Comment> list) {
        contract.hideProgress();
        contract.getCats(list);
    }

    @Override
    public void onFailure(Throwable throwable) {
        contract.hideProgress();
        contract.onFailure(throwable);
    }
}

