package com.example.adekunleoluwafemi.javadevelopers.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GithubUsersResponse {
    @SerializedName("items")
    @Expose
//    List of type GithubUsers from model
    private List<GithubUsers> githubUsers;

//    To avoid null pointer exceptions from trying to get back the user lists,
    public GithubUsersResponse() {
        githubUsers = new ArrayList<GithubUsers>();
    }

    public static GithubUsersResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        GithubUsersResponse githubUsersResponse = gson.fromJson(response, GithubUsersResponse.class);
        return githubUsersResponse;
    }

//    returns List of type GithubUsers
    public List<GithubUsers> getGithubUsers() {
        return githubUsers;
    }
}
