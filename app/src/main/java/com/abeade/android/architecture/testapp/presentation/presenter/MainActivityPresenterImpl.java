package com.abeade.android.architecture.testapp.presentation.presenter;

import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;

import javax.inject.Inject;

import io.reactivex.Scheduler;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private final MainActivityView view;
    private final Scheduler observerScheduler;
    private final Scheduler subscriberScheduler;
    private final Navigator navigator;

    @Inject
    public MainActivityPresenterImpl(MainActivityView view, Scheduler observerScheduler, Scheduler subscriberScheduler, Navigator navigator) {
        this.view = view;
        this.observerScheduler = observerScheduler;
        this.subscriberScheduler = subscriberScheduler;
        this.navigator = navigator;
    }

    @Override
    public void doNothing() {
        view.doNothing();

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}
