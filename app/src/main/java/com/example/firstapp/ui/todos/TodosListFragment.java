package com.example.firstapp.ui.todos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class TodosListFragment extends BaseFragment implements TodosClickListener, TodosContract {

    private TodosPresenter todosPresenter = new TodosPresenter(this);
    private TodosAdapter todosAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    public static TodosListFragment newInstance() {
        return new TodosListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todos_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        todosPresenter.getTodos();
    }

    @Override
    public void onTodosClick(Todos todos) {
        Fragment fragment = TodosDetailsFragment.newInstance(todos);
        openFragment(fragment, R.id.container);
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
    public void onTodosLoaded(List<Todos> list) {
        todosAdapter = new TodosAdapter(list, this);
        recyclerView.setAdapter(todosAdapter);
    }

    @Override
    public void onFail(Throwable throwable) {
        Toast.makeText(requireContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}