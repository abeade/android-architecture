package com.abeade.android.architecture.testapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;
import com.abeade.android.architecture.testapp.setup.TestAndroidApplication;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.abeade.android.architecture.testapp", appContext.getPackageName());
    }

    @Test
    public void validateUserLoaded() throws InterruptedException {
        ((TestAndroidApplication)InstrumentationRegistry.getTargetContext().getApplicationContext()).getNetworkBehavior().setDelay(1000, TimeUnit.MILLISECONDS);

        onView(withId(R.id.tv_content)).check(matches(withText("Loading...")));
        Thread.sleep(2000);
        onView(withId(R.id.tv_content)).check(matches(withText("Name0")));
    }
}
