package com.example.adekunleoluwafemi.javadevelopers.services;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGithubUsers {
    /**
     * Call = return type.
     * A class is needed to create an object out of
     * the interface declaration(Service)
     * @return
     */
    @GET("search/users?q=language:java+location:nairobi&per_page=40&sort=followers")
    Call<GithubUsersList> getUsers();

}