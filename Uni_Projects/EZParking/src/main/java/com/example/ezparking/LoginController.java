package com.example.ezparking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller {

    @FXML
    private Button accessPlate;

    @FXML
    private TextField emailField;

    @FXML
    private Text incorrectPlateFormat;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField plateField;

    @FXML
    private Text wrongEmailLabel;

    @FXML
    private Text wrongPasswordLabel;

    @FXML
    private Text wrongPlateLabel;

    @FXML
    void AuthenticateUser(ActionEvent event) {
        String email = this.emailField.getText();
        String pass = this.passwordField.getText();
        parentController.loginAttempt(email, pass);
        parentController.changeSceneTo("ClientAreaView.fxml", EstatutoEnum.Cliente, ScenesEnum.Cliente);
    }

    @FXML
    void RegisterUser(ActionEvent event) {

    }

    @FXML
    void enterByPlate(ActionEvent event) {

    }

    @FXML
    void autoPlateCompleter(KeyEvent event) {

    }

    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;
    }
}
