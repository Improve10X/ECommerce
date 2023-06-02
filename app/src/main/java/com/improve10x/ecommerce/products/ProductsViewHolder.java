package com.improve10x.ecommerce.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.databinding.CategotyItemBinding;
import com.improve10x.ecommerce.databinding.ProductsItemXmlBinding;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    ProductsItemXmlBinding binding;

    public ProductsViewHolder(ProductsItemXmlBinding productsItemXmlBinding) {
        super(productsItemXmlBinding.getRoot());
        binding = productsItemXmlBinding;
    }
}
