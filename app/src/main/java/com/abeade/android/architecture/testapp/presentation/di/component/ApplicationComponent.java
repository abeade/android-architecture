package com.abeade.android.architecture.testapp.presentation.di.component;

import com.abeade.android.architecture.testapp.presentation.application.TestApplication;
import com.abeade.android.architecture.testapp.presentation.di.module.MainActivityModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, MainActivityModule.class})
public interface ApplicationComponent {
    void inject(TestApplication application);
}
