package com.example.firstapp.ui.comments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.ui.base.BaseFragment;

import java.util.List;

public class CommentsListFragment extends BaseFragment implements CommentsContract, CommentClickListener {

    private CommentsPresenter presenter = new CommentsPresenter(this);

    private RecyclerView recyclerView;
    private CommentsAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comments_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerView);

        presenter.getCats();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void getCats(List<Comment> list) {
        adapter = new CommentsAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(requireContext(), throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCommentClick(Comment comment) {
        Fragment fragment = CommentDetailsFragment.newInstance(comment);
        openFragment(fragment, R.id.container);
    }
}