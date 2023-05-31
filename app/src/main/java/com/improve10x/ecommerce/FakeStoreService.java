package com.improve10x.ecommerce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreService {

    @GET(Constants.CATEGORY_END_POINT)
    Call<List<String>> fetchCategoryItems();
}
