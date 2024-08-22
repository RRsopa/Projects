package com.example.ezparking;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    private User user;
    private DataBase dataBase;
    @FXML
    private BorderPane mainPane;
    private Parent mainParent;
    private Parent menuBarParent;
    private MenuBarController menuBarController;
    private Controller centerContentController;
    private Parent centerContentParent;

    public void changeSceneTo(String sceneName, EstatutoEnum status, ScenesEnum scene){
        FXMLLoader centerContentLoader = new FXMLLoader(getClass().getResource(sceneName));
        try{
            this.centerContentParent = centerContentLoader.load();
            this.centerContentController = centerContentLoader.getController();
            this.mainPane.setCenter(centerContentParent);
            this.centerContentController.getParentScene(this);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        this.menuBarController.setMenuBarItems(status, scene);
        this.dataBase.runQuery("SELECT * FROM searchClients");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dataBase = new DataBase();
        FXMLLoader menuBarLoader = new FXMLLoader(getClass().getResource("MenuBarView.fxml"));
        try {
            this.menuBarParent = menuBarLoader.load();
            this.menuBarController = menuBarLoader.getController();
            this.menuBarController.getParentScene(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.mainPane.setTop(menuBarParent);
        changeSceneTo("LoginView.fxml", EstatutoEnum.Utilizador, ScenesEnum.Login);
    }

    public boolean loginAttempt(String mail, String password){
        user = dataBase.authenticateUser(mail, password);
        if(user == null){
            return false;
        }
        System.out.println(user);
        return true;
    }
}
