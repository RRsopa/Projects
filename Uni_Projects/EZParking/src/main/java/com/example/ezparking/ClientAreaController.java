package com.example.ezparking;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.text.Text;

public class ClientAreaController extends Controller {

    @FXML
    private Text contactText;

    @FXML
    private Text nameText;

    @FXML
    private Text planText;

    @FXML
    private Text statusText;

    @FXML
    private Text subText;
    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
    }
}
