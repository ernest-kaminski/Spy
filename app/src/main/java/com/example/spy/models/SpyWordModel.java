package com.example.spy.models;

public class SpyWordModel {
    private int categoryID;
    private String word;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public SpyWordModel(){}

    public SpyWordModel(String word, int categoryID){
        this.word = word;
        this.categoryID = categoryID;
    }
}
