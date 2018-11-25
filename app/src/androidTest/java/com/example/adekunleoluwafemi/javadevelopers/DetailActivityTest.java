package com.example.adekunleoluwafemi.javadevelopers;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class DetailActivityTest {

    @Rule
    public ActivityTestRule<DetailActivity> mActivityRule
            = new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void displayImage() {
        onView(withId(R.id.display_image)).check(matches(isDisplayed()));
    }

    @Test
    public void githubTextView() {
        onView(withId(R.id.textView16)).check(matches(isDisplayed()));
    }

    @Test
    public void showCardView() {
        onView(withId(R.id.card_view)).check(matches(isDisplayed()));

    }
}
