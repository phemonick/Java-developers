package com.example.adekunleoluwafemi.javadevelopers;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;

import java.util.List;

public interface MainView {

    void displayDevList(List<GithubUser> allUsers);
    void hideProgress();
    void showProgress();
}
