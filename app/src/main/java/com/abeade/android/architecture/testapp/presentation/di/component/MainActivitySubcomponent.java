package com.abeade.android.architecture.testapp.presentation.di.component;

import com.abeade.android.architecture.testapp.presentation.di.PerActivity;
import com.abeade.android.architecture.testapp.presentation.di.module.ActivityModule;
import com.abeade.android.architecture.testapp.presentation.di.module.MainActivityModule;
import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@PerActivity
@Subcomponent(modules = {ActivityModule.class, MainActivityModule.class})
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
