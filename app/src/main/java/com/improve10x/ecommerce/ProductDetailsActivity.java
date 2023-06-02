package com.improve10x.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.ecommerce.databinding.ActivityProductDetailsBinding;
import com.improve10x.ecommerce.modelclass.Product;
import com.improve10x.ecommerce.network.FakeStoreApi;
import com.improve10x.ecommerce.network.FakeStoreService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra("productId")) {
            productId = getIntent().getIntExtra("productId", 0);
        }
        fetchProductDetails();
    }

    private void fetchProductDetails() {
        FakeStoreApi fakeStoreApi = new FakeStoreApi();
        FakeStoreService fakeStoreService = fakeStoreApi.createCategoryService();
        Call<Product> call = fakeStoreService.getProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                Toast.makeText(ProductDetailsActivity.this, "Successfully fetched The Product Details", Toast.LENGTH_SHORT).show();
                Product product = response.body();
                binding.titleTxt.setText(product.getTitle());
                binding.priceTxt.setText(String.valueOf(product.price));
                binding.descriptionTxt.setText(product.description);
                binding.detailsRatingbarRv.setRating(product.rating.getRate());
                Picasso.get().load(product.imageUrl).into(binding.imageViewImg);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "Failed to Get the Product Details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}