package br.com.wellingtoncosta.amd.ui;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import br.com.wellingtoncosta.amd.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.com.wellingtoncosta.amd.util.RecyclerViewItemCountAssertion.hasItemCount;
import static org.hamcrest.core.AllOf.allOf;

/**
 * @author Wellington Costa on 30/12/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void showActivityWithSuccess() {
        onView(withId(R.id.tabs))
                .check(matches(isDisplayed()));
    }

    @Test
    public void listUsersWithSuccess() {
        onView(allOf(
                withId(R.id.recycler_view),
                isDescendantOfA(withId(R.id.list_users))
        )).check(hasItemCount(3));
    }

    @Test
    public void listColorssWithSuccess() {
        onView(allOf(
                withText(R.string.colors),
                isDescendantOfA(withId(R.id.tabs))
        )).perform(click());

        onView(allOf(
                withId(R.id.recycler_view),
                isDescendantOfA(withId(R.id.list_colors))
        )).check(hasItemCount(3));
    }

}