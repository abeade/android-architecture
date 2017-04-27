package com.abeade.android.architecture.testapp.data.webservice;

import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to handle all Backend connections using Retrofit 2 library.
 */
public class RetrofitAdapter {

    // APIs
    private UsersApi usersApi;

    /**
     * Constructor to create Retrofit 2 adapter
     */
    @Inject
    public RetrofitAdapter() {
        Gson gson = new GsonBuilder()
                .setDateFormat(WebserviceConstants.DATE_FORMAT)
                .create();

        Retrofit retrofitZenith = new Retrofit.Builder()
                .baseUrl(WebserviceConstants.BASE_URL)
                .client(this.setOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Create API instances
        usersApi = retrofitZenith.create(UsersApi.class);
    }

    /**
     * Configuration of OkHttpClient
     *
     * @return instance of OkHttpClient
     */
    private OkHttpClient setOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Logging Okhhtp requests
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

    /**
     * Configuration of OkHttpClient
     *
     * @return instance of OkHttpClient
     */
    private OkHttpClient setOkHttpClientWhackamole() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        // Logging Okhhtp requests
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(WebserviceConstants.LOG_LEVEL);

        // Setting Connection Timeout
        httpClient.connectTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.writeTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(WebserviceConstants.TIME_OUT_MILLIS, TimeUnit.MILLISECONDS);

        httpClient.addInterceptor(logging);

        return httpClient.build();
    }

    /**
     * Returns the Users API instance
     *
     * @return OauthApi
     */
    public UsersApi getUsersService() {
        return usersApi;
    }
}