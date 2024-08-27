package com.goldenpalace.teladelogin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.goldenpalace.teladelogin.databinding.FoodItemBinding;
import com.goldenpalace.teladelogin.model.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private final ArrayList<Food> foodList;
    private final Context context;

    public FoodAdapter(ArrayList<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodItemBinding ListItem;
         ListItem = FoodItemBinding.inflate(LayoutInflater.from(context),parent,false);
        return new FoodViewHolder(ListItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        holder.binding.imgFood.setBackgroundResource(foodList.get(position).getImgFood());
        holder.binding.txtFoodName.setText(foodList.get(position).getFoodName());
        holder.binding.txtFoodDescricao.setText(foodList.get(position).getFoodDescricao());
        holder.binding.txtPreco.setText(foodList.get(position).getPreco());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder{

        FoodItemBinding binding;

        public FoodViewHolder(FoodItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
