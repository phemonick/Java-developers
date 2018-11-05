package com.example.adekunleoluwafemi.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubUser {

    @SerializedName("avatar_url")
    @Expose
    private String userImage;

    @SerializedName("html_url")
    @Expose
    private String github_link;

    @SerializedName("login")
    @Expose
    private String username;

    public GithubUser(String username, String github_link, String userImage) {
        this.username = username;
        this.github_link = github_link;
        this.userImage = userImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUsername() {
        return username;
    }

    public String getGithubLink() {
        return github_link;
    }
}
