package com.abeade.android.architecture.testapp.setup.di.module;

import com.abeade.android.architecture.testapp.data.network.WebserviceConstants;
import com.abeade.android.architecture.testapp.data.network.api.UsersApi;
import com.abeade.android.architecture.testapp.setup.data.webservice.MockUserApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    NetworkBehavior provideNetworkBehavior() {
        return NetworkBehavior.create();
    }

    @Provides
    @Singleton
    MockRetrofit provideMockRetrofit(Retrofit retrofit, NetworkBehavior behavior) {
        return new MockRetrofit.Builder(retrofit)
                .networkBehavior(behavior)
                .build();
    }

    @Provides
    @Singleton
    UsersApi getUsersService(MockRetrofit mockRetrofit) {
        final BehaviorDelegate<UsersApi> delegate = mockRetrofit.create(UsersApi.class);
        return new MockUserApi(delegate);
    }
}