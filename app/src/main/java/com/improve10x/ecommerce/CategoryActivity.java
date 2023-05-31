package com.improve10x.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.improve10x.ecommerce.databinding.ActivityCategoryBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    private ActivityCategoryBinding binding;
    private ArrayList<String> categories = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private FakeStoreService fakeStoreService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setUpData();
        setUpCategoryRv();
        setUpAdapter();
        fetchCategoryItems();
    }

    private void setUpAdapter() {
        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setUpData(categories);
        binding.categoryRv.setAdapter(categoryAdapter);
    }

    private void setUpCategoryRv() {
        binding.categoryRv.setLayoutManager(new LinearLayoutManager(this));
    }

//    private void setUpData() {
//        categories = new ArrayList<>();
//        Category electronics = new Category();
//        electronics.title = "Electronics";
//        categories.add(electronics);
//
//        Category jewelery = new Category();
//        jewelery.title = "jewelery";
//        categories.add(jewelery);
//
//        Category mensClothing = new Category();
//        mensClothing.title = "Mens Clothing";
//        categories.add(mensClothing);
//
//        Category womensClothing = new Category();
//        womensClothing.title = "Women's Clothing";
//        categories.add(womensClothing);
//    }

    private void fetchCategoryItems() {
        FakeStoreApi fakeStoreApi = new FakeStoreApi();
        fakeStoreService = fakeStoreApi.createCategoryService();
        Call<List<String>> call = fakeStoreService.fetchCategoryItems();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> strings = response.body();
                categoryAdapter.setUpData(strings);

            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

    }
}