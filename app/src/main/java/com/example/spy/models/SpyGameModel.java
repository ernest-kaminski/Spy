package com.example.spy.models;

import java.util.ArrayList;

public class SpyGameModel {
    private int numberOfPlayers;
    private int numberOfSpies;
    private int timeInMinutes;
    private ArrayList<String> playersNames;
    private ArrayList<SpyWordModel> wordsWhichCanBeChosen;
    private ArrayList<CategoryModel> categoriesIDs;

   public SpyGameModel(){

   }

   public SpyGameModel(int numberOfPlayers, int numberOfSpies, int timeInMinutes){
       this.numberOfPlayers = numberOfPlayers;
       this.numberOfSpies = numberOfSpies;
       this.timeInMinutes = timeInMinutes;
       playersNames = new ArrayList<String>();
       for(int i =0; i<numberOfPlayers; i++){
           playersNames.add("");
       }

       wordsWhichCanBeChosen = new ArrayList<SpyWordModel>();
       categoriesIDs = new ArrayList<CategoryModel>();


       //TO DO: przeniesienie danych do pliku JSON lub do chmury
       categoriesIDs.add(new CategoryModel(0, "Geografia", false));
       categoriesIDs.add(new CategoryModel(1, "Sklepy", false));
       categoriesIDs.add(new CategoryModel(2, "Wakacje", false));
       categoriesIDs.add(new CategoryModel(3, "Państwa", false));
       categoriesIDs.add(new CategoryModel(4, "Kultura i sztuka", false));
       categoriesIDs.add(new CategoryModel(5, "Sport", false));
   }

   public void setNumberOfPlayers(int numberOfPlayers){
       this.numberOfPlayers = numberOfPlayers;
   }

   public int getNumberOfPlayers(){
       return numberOfPlayers;
   }

    public int getNumberOfSpies() {
        return numberOfSpies;
    }

    public void setNumberOfSpies(int numberOfSpies) {
        this.numberOfSpies = numberOfSpies;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(int timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public ArrayList<String> getPlayersNames() {
        return playersNames;
    }

    public void setPlayersNames(ArrayList<String> playersNames) {
        this.playersNames = playersNames;
    }

    public ArrayList<SpyWordModel> getWordsWhichCanBeChosen() {
        return wordsWhichCanBeChosen;
    }

    public void setWordsWhichCanBeChosen(ArrayList<SpyWordModel> wordsWhichCanBeChosen) {
        this.wordsWhichCanBeChosen = wordsWhichCanBeChosen;
    }

    public ArrayList<CategoryModel> getCategories() {
        return categoriesIDs;
    }

    public void setCategories(ArrayList<CategoryModel> chosenCategories) {
        this.categoriesIDs = chosenCategories;
    }
}


