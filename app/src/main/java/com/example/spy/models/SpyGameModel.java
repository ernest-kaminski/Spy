package com.example.spy.models;

public class SpyGameModel {
    private int numberOfPlayers;
    private int numberOfSpies;

   public SpyGameModel(){

   }

   public SpyGameModel(int numberOfPlayers, int numberOfSpies){
       this.numberOfPlayers = numberOfPlayers;
       this.numberOfSpies = numberOfSpies;
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
}


