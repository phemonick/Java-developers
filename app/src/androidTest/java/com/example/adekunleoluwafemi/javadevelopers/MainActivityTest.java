package com.example.adekunleoluwafemi.javadevelopers;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.anything;
import android.support.test.espresso.contrib.RecyclerViewActions;



@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displayRecyclerView() {
        onView(withId(R.id.my_recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    public void displaySwipeToRefresh() {
        onView(withId(R.id.swipe_refresh)).check(matches(isDisplayed()));
    }

    @Test
    public void onClickGridItem() {
        onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions
                .scrollToPosition(3));

    }
}
