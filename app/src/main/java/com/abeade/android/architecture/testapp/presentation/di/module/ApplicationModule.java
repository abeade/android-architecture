package com.abeade.android.architecture.testapp.presentation.di.module;

import android.content.Context;

import com.abeade.android.architecture.testapp.presentation.application.TestApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@Module
public class ApplicationModule {
  private final TestApplication application;

  public ApplicationModule(TestApplication application) {
      this.application = application;
  }

  @Provides
  @Singleton
  Context provideApplicationContext() {
      return application;
  }

  @Provides
  @Named("Observer")
  @Singleton
  Scheduler provideObserverScheduler() {
      return AndroidSchedulers.mainThread();
  }

  @Provides
  @Named("Subscriber")
  @Singleton
  Scheduler providSubscriberScheduler() {
      return Schedulers.io();
  }


}
