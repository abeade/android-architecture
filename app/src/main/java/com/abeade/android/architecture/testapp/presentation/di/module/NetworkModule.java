package com.abeade.android.architecture.testapp.presentation.di.module;

import com.abeade.android.architecture.testapp.data.webservice.WebserviceConstants;
import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;
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

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Logging level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(WebserviceConstants.LOG_LEVEL);
        httpClient.addInterceptor(logging);

        // Setting Connection Timeout
        httpClient.connectTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);

        // Redirects
        httpClient.followRedirects(true);
        httpClient.followSslRedirects(true);

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    UsersApi getUsersService(Retrofit retrofit) {
        return retrofit.create(UsersApi.class);
    }
}