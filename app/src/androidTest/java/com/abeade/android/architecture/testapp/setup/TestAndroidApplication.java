package com.abeade.android.architecture.testapp.setup;

import com.abeade.android.architecture.testapp.presentation.application.AndroidApplication;
import com.abeade.android.architecture.testapp.setup.di.component.DaggerTestApplicationComponent;

public class TestAndroidApplication extends AndroidApplication {

    @Override
    protected void initializeInjector() {
        DaggerTestApplicationComponent.create().inject(this);
    }
}
