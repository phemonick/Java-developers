package com.example.adekunleoluwafemi.javadevelopers;

import com.example.adekunleoluwafemi.javadevelopers.presenter.GithubPresenterImpl;
import com.example.adekunleoluwafemi.javadevelopers.services.RetrofitInstance;
import com.example.adekunleoluwafemi.javadevelopers.view.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    public MainContract.GetNoticeIntractor getNoticeIntractor() {
        return new RetrofitInstance();
    }

    @Provides
    public MainContract.GithubPresenter provideGithubPresenter(MainContract.GetNoticeIntractor getNoticeIntractor) {

        return new GithubPresenterImpl(getNoticeIntractor);
    }
}
