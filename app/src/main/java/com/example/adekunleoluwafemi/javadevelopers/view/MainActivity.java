package com.example.adekunleoluwafemi.javadevelopers.view;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.adekunleoluwafemi.javadevelopers.MvpApplication;
import com.example.adekunleoluwafemi.javadevelopers.R;
import com.example.adekunleoluwafemi.javadevelopers.adapter.GithubAdapter;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.presenter.GithubPresenterImpl;
import com.example.adekunleoluwafemi.javadevelopers.services.RetrofitInstance;
import com.example.adekunleoluwafemi.javadevelopers.util.NetworkUtility;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private RecyclerView mUserList;

    @Inject
    public MainContract.GithubPresenter presenter;

    public GithubAdapter mAdapter;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefresh;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MvpApplication) getApplication()).getComponent().inject(this);
        mUserList = findViewById(R.id.my_recycler_view);
        mUserList.setLayoutManager(new GridLayoutManager(this, 2));
        progressBar = findViewById(R.id.progress);
        coordinatorLayout = findViewById(R.id
                .coordinatorLayout);
        showProgress();
        isConnected();
        swipeRefresh = findViewById(R.id.swipe_refresh);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (NetworkUtility.checkStatus(MainActivity.this)) {
                    presenter.onRefresh();
                } else {
                    showSnackBar();
                }
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    public void showSnackBar() {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, "Sorry, failed to fetch!", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        isConnected();
                    }
                });
        snackbar.show();
    }

    /**
     * check for internet connection.
     */
    public void isConnected() {
        if (NetworkUtility.checkStatus(this)) {
            presenter.getGithubUsers();
        }else {
            showSnackBar();
        }
    }

    @Override
    public void displayDevList(List<GithubUser> allUsers) {
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

    @Override
    public void onResponseFailure(Throwable throwable) {
        showSnackBar();
    }

}
