package Controler;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MenuViewController {

    private MainWindowController mainWindowController;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }


    @FXML
    public void addAccountOnAction() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddAccountView.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddAccountViewCotroller addAccountViewCotroller = loader.getController();
        addAccountViewCotroller.setMainWindowController(mainWindowController);
        mainWindowController.setView(pane);

    }

    @FXML
    public void withdrawOnAction(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/WithdrawView.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WithdrawViewController withdrawViewController = loader.getController();
        withdrawViewController.setMainWindowController(mainWindowController);
        mainWindowController.setView(pane);
    }

    @FXML
    public void depositOnAction(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DepositView.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DepositViewController depositViewController = loader.getController();
        depositViewController.setMainWindowController(mainWindowController);
        mainWindowController.setView(pane);
    }

    @FXML
    public void transferOnAction(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/TransferView.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TransferViewController transferViewController = loader.getController();
        transferViewController.setMainWindowController(mainWindowController);
        mainWindowController.setView(pane);
    }

    @FXML
    public void taxOfficeOnAction(){
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/TaxOfficeView.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TaxOfficeViewController taxOfficeViewController = loader.getController();
        taxOfficeViewController.setMainWindowController(mainWindowController);
        mainWindowController.setView(pane);
    }

    @FXML
    public void exitOnAction(){
        Platform.exit();
    }
}
