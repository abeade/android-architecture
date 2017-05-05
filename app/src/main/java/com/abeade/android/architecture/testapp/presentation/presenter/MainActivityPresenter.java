package com.abeade.android.architecture.testapp.presentation.presenter;

import android.support.annotation.StringRes;

public interface MainActivityPresenter extends Presenter {
    void showText(@StringRes int stringId);
    void showText(String string);
    void loadData();
}
