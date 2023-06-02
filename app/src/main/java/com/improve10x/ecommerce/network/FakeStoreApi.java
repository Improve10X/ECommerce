package com.improve10x.ecommerce.network;

import com.improve10x.ecommerce.category.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeStoreApi {

    public FakeStoreService createFakeStoreService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FakeStoreService fakeStoreService = retrofit.create(FakeStoreService.class);
        return fakeStoreService;
    }
}
