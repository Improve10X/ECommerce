package com.improve10x.ecommerce;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

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
        FakeStoreService fakeStoreService = new FakeStoreApi().createCategoryService();
        Call<List<String>> call = fakeStoreService.fetchCategoryItems();
        List<String> categories = call.execute().body();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
        System.out.println(new Gson().toJson(categories));
    }
}