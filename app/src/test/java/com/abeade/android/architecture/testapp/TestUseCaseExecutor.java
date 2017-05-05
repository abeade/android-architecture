package com.abeade.android.architecture.testapp;

import com.abeade.android.architecture.testapp.domain.interactor.UseCase;
import com.abeade.android.architecture.testapp.domain.interactor.UseCaseExecutor;

import io.reactivex.schedulers.Schedulers;

public class TestUseCaseExecutor<T, Params> extends UseCaseExecutor<T, Params> {
    public TestUseCaseExecutor(UseCase<T, Params> useCase) {
        super(Schedulers.trampoline(), Schedulers.trampoline(), useCase);
    }
}
