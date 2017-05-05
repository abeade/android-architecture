package com.abeade.android.architecture.testapp.data.network;

import com.abeade.android.architecture.testapp.data.network.api.UsersApi;
import com.abeade.android.architecture.testapp.data.network.model.response.BaseResponseDto;
import com.abeade.android.architecture.testapp.data.network.model.response.UserDto;
import com.abeade.android.architecture.testapp.domain.repository.UsersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UsersRepositoryImpl implements UsersRepository {

    private UsersApi usersApi;

    @Inject
    public UsersRepositoryImpl(UsersApi usersApi) {
        this.usersApi = usersApi;
    }

    @Override
    public Observable<BaseResponseDto<List<UserDto>>> getUsers(int page, int limit) {
        return usersApi.getUsers(page, limit);
    }

    @Override
    public Observable<BaseResponseDto<UserDto>> getUser(int userId) {
        return usersApi.getUser(userId);
    }
}
