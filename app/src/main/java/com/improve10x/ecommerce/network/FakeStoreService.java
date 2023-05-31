package com.improve10x.ecommerce.network;

import com.improve10x.ecommerce.category.Constants;
import com.improve10x.ecommerce.modelclass.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreService {

    @GET(Constants.CATEGORY_END_POINT)
    Call<List<String>> fetchCategoryItems();

    @GET("/products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);
}
