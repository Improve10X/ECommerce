package com.improve10x.ecommerce.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.category.CategoryViewHolder;
import com.improve10x.ecommerce.products.OnItemActionListener;
import com.improve10x.ecommerce.databinding.ProductsItemXmlBinding;
import com.improve10x.ecommerce.modelclass.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    public List<Product> products;
    public OnItemActionListener onItemActionListener;

    public void setUpData(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override

    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductsItemXmlBinding binding = ProductsItemXmlBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductsViewHolder productsViewHolder = new ProductsViewHolder(binding);
        return productsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Product product = products.get(position);
        Picasso.get().load(product.imageUrl).into(holder.binding.imageViewImg);
        holder.binding.titleTxt.setText(product.getTitle());
        holder.binding.countTxt.setText(String.valueOf(product.rating.count));
        holder.binding.priceTxt.setText(String.valueOf(product.price));
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClicked(product.getId());

        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
