package com.example.adekunleoluwafemi.javadevelopers.services;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUsersList;
import com.example.adekunleoluwafemi.javadevelopers.view.MainContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance implements MainContract.GetNoticeIntractor {

    private static Retrofit retrofit;

    private static String BASE_URL = "https://api.github.com";

    /**
     * builder to make api request.
     * converterFactory converts into datatype that we can use
     * @return instance of GetGithubUsers class
     */
    public static GetGithubUsers getData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GetGithubUsers.class);
    }

    @Override
    public void getNoticeArrayList(final OnFinishedListener onFinishedListener) {
        Call<GithubUsersList> call = getData().getUsers();

        call.enqueue(new Callback<GithubUsersList>() {
            @Override
            public void onResponse(Call<GithubUsersList> call, Response<GithubUsersList> response) {
                int responseCode = response.code();
                if (responseCode == 200) {
                    List<GithubUser> users = response.body().getGithubUsers();
                    onFinishedListener.onFinished(users);
                }
            }

            @Override
            public void onFailure(Call<GithubUsersList> call, Throwable throwable) {
                try {
                    onFinishedListener.onFailure(throwable);
                    throw new InterruptedException("Something went wrong!");

                } catch (InterruptedException e) {
                    onFinishedListener.onFailure(throwable);
                    e.printStackTrace();
                }
            }
        });
    }


}
