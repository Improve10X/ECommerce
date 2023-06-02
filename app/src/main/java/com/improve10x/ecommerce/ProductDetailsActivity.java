package com.improve10x.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.ecommerce.category.Constants;
import com.improve10x.ecommerce.databinding.ActivityProductDetailsBinding;
import com.improve10x.ecommerce.modelclass.Product;
import com.improve10x.ecommerce.network.FakeStoreApi;
import com.improve10x.ecommerce.network.FakeStoreService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
    private ActivityProductDetailsBinding binding;
    private int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra(Constants.PRODUCT_KEY_VALUE)) {
            productId = getIntent().getIntExtra(Constants.PRODUCT_KEY_VALUE, 0);
        }
        fetchProductDetails();
    }

    private void fetchProductDetails() {
        FakeStoreApi fakeStoreApi = new FakeStoreApi();
        FakeStoreService fakeStoreService = fakeStoreApi.createFakeStoreService();
        Call<Product> call = fakeStoreService.getProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Product product = response.body();
                binding.titleTxt.setText(product.getTitle());
                binding.priceTxt.setText(String.valueOf(product.getPrice()));
                binding.descriptionTxt.setText(product.getDescription());
                binding.detailsRatingbarRv.setRating( product.rating.getRate());
                binding.countTxt.setText(product.rating.getCount());
                Picasso.get().load(product.getImageUrl()).into(binding.imageViewImg);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "Failed to Get the Product Details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}