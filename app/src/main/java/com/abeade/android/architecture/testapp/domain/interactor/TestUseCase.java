package com.abeade.android.architecture.testapp.domain.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class TestUseCase extends BaseUseCase<String, Void> {

    @Inject
    public TestUseCase(Scheduler observerScheduler, Scheduler subscriberScheduler) {
        super(observerScheduler, subscriberScheduler);
    }

    @Override
    Observable<String> getObservable(Void aVoid) {
        return Observable.defer(() -> {
            Thread.sleep(5000);
            return Observable.just("Hello world");
        });
    }
}
