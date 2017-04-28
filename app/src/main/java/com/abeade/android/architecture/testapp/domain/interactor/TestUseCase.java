package com.abeade.android.architecture.testapp.domain.interactor;

import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class TestUseCase extends BaseUseCase<String, Void> {

    private final UsersApi usersApi;

    @Inject
    public TestUseCase(Scheduler observerScheduler, Scheduler subscriberScheduler, UsersApi usersApi) {
        super(observerScheduler, subscriberScheduler);
        this.usersApi = usersApi;
    }

    @Override
    Observable<String> getObservable(Void aVoid) {
        return usersApi.getUser(0)
                .map(userDtoBaseResponseDto -> userDtoBaseResponseDto.getData().getName());
//        return Observable.defer(() -> {
//            Thread.sleep(5000);
//            return Observable.just("Hello world");
//        });
    }
}
