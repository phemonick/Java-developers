package com.example.adekunleoluwafemi.javadevelopers.presenter;


import com.example.adekunleoluwafemi.javadevelopers.MainView;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersResponse;
import com.example.adekunleoluwafemi.javadevelopers.services.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {


    private RetrofitInstance retrofitInstance = new RetrofitInstance();
    private List<GithubUser> foundUsers;
    MainView mainView;

    public GithubPresenter(MainView mainView) {
        this.mainView = mainView;
    }


    public void getGithubUsers() {
        mainView.showProgress();
        retrofitInstance
                .getData()
                .getUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                int responseCode = response.code();
                if(responseCode == 200) {
                    List<GithubUser> users = response.body().getGithubUsers();
                    String responseAsString = users.toString();
                    mainView.hideProgress();
                    mainView.displayDevList(users);
                }
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                try {
                    throw new InterruptedException("Something went wrong!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
