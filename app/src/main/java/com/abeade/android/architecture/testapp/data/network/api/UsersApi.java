package com.abeade.android.architecture.testapp.data.network.api;


import com.abeade.android.architecture.testapp.data.network.WebserviceConstants;
import com.abeade.android.architecture.testapp.data.network.model.response.BaseResponseDto;
import com.abeade.android.architecture.testapp.data.network.model.response.UserDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Retrofit2 interface to handle Oauth API requests.
 */
public interface UsersApi {

    @GET(WebserviceConstants.Users.PATH_GET_USERS)
    Observable<BaseResponseDto<List<UserDto>>> getUsers(@Query(WebserviceConstants.Parameters.PAGE) int page, @Query(WebserviceConstants.Parameters.LIMIT) int limit);

    @GET(WebserviceConstants.Users.PATH_GET_USER)
    Observable<BaseResponseDto<UserDto>> getUser(@Path(WebserviceConstants.Parameters.USER_ID) int userId);
}
