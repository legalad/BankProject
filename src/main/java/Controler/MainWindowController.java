package Controler;

import Model.BankLogic.Bank;
import Model.Observer.EventManager;
import Model.Offices.TaxOffice;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private StackPane mainStackPane;

    protected Bank bank;
    protected TaxOffice taxOffice;

    public MainWindowController(){
        this.bank = new Bank();
        this.taxOffice = new TaxOffice();
        bank.getEvents().addObserverOffice(taxOffice);
    }

    @FXML
    public void initialize(){
        loadMainWindowView();
    }

    public void loadMainWindowView() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuView.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuViewController menuViewController = loader.getController();
        menuViewController.setMainWindowController(this);
        setView(pane);
    }

    public void setView(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }
}
