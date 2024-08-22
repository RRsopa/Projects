package com.example.ezparking;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ParkingSpotsController extends Controller{

    @FXML
    private TableColumn<?, ?> Location;

    @FXML
    private TableColumn<?, ?> Park;

    @FXML
    private TableColumn<?, ?> atCapacity;

    @FXML
    private TableView<?> parksTableView;

    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
    }
}
