package com.improve10x.ecommerce;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.databinding.CategotyItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    CategotyItemBinding binding;

    public CategoryViewHolder(CategotyItemBinding categotyItemBinding) {
        super(categotyItemBinding.getRoot());
        binding = categotyItemBinding;
    }
}
