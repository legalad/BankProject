package Controler;

import Model.BankLogic.Account;
import Model.BankLogic.BankAccount;
import Model.BankLogic.Owner;
import Model.BankLogic.SavingAccount;
import Model.Exceptions.NrAccountEx;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Locale;

public class AddAccountViewCotroller {

    private MainWindowController mainWindowController;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextArea addAccountTextArea;



    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void addNewAccountOnAction(){
        String name = nameTextField.getText().trim().toUpperCase();
        String surname = surnameTextField.getText().trim().toUpperCase();
        String output;
        if (name.isEmpty() || surname.isEmpty()) output = "\nPodaj imię i nazwisko";
        else {
            BankAccount account = new SavingAccount(new Owner(name, surname)); //tu można dodać że różne konta
            try {
                mainWindowController.bank.addAccount(account);
                output = "\nPomyślnie założono konto.\nTwój numer konta to:\n" + account.getAccountNr();
            } catch (NrAccountEx e) {
                output = e.getMessage();
            }
        }
        addAccountTextArea.appendText(output);
    }

    @FXML
    public void backToMenuOnAction(){
        mainWindowController.loadMainWindowView();
    }
}
