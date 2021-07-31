package com.example.firstapp.ui.comments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstapp.R;

public class CommentDetailsFragment extends Fragment {

    private static final String ARG_PARAM_COMMENT = "param_comment";

    private Comment comment;

    public static CommentDetailsFragment newInstance(Comment comment) {
        CommentDetailsFragment fragment = new CommentDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_COMMENT, comment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            comment = (Comment) getArguments().getSerializable(ARG_PARAM_COMMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_comment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName, tvBody;
        tvName = view.findViewById(R.id.tvName);
        tvBody = view.findViewById(R.id.tvBody);
        tvName.setText(comment.getName());
        tvBody.setText(comment.getBody());
    }
}