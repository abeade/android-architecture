package com.abeade.android.architecture.testapp.setup.di.component;

import com.abeade.android.architecture.testapp.presentation.di.component.ApplicationComponent;
import com.abeade.android.architecture.testapp.presentation.di.module.ApplicationModule;
import com.abeade.android.architecture.testapp.presentation.di.module.BuildersModule;
import com.abeade.android.architecture.testapp.setup.TestAndroidApplication;
import com.abeade.android.architecture.testapp.setup.di.module.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, MockNetworkModule.class, BuildersModule.class})
public interface TestApplicationComponent extends ApplicationComponent {

    void inject(TestAndroidApplication app);
}
