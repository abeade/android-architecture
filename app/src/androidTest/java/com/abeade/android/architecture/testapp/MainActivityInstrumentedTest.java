package com.abeade.android.architecture.testapp;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.abeade.android.architecture.testapp.data.network.api.UsersApi;
import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;
import com.abeade.android.architecture.testapp.setup.TestAndroidApplication;
import com.abeade.android.architecture.testapp.setup.data.webservice.MockUserApi;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import retrofit2.mock.NetworkBehavior;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    private static final int NETWORK_DELAY = 1000;

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(MainActivity.class, true, false);

    @Inject
    NetworkBehavior networkBehavior;
    @Inject
    UsersApi mockApi;

    private MockUserApi getMockApi() {
        return (MockUserApi)mockApi;
    }

    @Before
    public void setUp() {
        ((TestAndroidApplication)InstrumentationRegistry.getTargetContext().getApplicationContext()).getDaggerTestApplicationComponent().inject(this);
        networkBehavior.setDelay(NETWORK_DELAY, TimeUnit.MILLISECONDS);
        networkBehavior.setVariancePercent(0);
        networkBehavior.setErrorPercent(0);
        networkBehavior.setFailurePercent(0);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.abeade.android.architecture.testapp", appContext.getPackageName());
    }

    @Test
    public void validateUserLoadedSuccess() throws InterruptedException {
        Instrumentation inst = InstrumentationRegistry.getInstrumentation();
        // Ensure no error on next call
        networkBehavior.setErrorPercent(0);
        activityRule.launchActivity(null);

        inst.waitForIdleSync();
        onView(withId(R.id.tv_content)).check(matches(withText(R.string.loading)));
        Thread.sleep(NETWORK_DELAY);
        onView(withId(R.id.tv_content)).check(matches(withText(getMockApi().getStubUsersData().get(0).getName())));
    }

    @Test
    public void validateUserLoadedError() throws InterruptedException {
        Instrumentation inst = InstrumentationRegistry.getInstrumentation();
        // Ensure network error on next call
        networkBehavior.setErrorPercent(100);
        activityRule.launchActivity(null);

        inst.waitForIdleSync();
        onView(withId(R.id.tv_content)).check(matches(withText(R.string.loading)));
        Thread.sleep(NETWORK_DELAY);
        onView(withId(R.id.tv_content)).check(matches(withText(R.string.error)));
    }
}
