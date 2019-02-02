package com.example.adekunleoluwafemi.javadevelopers;

import com.example.adekunleoluwafemi.javadevelopers.model.GithubUser;
import com.example.adekunleoluwafemi.javadevelopers.presenter.GithubPresenterImpl;
import com.example.adekunleoluwafemi.javadevelopers.presenter.ViewNotFoundException;
import com.example.adekunleoluwafemi.javadevelopers.view.MainContract;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class GithubPresenterTest {

    MainContract.GithubPresenter githubPresenter;
    MainContract.MainView mockMainView;
    MainContract.GetNoticeIntractor mockGetNoticeIntractor;
    MainContract.GetNoticeIntractor.OnFinishedListener mockOnFinishedListener;

    GithubPresenterImpl mockGithubPresenterImpl;

    @Before
    public void setUp() {
        mockGetNoticeIntractor= mock(MainContract.GetNoticeIntractor.class);
        mockMainView = mock(MainContract.MainView.class);
        githubPresenter = new GithubPresenterImpl(mockGetNoticeIntractor);
        mockOnFinishedListener = mock(MainContract.GetNoticeIntractor.OnFinishedListener.class);
        mockGithubPresenterImpl= new GithubPresenterImpl(mockGetNoticeIntractor);

    }

    @Test
    public void noInteractionWithViewIfUserIsNull() {
        githubPresenter.getGithubUsers();

        verifyZeroInteractions(mockMainView);
    }

    @Test
    public void shouldGetUsersWhenViewIsPresent() {
        mockGithubPresenterImpl.setView(mockMainView);

        mockGithubPresenterImpl.getGithubUsers();

        verify(mockGetNoticeIntractor, times(1)).getNoticeArrayList(mockGithubPresenterImpl);
    }

    @Test
    public void shouldRefreshUserView() {
        mockGithubPresenterImpl.setView(mockMainView);

        mockGithubPresenterImpl.onRefresh();

        verify(mockMainView, times(1)).showProgress();

        verify(mockGetNoticeIntractor, times(1)).getNoticeArrayList(mockGithubPresenterImpl);
    }

    @Test
    public void shouldDisplayListWhenApiCallIsSuccessful() {
        List<GithubUser> userList = mock(List.class);
        mockGithubPresenterImpl.setView(mockMainView);

        mockGithubPresenterImpl.onFinished(userList);

        verify(mockMainView, times(1)).displayDevList(userList);

        verify(mockMainView, times(1)).hideProgress();
    }

    @Test
    public void shouldThrowAnErrorWhenApiCallFails() {
        Throwable t = mock(Throwable.class);
        mockGithubPresenterImpl.setView(mockMainView);

        mockGithubPresenterImpl.onFailure(t);

        verify(mockMainView, times(1)).onResponseFailure(t);

        verify(mockMainView, times(1)).hideProgress();
    }

    @Test(expected = ViewNotFoundException.class)
    public void shouldThrowViewNotFoundExceptionWhenViewIsNull() {
        mockGithubPresenterImpl.setView(null);
    }


}
