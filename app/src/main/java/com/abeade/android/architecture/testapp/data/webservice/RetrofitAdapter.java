package com.abeade.android.architecture.testapp.data.webservice;

import com.abeade.android.architecture.testapp.data.webservice.api.UsersApi;

import javax.inject.Inject;

import retrofit2.Retrofit;

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
    public RetrofitAdapter(Retrofit retrofit) {
        // Create API instances
        usersApi = retrofit.create(UsersApi.class);
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