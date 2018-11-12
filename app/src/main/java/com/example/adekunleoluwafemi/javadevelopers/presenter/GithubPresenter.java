package com.example.adekunleoluwafemi.javadevelopers.presenter;

import android.util.Log;

import com.example.adekunleoluwafemi.javadevelopers.MainView;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsers;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersResponse;
import com.example.adekunleoluwafemi.javadevelopers.services.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter {



    private static final String TAG = "GithupPresenteTag";
    private RetrofitInstance retrofitInstance = new RetrofitInstance();
    private List<GithubUsers> foundUsers;
    MainView mainView;

    public GithubPresenter(MainView mainView) {
        this.mainView = mainView;
        getGithubUsers();
    }


    public void getGithubUsers() {
        retrofitInstance
                .getData()
                .getUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
            @Override
            public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                int responseCode = response.code();
                if(responseCode == 200) {
                    String see = response.toString();
                    List<GithubUsers> users = response.body().getGithubUsers();
                    String responseAsString = users.toString();
                    mainView.displayDevList(users);
                    Log.d(TAG, "onResponse: " + responseAsString);
                }else{
                    Log.d(TAG, "noResponse: " + "Nothing was fetched");
                }
            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                try {
                    throw new InterruptedException("Something went wrong!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.e(TAG, "onFailure: ", e);
                }
            }
        });

    }
}
