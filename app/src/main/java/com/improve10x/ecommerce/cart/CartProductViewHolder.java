package com.improve10x.ecommerce.cart;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.databinding.CartProductItemBinding;

public class CartProductViewHolder extends RecyclerView.ViewHolder {

    CartProductItemBinding binding;

    public CartProductViewHolder(CartProductItemBinding cartProductItemBinding) {
        super(cartProductItemBinding.getRoot());
        binding = cartProductItemBinding;
    }
}
