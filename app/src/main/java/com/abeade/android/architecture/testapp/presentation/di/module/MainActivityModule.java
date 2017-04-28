package com.abeade.android.architecture.testapp.presentation.di.module;

import android.app.Activity;

import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;
import com.abeade.android.architecture.testapp.domain.interactor.TestUseCase;
import com.abeade.android.architecture.testapp.presentation.di.PerActivity;
import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenter;
import com.abeade.android.architecture.testapp.presentation.presenter.MainActivityPresenterImpl;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;
import com.abeade.android.architecture.testapp.presentation.view.activity.MainActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

@Module
public abstract class MainActivityModule {

    @Provides
    @PerActivity
    static TestUseCase provideTestUseCase(@Named("Observer") Scheduler observerScheduler, @Named("Subscriber") Scheduler subscriberScheduler, UsersApi usersApi) {
        return new TestUseCase(observerScheduler, subscriberScheduler, usersApi);
    }

    @Provides
    @PerActivity
    static MainActivityPresenter providePresenter(MainActivityView view, TestUseCase testUseCase, Navigator navigator) {
        return new MainActivityPresenterImpl(view, testUseCase, navigator);
    }

    @Binds
    @PerActivity
    abstract Activity provideActivity(MainActivity featureActivity);

    @Binds
    @PerActivity
    abstract MainActivityView provideMainActivityView(MainActivity featureActivity);
}
