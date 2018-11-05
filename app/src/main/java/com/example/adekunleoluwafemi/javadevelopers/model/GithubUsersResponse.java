package com.example.adekunleoluwafemi.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import java.util.List;

public class GithubUsersResponse {
    @SerializedName("items")
    @Expose
    private List<GithubUser> githubUsers ;

    GithubUsersResponse() {
        githubUsers = new ArrayList<GithubUser>();
    }

    //    returns List of type GithubUser
    public List<GithubUser> getGithubUsers() {
        return githubUsers;
    }
}
