package com.example.adekunleoluwafemi.javadevelopers;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class modelTest {

    GithubUser githubUser= new GithubUser();

    @Test
    public void shouldSetModel() {
        githubUser.setUsername("phemy");
        githubUser.setGithub_link("http://getlink");
        githubUser.setAdmin(true);
        githubUser.setUserImage("picasso_image");
        githubUser.setId("3456");

        assertEquals("phemy", githubUser.getUsername());
        assertEquals("http://getlink", githubUser.getGithubLink());
        assertEquals(true, githubUser.getIsAdmin());
        assertEquals("picasso_image", githubUser.getUserImage());
        assertEquals("3456", githubUser.getId());
    }

    @Test
    public void shouldReturnDevList() {

        GithubUsersList githubUsersList = new GithubUsersList();
        List<GithubUser> githubUsers = new ArrayList<>();

        assertEquals(githubUsers, githubUsersList.getGithubUsers());

    }
}
