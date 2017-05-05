package com.abeade.android.architecture.testapp.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class UseCaseExecutor<T, Params> implements Disposable {
    private final CompositeDisposable disposables;
    private final Scheduler observerScheduler;
    private final Scheduler subscriberScheduler;
    private final UseCase<T, Params> useCase;

    public UseCaseExecutor(Scheduler observerScheduler, Scheduler subscriberScheduler, UseCase<T, Params> useCase) {
        this.observerScheduler = observerScheduler;
        this.subscriberScheduler = subscriberScheduler;
        this.useCase = useCase;
        this.disposables = new CompositeDisposable();
    }

    public Observable<T> getObservable(Params params) {
        return useCase.getObservable(params);
    }

    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.getObservable(params)
                .subscribeOn(subscriberScheduler)
                .observeOn(observerScheduler);
        addDisposable(observable.subscribeWith(observer));
    }

    @Override
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    @Override
    public boolean isDisposed() {
        return disposables.isDisposed();
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}