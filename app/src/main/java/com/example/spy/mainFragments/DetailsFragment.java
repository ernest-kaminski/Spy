package com.example.spy.mainFragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spy.R;
import com.example.spy.adapters.CategoriesAdapter;
import com.example.spy.appRunner;
import com.example.spy.models.CategoryModel;
import com.example.spy.models.SpyGameModel;

import java.util.ArrayList;

public class DetailsFragment extends Fragment implements CategoriesAdapter.OnItemClickInterface {

    private static final String TAG = "DetailsFragment";

    private CategoriesAdapter categoriesAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private SpyGameModel spyGameModel;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.details_fragment, container, false);

        ArrayList<CategoryModel> categories = new ArrayList<CategoryModel>();
        context = getActivity().getApplicationContext();
        spyGameModel = ((appRunner) context).getSpyGameModel();

        if(spyGameModel.getCategories().size() == 0){
            categories.add(new CategoryModel(0, "Geografia", false));
            categories.add(new CategoryModel(1, "Sklepy", false));
            categories.add(new CategoryModel(2, "Wakacje", false));
            categories.add(new CategoryModel(3, "Państwa", false));
            categories.add(new CategoryModel(4, "Kultura i sztuka", false));
            categories.add(new CategoryModel(5, "Sport", false));

            spyGameModel.setCategories(categories);
        }else{
            categories = spyGameModel.getCategories();
        }


        recyclerView = v.findViewById(R.id.rv_details);
        layoutManager = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(layoutManager);
        categoriesAdapter = new CategoriesAdapter(categories, this);
        recyclerView.setAdapter(categoriesAdapter);


        return v;
    }

    public void onItemClickInterface(CategoryModel categoryModel, boolean isChecked){
        if(isChecked){
           spyGameModel.getCategories().get(categoryModel.getCategoryID()).setChecked(true);
        }else{
            spyGameModel.getCategories().get(categoryModel.getCategoryID()).setChecked(false);
        }

    }
}