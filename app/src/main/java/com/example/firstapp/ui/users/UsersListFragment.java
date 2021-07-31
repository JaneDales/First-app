package com.example.firstapp.ui.users;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firstapp.R;
import com.example.firstapp.test.TestA;
import com.example.firstapp.ui.base.BaseFragment;
import com.example.firstapp.ui.users.details.UserDetailsFragment;

import java.util.List;

public class UsersListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        UsersContract, ClickListener  {

    private UsersPresenter presenter = new UsersPresenter(this);

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private UsersAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);

        recyclerView = view.findViewById(R.id.recyclerView);

        presenter.getUsers();

        new TestA().onCreate();
    }

    @Override
    public void showProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void getUsers(List<User> list) {
        adapter = new UsersAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Throwable throwable) {
        Toast.makeText(requireContext(), throwable.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserClick(User user) {
        Fragment fragment = UserDetailsFragment.newInstance(user);
        openFragment(fragment, R.id.container);
    }

    @Override
    public void onRefresh() {
        adapter.clear();
        presenter.getUsers();
    }
}