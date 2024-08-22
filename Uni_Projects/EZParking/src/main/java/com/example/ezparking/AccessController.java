package com.example.ezparking;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

public class AccessController extends Controller {

    @FXML
    private TableColumn<?, ?> Entry;

    @FXML
    private TableColumn<?, ?> Exit;

    @FXML
    private TableColumn<?, ?> Park;

    @FXML
    private Button Paybtn;

    @FXML
    private TableColumn<?, ?> Plate;

    @FXML
    private TableColumn<?, ?> Price;

    @FXML
    private Text txtPay;

    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
    }
}
