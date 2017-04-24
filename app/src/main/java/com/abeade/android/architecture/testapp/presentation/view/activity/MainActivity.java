package com.abeade.android.architecture.testapp.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.abeade.android.architecture.testapp.R;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import io.reactivex.Scheduler;

public class MainActivity extends AppCompatActivity {

    @Inject
    @Named("Observer")
    Scheduler observerScheduler;

    @Inject
    @Named("Subscriber")
    Scheduler subscriberScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
