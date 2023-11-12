package com.example.spy.models;

import java.util.ArrayList;

public class SpyGameModel {
    private int numberOfPlayers;
    private int numberOfSpies;
    private ArrayList<String> playersNames;

   public SpyGameModel(){

   }

   public SpyGameModel(int numberOfPlayers, int numberOfSpies){
       this.numberOfPlayers = numberOfPlayers;
       this.numberOfSpies = numberOfSpies;
       playersNames = new ArrayList<String>();
       for(int i =0; i<numberOfPlayers; i++){
           playersNames.add("");
       }
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

    public ArrayList<String> getPlayersNames() {
        return playersNames;
    }

    public void setPlayersNames(ArrayList<String> playersNames) {
        this.playersNames = playersNames;
    }
}


