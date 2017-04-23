package com.abeade.android.architecture.testapp.presentation.navigation;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

public class NavigatorImpl implements Navigator {
    protected WeakReference<Activity> activity;
    protected WeakReference<Fragment> fragment;

    public NavigatorImpl(Activity activity) {
        this.activity = new WeakReference<>(activity);
    }

    public NavigatorImpl(Fragment fragment) {
        this(fragment.getActivity());
        this.fragment = new WeakReference<>(fragment);
    }

    @Override
    public void closeView() {
        activity.get().finish();
    }
}
