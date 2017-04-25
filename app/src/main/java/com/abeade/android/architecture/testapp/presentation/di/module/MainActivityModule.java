package com.abeade.android.architecture.testapp.presentation.di.module;

import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.navigation.NavigatorImpl;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenter;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenterImpl;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;
import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainActivityModule {
    @Provides
    static Navigator provideNavigator(MainActivity activity) {
        return new NavigatorImpl(activity);
    }

    @Provides
    static MainActivityPresenter providePresenter(MainActivityView view, Navigator navigator) {
        return new MainActivityPresenterImpl(view, navigator);
    }

    @Binds
    abstract MainActivityView provideMainActivityView(MainActivity featureActivity);
}
