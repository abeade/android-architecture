package com.abeade.android.architecture.testapp.presentation.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.abeade.android.architecture.testapp.presentation.application.TestApplication;
import com.abeade.android.architecture.testapp.presentation.di.component.ApplicationComponent;
import com.abeade.android.architecture.testapp.presentation.di.module.ActivityModule;

public abstract class BaseActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.getApplicationComponent().inject(this);
  }

  protected ApplicationComponent getApplicationComponent() {
      return ((TestApplication) getApplication()).getApplicationComponent();
  }

  protected ActivityModule getActivityModule() {
      return new ActivityModule(this);
  }
}
