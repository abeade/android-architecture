package com.abeade.android.architecture.testapp.presentation.di.module;

import android.app.Activity;

import com.abeade.android.architecture.testapp.presentation.di.component.MainActivitySubcomponent;
import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module(subcomponents = {MainActivitySubcomponent.class})
public abstract class MainActivityModule {
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

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);
}
