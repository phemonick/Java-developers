package com.example.adekunleoluwafemi.javadevelopers.services;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGithubUsers {
    @GET("search/users?q=language:java+location:nairobi&per_page=40&sort=followers")
    Call<GithubUsersResponse> getUsers();


}