package com.example.adekunleoluwafemi.javadevelopers.presenter;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersResponse;
import com.example.adekunleoluwafemi.javadevelopers.services.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {

    private RetrofitInstance retrofitInstance;

    public void getGithubUsers() {
        retrofitInstance.getData().getUsers().enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                GithubUsersResponse githubUsersResponse = response.body();
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
