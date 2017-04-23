package com.abeade.android.architecture.testapp.presentation.di.component;

import android.app.Activity;

import com.abeade.android.architecture.testapp.presentation.di.PerActivity;
import com.abeade.android.architecture.testapp.presentation.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
