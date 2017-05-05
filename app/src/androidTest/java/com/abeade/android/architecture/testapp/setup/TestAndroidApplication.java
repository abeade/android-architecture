package com.abeade.android.architecture.testapp.setup;

import com.abeade.android.architecture.testapp.presentation.application.AndroidApplication;
import com.abeade.android.architecture.testapp.setup.di.component.DaggerTestApplicationComponent;
import com.abeade.android.architecture.testapp.setup.di.component.TestApplicationComponent;

import javax.inject.Inject;

import retrofit2.mock.NetworkBehavior;

public class TestAndroidApplication extends AndroidApplication {

    @Inject
    NetworkBehavior behavior;

    private TestApplicationComponent daggerTestApplicationComponent;

    @Override
    protected void initializeInjector() {
        daggerTestApplicationComponent = DaggerTestApplicationComponent.create();
        daggerTestApplicationComponent.inject(this);
    }

    public NetworkBehavior getNetworkBehavior() {
        return behavior;
    }

    public TestApplicationComponent getDaggerTestApplicationComponent() {
        return daggerTestApplicationComponent;
    }
}
