package com.example.ezparking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterController extends Controller {

    @FXML
    private Text checkPasswordError;

    @FXML
    private PasswordField checkPasswordField;

    @FXML
    private Text contactError;

    @FXML
    private PasswordField contactField;

    @FXML
    private Text emailError;

    @FXML
    private TextField emailField;

    @FXML
    private Text nameError;

    @FXML
    private Text passwordError;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userField;

    @FXML
    private Text wrongEmailLabel;

    @FXML
    private Text wrongPasswordLabel;

    @FXML
    private Text wrongPasswordLabel1;

    @FXML
    void RegisterUser(ActionEvent event) {

    }

    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
    }
}
