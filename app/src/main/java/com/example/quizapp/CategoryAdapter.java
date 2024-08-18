package com.example.quizapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewholde> {
    Context context;
    ArrayList<CategoryModel> categoryModels;
    public CategoryAdapter(Context context,ArrayList<CategoryModel> categoryModels){
        this.context= context;
        this.categoryModels= categoryModels;
    }
    @NonNull
    @Override
    public CategoryViewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.item_category,null);
        return new CategoryViewholde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewholde holder, int position) {
    CategoryModel model = categoryModels.get(position);
    holder.textView.setText(model.getCategoryName());
        Glide.with(context)
                .load(model.getCategoryImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public  class CategoryViewholde extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public CategoryViewholde(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.category);

        }
    }
}
