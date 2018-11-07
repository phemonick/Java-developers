package com.example.adekunleoluwafemi.javadevelopers.services;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGithubUsers {
    @GET("?q=type:User+location:Nairobi+language:JAVA")
    public Call<GithubUsersResponse> getUsers();


}
