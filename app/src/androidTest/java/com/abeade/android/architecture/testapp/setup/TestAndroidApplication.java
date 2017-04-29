package com.abeade.android.architecture.testapp.setup;

import com.abeade.android.architecture.testapp.presentation.application.AndroidApplication;
import com.abeade.android.architecture.testapp.setup.di.component.DaggerTestApplicationComponent;

import javax.inject.Inject;

import retrofit2.mock.NetworkBehavior;

public class TestAndroidApplication extends AndroidApplication {

    @Inject
    NetworkBehavior behavior;

    @Override
    protected void initializeInjector() {
        DaggerTestApplicationComponent.create().inject(this);
    }

    public NetworkBehavior getNetworkBehavior() {
        return behavior;
    }
}
