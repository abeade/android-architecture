package com.abeade.android.architecture.testapp.presentation.di.module;

import com.abeade.android.architecture.testapp.data.webservice.RetrofitAdapter;
import com.abeade.android.architecture.testapp.data.webservice.WebserviceConstants;
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

/**
 * Application module refers to sub components and provides application level dependencies.
 */
@Module
public class NetworkModule {

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
    RetrofitAdapter provideRetrofitAdapter(Retrofit retrofit) {
        return new RetrofitAdapter(retrofit);
    }
}