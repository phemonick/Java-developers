package com.example.adekunleoluwafemi.javadevelopers.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {
    @SerializedName("items")
    @Expose
    private List<GithubUsers> githubUsers ;

    GithubUsersResponse() {
        githubUsers = new ArrayList<GithubUsers>();
    }


//    returns List of type GithubUsers
    public List<GithubUsers> getGithubUsers() {
        return githubUsers;
    }
}
