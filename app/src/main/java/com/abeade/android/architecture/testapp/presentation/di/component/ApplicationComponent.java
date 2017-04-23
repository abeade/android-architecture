package com.abeade.android.architecture.testapp.presentation.di.component;

import android.content.Context;

import com.abeade.android.architecture.testapp.presentation.di.module.ApplicationModule;
import com.abeade.android.architecture.testapp.presentation.view.activity.BaseActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import io.reactivex.Scheduler;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();

    @Named("Observer")
    Scheduler provideObserverScheduler();

    @Named("Subscriber")
    Scheduler providSubscriberScheduler();
}
