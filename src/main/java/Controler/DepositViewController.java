package Controler;

import Model.Exceptions.NoAccountEx;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Scanner;

public class DepositViewController {

    private MainWindowController mainWindowController;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    private TextField accountNrTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextArea depositTextArea;

    @FXML
    public void depositOnAction() {
        String nrAccount = accountNrTextField.getText().replaceAll("\\s", "");
        double amount = -1;
        if (nrAccount.length() != 16) {depositTextArea.appendText("\nNumer konta powinien składać się z 16 cyfr");}
        try {
            amount = Double.parseDouble(amountTextField.getText());
            if (amount > 0) {
                try {
                    if (mainWindowController.bank.deposit(nrAccount, amount)) {
                        depositTextArea.appendText("\nWpłacono środki (" + amount + " zł),\nna konto o nr: " + nrAccount);
                    }
                } catch (NoAccountEx e) {
                    depositTextArea.appendText(e.getMessage());
                }
            }
            else depositTextArea.appendText("\nNależy podać dodatnią kwotę.");
        }
        catch (NumberFormatException ex) {
            depositTextArea.appendText("\nKwota nieprawidłowa.");
        }

    }

    @FXML
    public void backToMenuOnAction() {
        mainWindowController.loadMainWindowView();
    }
}
