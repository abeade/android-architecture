package com.abeade.android.architecture.testapp.data.network;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Constants for Webservice connections.
 */
public class WebserviceConstants {

    // Log Level Retrofit
    public static final HttpLoggingInterceptor.Level LOG_LEVEL = HttpLoggingInterceptor.Level.BODY;

    // Base url
    public static final String BASE_URL = "https://abeade-server.herokuapp.com";

    // Web services date format
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    // Connection Configuration
    public static final int TIME_OUT_MILLIS = 5000;

    // Parameters
    public static class Parameters {
        public static final String PAGE = "page";
        public static final String LIMIT = "limit";
        public static final String USER_ID = "user_id";
    }

    // Users API
    public static class Users {
        public static final String VERSION = "/v1";

        public static final String PATH_GET_USERS = VERSION + "/users";
        public static final String PATH_GET_USER = VERSION + "/users/{" + Parameters.USER_ID + "}";
    }
}