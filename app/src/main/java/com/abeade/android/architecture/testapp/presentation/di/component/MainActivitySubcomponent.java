package com.abeade.android.architecture.testapp.presentation.di.component;

import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
