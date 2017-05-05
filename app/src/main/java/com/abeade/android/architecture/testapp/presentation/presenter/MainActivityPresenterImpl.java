package com.abeade.android.architecture.testapp.presentation.presenter;

import android.support.annotation.StringRes;

import com.abeade.android.architecture.testapp.R;
import com.abeade.android.architecture.testapp.domain.interactor.UseCaseExecutor;
import com.abeade.android.architecture.testapp.domain.model.UserViewItem;
import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private final MainActivityView view;
    private final Navigator navigator;
    private final UseCaseExecutor<UserViewItem, Integer> useCaseExecutor;

    @Inject
    public MainActivityPresenterImpl(MainActivityView view, UseCaseExecutor<UserViewItem, Integer> useCaseExecutor, Navigator navigator) {
        this.view = view;
        this.useCaseExecutor = useCaseExecutor;
        this.navigator = navigator;
    }

    @Override
    public void loadData() {
        showText(R.string.loading);
        useCaseExecutor.execute(new DisposableObserver<UserViewItem>() {
            @Override
            public void onNext(@NonNull UserViewItem s) {
                showText(s.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                showText(R.string.error);
            }

            @Override
            public void onComplete() {

            }
        }, 0);
    }

    @Override
    public void showText(String string) {
        view.setText(string);
    }

    @Override
    public void showText(@StringRes int stringId) {
        view.setText(stringId);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        useCaseExecutor.dispose();
    }
}
