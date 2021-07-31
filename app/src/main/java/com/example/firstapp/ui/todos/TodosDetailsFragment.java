package com.example.firstapp.ui.todos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.firstapp.R;

public class TodosDetailsFragment extends Fragment {

    private static final String ARG_PARAM_TODOS = "param_todos";

    private Todos todos;


    public static TodosDetailsFragment newInstance(Todos todos) {
        TodosDetailsFragment fragment = new TodosDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_TODOS, todos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            todos = (Todos) getArguments().getSerializable(ARG_PARAM_TODOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todos_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvTitle;
        CheckBox tvCompleted;
        tvTitle = view.findViewById(R.id.tvTitle);
        tvCompleted = view.findViewById(R.id.tvCompleted);
        tvTitle.setText(todos.getTitle());
        tvCompleted.setChecked(todos.getCompleted());
    }
}