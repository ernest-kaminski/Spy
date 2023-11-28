package com.example.spy.models;

public class CategoryModel {
    private int categoryID;
    private String categoryName;
    private boolean isChecked;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public CategoryModel(){}

    public CategoryModel(int categoryID, String categoryName, boolean isChecked){
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.isChecked = isChecked;
    }
}
