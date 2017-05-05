package com.abeade.android.architecture.testapp.domain.interactor;

import com.abeade.android.architecture.testapp.domain.model.UserViewItem;
import com.abeade.android.architecture.testapp.domain.model.converter.UserConverter;
import com.abeade.android.architecture.testapp.domain.repository.UsersRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UsersUseCase implements UseCase<UserViewItem, Integer> {

    private final UsersRepository usersRepository;

    @Inject
    public UsersUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Observable<UserViewItem> getObservable(Integer userId) {
        return usersRepository.getUser(userId)
                .map(userDtoBaseResponseDto -> UserConverter.convertUser(userDtoBaseResponseDto.getData()));
    }
}
