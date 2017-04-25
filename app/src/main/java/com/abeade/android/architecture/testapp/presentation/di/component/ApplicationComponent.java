package com.abeade.android.architecture.testapp.presentation.di.component;

import com.abeade.android.architecture.testapp.presentation.application.TestApplication;
import com.abeade.android.architecture.testapp.presentation.di.module.ApplicationModule;
import com.abeade.android.architecture.testapp.presentation.di.module.BuildersModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, BuildersModule.class})
public interface ApplicationComponent {
    void inject(TestApplication app);
}
