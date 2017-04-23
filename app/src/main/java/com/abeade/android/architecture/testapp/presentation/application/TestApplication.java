package com.abeade.android.architecture.testapp.presentation.application;

import android.app.Activity;
import android.app.Application;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasDispatchingActivityInjector;

import com.abeade.android.architecture.testapp.presentation.di.component.ApplicationComponent;
import com.abeade.android.architecture.testapp.presentation.di.component.DaggerApplicationComponent;
import com.abeade.android.architecture.testapp.presentation.di.module.ApplicationModule;

import javax.inject.Inject;

public class TestApplication extends Application implements HasDispatchingActivityInjector {
    private ApplicationComponent applicationComponent;
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return null;
    }
}
