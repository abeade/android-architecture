package com.abeade.android.architecture.testapp.presentation.di.module;

import android.app.Activity;

import com.abeade.android.architecture.testapp.presentation.di.component.MainActivitySubcomponent;
import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);

    // Add another builder binding here
}