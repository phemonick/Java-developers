package com.example.adekunleoluwafemi.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubUsersResponse {
    @SerializedName("items")
    @Expose
//    List of type GithubUsers from model
    private List<GithubUsers> githubUsers;

//    returns List of type GithubUsers
    public List<GithubUsers> getGithubUsers() {
        return githubUsers;
    }
}
