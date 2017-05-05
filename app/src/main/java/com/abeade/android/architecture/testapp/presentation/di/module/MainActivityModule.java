package com.abeade.android.architecture.testapp.presentation.di.module;

import android.app.Activity;

import com.abeade.android.architecture.testapp.domain.interactor.UseCaseExecutor;
import com.abeade.android.architecture.testapp.domain.interactor.UsersUseCase;
import com.abeade.android.architecture.testapp.domain.model.UserViewItem;
import com.abeade.android.architecture.testapp.domain.repository.UsersRepository;
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
    static UsersUseCase provideTestUseCase(UsersRepository usersRepository) {
        return new UsersUseCase(usersRepository);
    }

    @Provides
    @PerActivity
    static UseCaseExecutor<UserViewItem, Integer> useCaseExecutor(@Named("Observer") Scheduler observerScheduler, @Named("Subscriber") Scheduler subscriberScheduler, UsersUseCase testUseCase) {
        return new UseCaseExecutor<>(observerScheduler, subscriberScheduler, testUseCase);
    }

    @Provides
    @PerActivity
    static MainActivityPresenter providePresenter(MainActivityView view, UseCaseExecutor<UserViewItem, Integer>  useCaseExecutor, Navigator navigator) {
        return new MainActivityPresenterImpl(view, useCaseExecutor, navigator);
    }

    @Binds
    @PerActivity
    abstract Activity provideActivity(MainActivity featureActivity);

    @Binds
    @PerActivity
    abstract MainActivityView provideMainActivityView(MainActivity featureActivity);
}
