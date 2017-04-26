package com.abeade.android.architecture.testapp.presentation.di.module;

import android.content.Context;

import com.abeade.android.architecture.testapp.presentation.application.BaseApplication;
import com.abeade.android.architecture.testapp.presentation.di.component.MainActivitySubcomponent;

import javax.inject.Named;
import javax.inject.Singleton;

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
    @Singleton
    @Named("Observer")
    static Scheduler provideObserverScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named("Subscriber")
    static Scheduler provideSubscriberScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    Context provideContext(BaseApplication application) {
        return application.getApplicationContext();
    }

    // Add application level bindings here, e.g.: RestClientApi, Repository, etc.
}