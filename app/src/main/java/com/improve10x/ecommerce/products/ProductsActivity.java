package com.improve10x.ecommerce.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.ecommerce.BaseActivity;
import com.improve10x.ecommerce.ProductDetailsActivity;
import com.improve10x.ecommerce.category.Constants;
import com.improve10x.ecommerce.databinding.ActivityProducts2Binding;
import com.improve10x.ecommerce.modelclass.Product;
import com.improve10x.ecommerce.network.FakeStoreApi;
import com.improve10x.ecommerce.network.FakeStoreService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private List<Product> products = new ArrayList<>();
    private ActivityProducts2Binding binding;
    private ProductsAdapter productsAdapter;
    private String categoryName;

    private FakeStoreService fakeStoreService;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProducts2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle(categoryName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getIntent().hasExtra(Constants.KEY_CATEGORY_VALUE)) {
            categoryName = getIntent().getStringExtra(Constants.KEY_CATEGORY_VALUE);
        }
        fetchData();
        setUpAdapter();
        setUpProductsRv();
    }

    private void hideProgressBar() {
        binding.progressbarPb.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.progressbarPb.setVisibility(View.VISIBLE);
    }

    private void fetchData() {
        showProgressBar();
        FakeStoreApi fakeStoreApi = new FakeStoreApi();
        fakeStoreService = fakeStoreApi.createFakeStoreService();
        Call<List<Product>> call = fakeStoreService.fetchProducts(categoryName);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                hideProgressBar();
                List<Product> products = response.body();
                productsAdapter.setUpData(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to Load the fetch Products");
            }
        });
    }

    private void setUpAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setUpData(products);
        binding.productsRv.setAdapter(productsAdapter);
        productsAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(int productId) {
                Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
                intent.putExtra(Constants.KEY_PRODUCT_VALUE, productId);
                startActivity(intent);
            }
        });
    }

    private void setUpProductsRv() {
        binding.productsRv.setLayoutManager(new GridLayoutManager(this, 2));
    }
}