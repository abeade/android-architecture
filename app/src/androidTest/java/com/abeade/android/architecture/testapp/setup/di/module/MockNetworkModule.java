package com.abeade.android.architecture.testapp.setup.di.module;

import com.abeade.android.architecture.testapp.data.webservice.WebserviceConstants;
import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;
import com.abeade.android.architecture.testapp.setup.data.webservice.MockUserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Logging OkHttp requests
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(WebserviceConstants.LOG_LEVEL);

        // Setting Connection Timeout
        httpClient.connectTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);

        //Sets Redirects
        httpClient.followRedirects(true);
        httpClient.followSslRedirects(true);

        httpClient.addInterceptor(logging);

        return httpClient.build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(WebserviceConstants.DATE_FORMAT)
                .create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
         return new Retrofit.Builder()
                .baseUrl(WebserviceConstants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    MockRetrofit provideMockRetrofit(Retrofit retrofit) {
        NetworkBehavior behavior = NetworkBehavior.create();

        return new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
    }

    @Provides
    @Singleton
    UsersApi getUsersService(MockRetrofit mockRetrofit) {
        final BehaviorDelegate<UsersApi> delegate = mockRetrofit.create(UsersApi.class);
        return new MockUserService(delegate);
    }
}