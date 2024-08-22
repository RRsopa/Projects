package com.example.ezparking;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class SubscriptionsController extends Controller {

    @FXML
    private Text diasAplicaveis;

    @FXML
    private Text maxPlates;

    @FXML
    private Text maxPlates1;

    @FXML
    private ComboBox<?> plansComboBox;

    @FXML
    private ComboBox<?> subsComboBox;

    @FXML
    private Text txtPlans;

    @FXML
    private Text txtPreco;

    @FXML
    private Text txtRegimes;

    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
    }
}
