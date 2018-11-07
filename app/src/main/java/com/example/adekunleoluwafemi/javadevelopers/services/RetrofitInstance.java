package com.example.adekunleoluwafemi.javadevelopers.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.github.com/search/users";

    public static GetGithubUsers getData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GetGithubUsers.class);
    }
}
