package com.improve10x.ecommerce.category;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.ecommerce.databinding.CategotyItemBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<String> categories;
    private OnItemActionListener onItemActionListener;

    public void setUpData(List<String> categoriesList) {
        categories = categoriesList;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
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
        String product = categories.get(position);
        holder.binding.titleTxt.setText(categories.get(position));
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClick(product);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
