package com.improve10x.ecommerce.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.databinding.CartProductItemBinding;
import com.improve10x.ecommerce.databinding.CategotyItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductViewHolder> {

    private List<ProductDetails> cartProducts;

    void setCartProductData(List<ProductDetails> productDetails) {
        cartProducts = productDetails;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartProductItemBinding binding = CartProductItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CartProductViewHolder cartProductViewHolder = new CartProductViewHolder(binding);
        return cartProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductViewHolder holder, int position) {
        ProductDetails productDetails = cartProducts.get(position);
        holder.binding.quantityTxt.setText(String.valueOf(productDetails.getProductId()));
        holder.binding.idTxt.setText(String.valueOf(productDetails.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
