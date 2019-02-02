package com.example.adekunleoluwafemi.javadevelopers.presenter;

import com.example.adekunleoluwafemi.javadevelopers.view.MainContract;
import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;

import java.util.List;

/**
 * Presenter for mainActivity.
 */
public class GithubPresenterImpl implements MainContract.GithubPresenter, MainContract.GetNoticeIntractor.OnFinishedListener {

    MainContract.GetNoticeIntractor getNoticeIntractor;

    MainContract.MainView mainView;

    /**
     * get all github users.
     */
    @Override
    public void getGithubUsers() {
        getNoticeIntractor.getNoticeArrayList(this);
    }

    /**
     * injects getNoticeIntractor.
     * @param getNoticeIntractor
     */
    public GithubPresenterImpl(MainContract.GetNoticeIntractor getNoticeIntractor) {
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onRefresh() {
        if (mainView != null) {
            mainView.showProgress();
        }
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void setView(MainContract.MainView view) {
        this.mainView = view;
    }

    /**
     * when api call is done.
     * @param githubUserArrayList
     */
    @Override
    public void onFinished(List<GithubUser> githubUserArrayList) {
        if (mainView != null) {
            mainView.displayDevList(githubUserArrayList);
            mainView.hideProgress();
        }
    }

    /**
     * api failure.
     * @param t
     */
    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
