package com.abeade.android.architecture.testapp.presentation.presenter;

import com.abeade.android.architecture.testapp.domain.interactor.TestUseCase;
import com.abeade.android.architecture.testapp.presentation.navigation.Navigator;
import com.abeade.android.architecture.testapp.presentation.view.MainActivityView;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private final MainActivityView view;
    private final Navigator navigator;
    private final TestUseCase testUseCase;

    @Inject
    public MainActivityPresenterImpl(MainActivityView view, TestUseCase testUseCase, Navigator navigator) {
        this.view = view;
        this.testUseCase = testUseCase;
        this.navigator = navigator;
    }

    @Override
    public void loadData() {
        testUseCase.execute(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                showText(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, null);
    }

    @Override
    public void showText(String text) {
        view.setText(text);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        testUseCase.dispose();
    }
}
