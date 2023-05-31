package com.improve10x.ecommerce.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.databinding.CategotyItemBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    public List<String> categories;

    public void setUpData(List<String> categoriesList) {
        categories = categoriesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategotyItemBinding binding = CategotyItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.binding.titleTxt.setText(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
