package com.example.spy.adapters;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spy.R;
import com.example.spy.models.CategoryModel;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ImageViewHolder> {

    private ArrayList<CategoryModel> categories;
    private OnItemClickInterface itemListener;

    public CategoriesAdapter(ArrayList<CategoryModel>categories, OnItemClickInterface itemListener) {
        this.categories = categories;
        this.itemListener = itemListener;
        //if(getItemCount() != 0){
        //    categories.clear();
        //}
    }

    @NonNull
    @Override
    public CategoriesAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.cardview_details_item, parent, false);

        return new CategoriesAdapter.ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ImageViewHolder holder, int position) {
        CategoryModel category = categories.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        TextView cardviewTextView;
        MaterialCardView materialCardViewDetails;
        boolean isChecked = false;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            materialCardViewDetails = (MaterialCardView) itemView.findViewById(R.id.material_card_view_details);
            cardviewTextView = (TextView) itemView.findViewById(R.id.cardview_item_textview);

        }

        public void bind(CategoryModel categoryModel){
            cardviewTextView.setText(categoryModel.getCategoryName());

            if(categoryModel.isChecked()){
                materialCardViewDetails.setStrokeColor(materialCardViewDetails.getResources().getColor(R.color.green));
                materialCardViewDetails.setBackground(materialCardViewDetails.getResources().getDrawable(R.color.lightGreen));

            }else{
                materialCardViewDetails.setStrokeColor(materialCardViewDetails.getResources().getColor(R.color.blue));
                materialCardViewDetails.setBackground(materialCardViewDetails.getResources().getDrawable(R.color.white));
            }
            materialCardViewDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(categoryModel.isChecked()){
                        materialCardViewDetails.setStrokeColor(materialCardViewDetails.getResources().getColor(R.color.blue));
                        materialCardViewDetails.setBackground(materialCardViewDetails.getResources().getDrawable(R.color.white));
                        itemListener.onItemClickInterface(categoryModel, false);
                        categoryModel.setChecked(false);
                    }else{
                        materialCardViewDetails.setStrokeColor(materialCardViewDetails.getResources().getColor(R.color.green));
                        materialCardViewDetails.setBackground(materialCardViewDetails.getResources().getDrawable(R.color.lightGreen));
                        itemListener.onItemClickInterface(categoryModel, true);
                        categoryModel.setChecked(true);
                    }
                }
            });
        }

    }

    public interface OnItemClickInterface{
        public void onItemClickInterface(CategoryModel categoryModel, boolean isChecked);
    }

}
