package com.improve10x.ecommerce;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.improve10x.ecommerce.cart.CartProduct;
import com.improve10x.ecommerce.category.Category;
import com.improve10x.ecommerce.modelclass.Product;
import com.improve10x.ecommerce.network.FakeStoreApi;
import com.improve10x.ecommerce.network.FakeStoreService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws IOException {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCategoryItems() throws IOException {
        FakeStoreService fakeStoreService = new FakeStoreApi().createFakeStoreService();
        Call<List<Category>> call = fakeStoreService.fetchCategoryItems();
        List<Category> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }

    @Test
    public void fetchProducts() throws IOException {
        FakeStoreService fakeStoreService = new FakeStoreApi().createFakeStoreService();
        Call<List<Product>> call = fakeStoreService.fetchProducts(1);
        List<Product> products = call.execute().body();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }

    @Test
    public void getProductDetails() throws IOException {
        FakeStoreService fakeStoreService = new FakeStoreApi().createFakeStoreService();
        Call<Product> call = fakeStoreService.getProductDetails(1);
        Product product = call.execute().body();
        assertNotNull(product);
        System.out.println(new Gson().toJson(product));
    }

    @Test

    public void getCart() throws IOException {
        FakeStoreService fakeApiService = new FakeStoreApi().createFakeStoreService();
        Call<CartProduct> call = fakeApiService.fetchCartProducts();
        CartProduct categories = call.execute().body();
        assertNotNull(categories);
        System.out.println(new Gson().toJson(categories));
    }
}