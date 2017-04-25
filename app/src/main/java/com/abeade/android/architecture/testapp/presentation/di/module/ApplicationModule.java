package com.abeade.android.architecture.testapp.presentation.di.module;

import android.content.Context;

import com.abeade.android.architecture.testapp.presentation.application.TestApplication;
import com.abeade.android.architecture.testapp.presentation.di.component.MainActivitySubcomponent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Application module refers to sub components and provides application level dependencies.
 */
@Module(subcomponents = { MainActivitySubcomponent.class /* Add additional sub components here */ })
public class ApplicationModule {
    @Provides
    @Named("Observer")
    static Scheduler provideObserverScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named("Subscriber")
    static Scheduler provideSubscriberScheduler() {
        return Schedulers.io();
    }

    @Provides Context provideContext(TestApplication application) {
        return application.getApplicationContext();
    }

    // Add application level bindings here, e.g.: RestClientApi, Repository, etc.
}