package com.cartoaware.mvvm.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cartoaware.mvvm.data.Hit;
import com.cartoaware.mvvmdemo.databinding.ViewPixabayItemBinding;

import java.util.List;

public class PixabayPhotosAdapter extends RecyclerView.Adapter<PixabayPhotosAdapter.PixabayPhotosViewHolder> {

    private List<Hit> hitsList;

    public PixabayPhotosAdapter(List<Hit> hitsList) {
        this.hitsList = hitsList;
    }

    @NonNull
    @Override
    public PixabayPhotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewPixabayItemBinding itemBinding = ViewPixabayItemBinding.inflate(layoutInflater, parent, false);
        return new PixabayPhotosViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PixabayPhotosViewHolder holder, int position) {
        final Hit photo = hitsList.get(position);
        holder.bindHit(photo);
    }

    @Override
    public int getItemCount() {
        return hitsList != null ? hitsList.size() : 0;
    }

    class PixabayPhotosViewHolder extends RecyclerView.ViewHolder {
        private ViewPixabayItemBinding pixabayItemBinding;

        public PixabayPhotosViewHolder(ViewPixabayItemBinding binding) {
            super(binding.getRoot());
            this.pixabayItemBinding = binding;
        }

        public void bindHit(Hit hit) {
            pixabayItemBinding.setHit(hit);
            pixabayItemBinding.executePendingBindings();
        }
    }
}
