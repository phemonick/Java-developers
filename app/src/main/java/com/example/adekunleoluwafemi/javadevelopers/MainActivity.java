package com.example.adekunleoluwafemi.javadevelopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.adekunleoluwafemi.javadevelopers.adapter.GithubAdapter;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsers;
import com.example.adekunleoluwafemi.javadevelopers.presenter.GithubPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mUserList;
    public GithubPresenter presenter;
    public GithubAdapter mAdapter;

    private static final String TAG = "GithupPresenteTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = findViewById(R.id.my_recycler_view);
        presenter = new GithubPresenter(this);
    }

    @Override
    public void displayDevList(List<GithubUsers> allUsers) {
        mUserList.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GithubAdapter(allUsers, this);
        mUserList.setAdapter(mAdapter);
    }

}
