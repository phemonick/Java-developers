package com.example.adekunleoluwafemi.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Github user model.
 */
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

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("site_admin")
    @Expose
    private boolean isAdmin;

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public void setGithub_link(String github_link) {
        this.github_link = github_link;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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

    public String getId() {
        return id;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }
}
