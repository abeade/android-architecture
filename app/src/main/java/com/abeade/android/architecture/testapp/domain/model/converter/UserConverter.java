package com.abeade.android.architecture.testapp.domain.model.converter;

import com.abeade.android.architecture.testapp.data.network.model.response.UserDto;
import com.abeade.android.architecture.testapp.domain.model.UserViewItem;
import com.abeade.android.architecture.testapp.domain.model.converter.mapper.UserMapper;

import java.util.List;

public class UserConverter {
    public static List<UserViewItem> convertUsers(List<UserDto> userDtos) {
        return UserMapper.INSTANCE.mapUsers(userDtos);
    }

    public static UserViewItem convertUser(UserDto userDto) {
        return UserMapper.INSTANCE.map(userDto);
    }
}
