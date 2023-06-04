package com.improve10x.ecommerce.network;

import com.improve10x.ecommerce.cart.CartProduct;
import com.improve10x.ecommerce.category.Category;
import com.improve10x.ecommerce.category.Constants;
import com.improve10x.ecommerce.modelclass.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeStoreService {

    @GET("api/v1/categories")
    Call<List<Category>> fetchCategoryItems();

    @GET("api/v1/products/")
    Call<List<Product>> fetchProducts(@Query("categoryId") Integer categoryId);

    @GET("api/v1/products/4")
    Call<Product> getProductDetails(@Path("productsId") Integer productsId);

    @GET("carts/1?userId=1")
    Call<CartProduct> fetchCartProducts();
}
