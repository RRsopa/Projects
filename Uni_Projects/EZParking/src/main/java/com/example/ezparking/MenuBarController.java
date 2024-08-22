package com.example.ezparking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static com.example.ezparking.ScenesEnum.Acessos;

public class MenuBarController extends Controller {
    private EstatutoEnum CurrentStatus;
    @FXML
    private MenuItem MIAccessArea;

    @FXML
    private MenuItem MIClientArea;

    @FXML
    private MenuItem MIParks;

    @FXML
    private MenuItem MIPlans;

    @FXML
    private MenuItem MIPlates;

    @FXML
    private StackPane buttonStack;

    @FXML
    private MenuButton clientMenu;

    @FXML
    private Text currentSceneText;

    @FXML
    private Button loginBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Pane menu;

    @FXML
    private StackPane menuStack;

    @FXML
    private Button registrateBtn;
    @FXML
    void goToClientArea(ActionEvent event) {
        parentController.changeSceneTo("ClientAreaView.fxml", CurrentStatus, ScenesEnum.Cliente);
    }

    @FXML
    void goToParks(ActionEvent event) {
        parentController.changeSceneTo("ParkingSpotsView.fxml", CurrentStatus, ScenesEnum.Parques);
    }
    @FXML
    void goToSubs(ActionEvent event) {
        parentController.changeSceneTo("SubscriptionsView.fxml", CurrentStatus, ScenesEnum.Subscrições);
    }

    @FXML
    void goToPlates(ActionEvent event) {
        parentController.changeSceneTo("PlatesView.fxml", CurrentStatus, ScenesEnum.Matrículas);
    }

    @FXML
    void goToRegistration(ActionEvent event) {
        parentController.changeSceneTo("RegisterView.fxml", EstatutoEnum.Utilizador, ScenesEnum.Registrar);
    }

    @FXML
    void logoutCommand(ActionEvent event) {
        parentController.changeSceneTo("LoginView.fxml", EstatutoEnum.Utilizador, ScenesEnum.Login);
    }

    public void setMenuBarItems(EstatutoEnum status, ScenesEnum scene){
        menuStack.getChildren().clear();
        buttonStack.getChildren().clear();
        if (scene == ScenesEnum.Login){
            buttonStack.getChildren().add(registrateBtn);
        }
        else if (scene == ScenesEnum.Registrar) {
            buttonStack.getChildren().add(loginBtn);
        }
       else{
            reInsertMenuItems();
            menuStack.getChildren().add(clientMenu);
            buttonStack.getChildren().add(logoutBtn);
            switch (scene){
                case Acessos:
                    clientMenu.getItems().remove(MIAccessArea);
                    break;
                case Cliente:
                    clientMenu.getItems().remove(MIClientArea);
                    break;
                case Matrículas:
                    clientMenu.getItems().remove(MIPlates);
                    break;
                case Subscrições:
                    clientMenu.getItems().remove(MIPlans);
                case Parques:
                    clientMenu.getItems().remove(MIParks);
            }
        }
        currentSceneText.setText(scene.toString());
       this.CurrentStatus = status;
    }

    private void reInsertMenuItems(){
        clientMenu.getItems().clear();
        clientMenu.getItems().add(MIClientArea);
        clientMenu.getItems().add(MIAccessArea);
        clientMenu.getItems().add(MIPlates);
        clientMenu.getItems().add(MIPlans);
        clientMenu.getItems().add(MIParks);
    }
    @Override
    public void getParentScene(MainSceneController parent) {
        this.parentController = parent;;
    }

    public void goToAccessArea(ActionEvent event) {
        parentController.changeSceneTo("AccessView.fxml", CurrentStatus, Acessos);
    }
}
