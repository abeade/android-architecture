package com.abeade.android.architecture.testapp.domain.model.converter.mapper;

import com.abeade.android.architecture.testapp.data.network.model.response.UserDto;
import com.abeade.android.architecture.testapp.domain.model.UserViewItem;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserViewItem map(UserDto userDto);
    List<UserViewItem> mapUsers(List<UserDto> userDtos);
}
