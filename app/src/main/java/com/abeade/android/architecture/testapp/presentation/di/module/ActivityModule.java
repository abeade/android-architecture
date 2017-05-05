package com.abeade.android.architecture.testapp.presentation.di.module;

import android.app.Activity;

import com.abeade.android.architecture.testapp.data.network.UsersRepositoryImpl;
import com.abeade.android.architecture.testapp.data.network.api.UsersApi;
import com.abeade.android.architecture.testapp.domain.repository.UsersRepository;
import com.abeade.android.architecture.testapp.presentation.di.PerActivity;
import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.navigation.NavigatorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ActivityModule {

    @Provides
    @PerActivity
    static Navigator provideNavigator(Activity activity) {
        return new NavigatorImpl(activity);
    }

    @Provides
    @PerActivity
    static UsersRepository provideUsersRepository(UsersApi api) {
        return new UsersRepositoryImpl(api);
    }
}
