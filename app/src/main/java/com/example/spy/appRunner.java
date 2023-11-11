package com.example.spy;

import android.app.Application;

import com.example.spy.models.SpyGameModel;

public class appRunner extends Application {
    private SpyGameModel spyGameModel = new SpyGameModel();

    public SpyGameModel getSpyGameModel() {
        return spyGameModel;
    }

    public void setSpyGameModel(SpyGameModel spyGameModel) {
        this.spyGameModel = spyGameModel;
    }
}
