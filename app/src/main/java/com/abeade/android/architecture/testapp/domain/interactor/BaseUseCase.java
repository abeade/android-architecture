package com.abeade.android.architecture.testapp.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public abstract class BaseUseCase<T, Params> {
    private final CompositeDisposable disposables;
    private final Scheduler observerScheduler;
    private final Scheduler subscriberScheduler;

    BaseUseCase(Scheduler observerScheduler, Scheduler subscriberScheduler) {
        this.observerScheduler = observerScheduler;
        this.subscriberScheduler = subscriberScheduler;
        this.disposables = new CompositeDisposable();
    }

    abstract Observable<T> getObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.getObservable(params)
                .subscribeOn(subscriberScheduler)
                .observeOn(observerScheduler);
        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
