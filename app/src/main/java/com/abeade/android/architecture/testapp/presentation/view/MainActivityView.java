package com.abeade.android.architecture.testapp.presentation.view;

import android.support.annotation.StringRes;

public interface MainActivityView {
    void setText(@StringRes int stringId);
    void setText(String string);
}
