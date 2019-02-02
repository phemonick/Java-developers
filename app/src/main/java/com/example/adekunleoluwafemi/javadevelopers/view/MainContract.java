package com.example.adekunleoluwafemi.javadevelopers.view;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;

import java.util.List;

public interface MainContract {

    /**
     * called for android functionality.
     */
    interface MainView {

        void displayDevList(List<GithubUser> allUsers);
        void hideProgress();
        void showProgress();
        void onResponseFailure(Throwable throwable);
    }

    /**
     * called when user interacts with view.
     */
    interface GithubPresenter {
        void setView(MainView view);
        void getGithubUsers();
        void onRefresh();
    }

    /**
     * for fetching data.
     */
    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(List<GithubUser> githubUserArrayList);
            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }
}
