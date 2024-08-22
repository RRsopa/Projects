package com.example.ezparking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class PlatesController extends Controller {

    @FXML
    private Button addPlateBtn;

    @FXML
    private TextField addPlateField;

    @FXML
    private Button editPlateBtn;

    @FXML
    private ListView<String> platesList;

    @FXML
    private Button removePlateBtn;

    @FXML
    private Text txtPreco;

    @FXML
    private Text txtRegimes;

    @FXML
    private Text txtRegimes1;

    @FXML
    void addPlate(ActionEvent event) {

    }

    @FXML
    void autoPlateCompleter(KeyEvent event) {

    }

    @FXML
    void editPlate(ActionEvent event) {

    }

    @FXML
    void plateSelected(MouseEvent event) {

    }

    @FXML
    void removePlate(ActionEvent event) {

    }


    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
        platesList.getItems().add("00-AA-00");
        platesList.getItems().add("11-BB-11");
        platesList.getItems().add("22-CC-22");
        platesList.getItems().add("33-DD-33");
        platesList.getItems().add("44-EE-44");
    }
}
