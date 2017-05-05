package com.abeade.android.architecture.testapp.domain.interactor;

import io.reactivex.Observable;

public interface UseCase<T, Params> {
    Observable<T> getObservable(Params params);
}
