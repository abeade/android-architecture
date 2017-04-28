package com.abeade.android.architecture.testapp.presentation.application;

import android.app.Activity;
import android.app.Application;

import com.abeade.android.architecture.testapp.presentation.di.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

public abstract class BaseApplication extends Application implements HasDispatchingActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    protected void initializeInjector() {
        DaggerApplicationComponent.create().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
