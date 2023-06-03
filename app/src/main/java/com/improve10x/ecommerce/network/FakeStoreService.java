package com.improve10x.ecommerce.network;

import com.improve10x.ecommerce.cart.CartProduct;
import com.improve10x.ecommerce.category.Category;
import com.improve10x.ecommerce.category.Constants;
import com.improve10x.ecommerce.modelclass.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreService {

    @GET("api/v1/categories")
    Call<List<Category>> fetchCategoryItems();

    @GET("/products/category/{categoryName}")
    Call<List<Product>> fetchProducts(@Path("categoryName") String categoryName);

    @GET("/products/{productId}")
    Call<Product> getProductDetails(@Path("productId") int productId);

    @GET("carts/1?userId=1")
    Call<CartProduct> fetchCartProducts();
}
