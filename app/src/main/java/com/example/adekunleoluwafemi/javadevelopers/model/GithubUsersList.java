package com.example.adekunleoluwafemi.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import java.util.List;

/**
 * getList of githubUser model.
 */
public class GithubUsersList {
    @SerializedName("items")
    @Expose
    private List<GithubUser> githubUsers = new ArrayList<>();

    /**
     * list of github users.
     * @return githubUsers
     */
    public List<GithubUser> getGithubUsers() {
        return githubUsers;
    }
}
