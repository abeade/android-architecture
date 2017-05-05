package com.abeade.android.architecture.testapp.domain.repository;

import com.abeade.android.architecture.testapp.data.network.model.response.BaseResponseDto;
import com.abeade.android.architecture.testapp.data.network.model.response.UserDto;

import java.util.List;

import io.reactivex.Observable;

public interface UsersRepository {

    Observable<BaseResponseDto<List<UserDto>>> getUsers(int page, int limit);
    Observable<BaseResponseDto<UserDto>> getUser(int userId);
}
