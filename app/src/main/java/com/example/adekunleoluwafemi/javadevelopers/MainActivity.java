package com.example.adekunleoluwafemi.javadevelopers;

import android.net.Network;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.adekunleoluwafemi.javadevelopers.adapter.GithubAdapter;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.presenter.GithubPresenter;
import com.example.adekunleoluwafemi.javadevelopers.util.NetworkUtility;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mUserList;
    public GithubPresenter presenter;
    public GithubAdapter mAdapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefresh;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = findViewById(R.id.my_recycler_view);
        progressBar = findViewById(R.id.progress);
        coordinatorLayout = findViewById(R.id
                .coordinatorLayout);
        presenter = new GithubPresenter(this);
        isConnected();
        swipeRefresh = findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getGithubUsers();
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    public void showSnackBar() {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        isConnected();
                    }
                });
        snackbar.show();
    }

    public void isConnected() {
        if (NetworkUtility.checkStatus(this)) {
            presenter.getGithubUsers();
        }else {
            showSnackBar();
        }
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
