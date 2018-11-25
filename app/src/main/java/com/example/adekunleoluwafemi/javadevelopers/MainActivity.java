package com.example.adekunleoluwafemi.javadevelopers;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.adekunleoluwafemi.javadevelopers.adapter.GithubAdapter;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.presenter.GithubPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mUserList;
    public GithubPresenter presenter;
    public GithubAdapter mAdapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = findViewById(R.id.my_recycler_view);
        progressBar = findViewById(R.id.progress);
        presenter = new GithubPresenter(this);
        presenter.getGithubUsers();
        swipeRefresh = findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getGithubUsers();
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    public void displayDevList(List<GithubUser> allUsers) {
        mUserList.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new GithubAdapter(allUsers, this);
        mUserList.setAdapter(mAdapter);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

}
