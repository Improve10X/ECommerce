package com.improve10x.ecommerce.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.ecommerce.R;
import com.improve10x.ecommerce.databinding.ActivityCartProductBinding;
import com.improve10x.ecommerce.network.FakeStoreApi;
import com.improve10x.ecommerce.network.FakeStoreService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartProductActivity extends AppCompatActivity {

    private ActivityCartProductBinding binding;

    private CartProductAdapter cartProductAdapter;

    private List<ProductDetails> cartProductsDetails = new ArrayList<>();

    private FakeStoreService fakeStoreService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fetchCartProducts();
        setUpAdapter();
        setUpCartProductRv();
    }

    private void setUpCartProductRv() {
        binding.productCartRv.setLayoutManager(new LinearLayoutManager(this));
        binding.productCartRv.setAdapter(cartProductAdapter);
    }

    private void setUpAdapter() {
        cartProductAdapter = new CartProductAdapter();
        cartProductAdapter.setCartProductData(cartProductsDetails);
    }

    private void fetchCartProducts () {
        FakeStoreApi fakeStoreApi = new FakeStoreApi();
        fakeStoreService = fakeStoreApi.createFakeStoreService();
        Call<CartProduct> call = fakeStoreService.fetchCartProducts();
        call.enqueue(new Callback<CartProduct>() {
            @Override
            public void onResponse(Call<CartProduct> call, Response<CartProduct> response) {
                CartProduct cartProduct = response.body();
                cartProductAdapter.setCartProductData(cartProduct.products);
                Toast.makeText(CartProductActivity.this, "Successfully Fetched the Items", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CartProduct> call, Throwable t) {
                Toast.makeText(CartProductActivity.this, "Failed to Load the Items", Toast.LENGTH_SHORT).show();

            }
        });
    }
}