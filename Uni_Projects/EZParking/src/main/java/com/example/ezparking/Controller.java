package com.example.ezparking;

import javafx.scene.Parent;

public abstract class Controller {
    protected MainSceneController parentController;

    public abstract void getParentScene(MainSceneController parent);
}
