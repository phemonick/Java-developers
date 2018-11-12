package com.example.adekunleoluwafemi.javadevelopers.services;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGithubUsers {
    @GET("https://api.github.com/search/users")
    public Call<GithubUsersResponse> getUsers();


}
