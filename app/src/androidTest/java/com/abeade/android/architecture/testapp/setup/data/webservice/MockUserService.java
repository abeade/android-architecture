package com.abeade.android.architecture.testapp.setup.data.webservice;

import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;
import com.abeade.android.architecture.testapp.data.webservice.model.response.BaseResponseDto;
import com.abeade.android.architecture.testapp.data.webservice.model.response.UserDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.mock.BehaviorDelegate;

public class MockUserService implements UsersApi {
    private static final int ITEMS = 10;
    private final BehaviorDelegate<UsersApi> delegate;
    private final List<UserDto> users;

    public MockUserService(BehaviorDelegate<UsersApi> delegate) {
        this.delegate = delegate;
        this.users = new ArrayList<>(ITEMS);
        for (int i = 0; i < ITEMS; i++) {
            this.users.add(new UserDto(i, "Name" + i, i + "email@test.com", "Address" + i, "Bio" + i, "Image" + i));
        }
    }

    public Observable<BaseResponseDto<List<UserDto>>> getUsers(int page, int limit) {
        BaseResponseDto<List<UserDto>> responseDto = new BaseResponseDto<>();
        responseDto.setData(users);
        return delegate.returningResponse(responseDto).getUsers(page, limit);
    }

    public Observable<BaseResponseDto<UserDto>> getUser(int userId) {
        BaseResponseDto<UserDto> responseDto = new BaseResponseDto<>();
        responseDto.setData(users.get(0));
        return delegate.returningResponse(responseDto).getUser(userId);
    }
}