package Controler;

import Model.Exceptions.NoAccountEx;
import Model.Exceptions.NoMoneyEx;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class WithdrawViewController {

    @FXML
    private TextField accountNrTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextArea withdrawTextArea;

    private MainWindowController mainWindowController;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void withdrawOnAction() {
        String nrAccount = accountNrTextField.getText().replaceAll("\\s", "");
        double amount = -1;
        if (nrAccount.length() != 16) {withdrawTextArea.appendText("\nNumer konta powinien składać się z 16 cyfr");}
        try {
            amount = Double.parseDouble(amountTextField.getText());
            if (amount > 0){
                try {
                    if(mainWindowController.bank.withdraw(nrAccount, amount)) {withdrawTextArea.appendText("\nWypłacono środki (" + amount + " zł),\nz konta o nr: " + nrAccount);}
                } catch (NoMoneyEx e) {
                    withdrawTextArea.appendText(e.getMessage());
                } catch (NoAccountEx e) {
                    withdrawTextArea.appendText(e.getMessage());
                }
            }
            else withdrawTextArea.appendText("\nNależy podać dodatnią kwotę.");
        } catch (NumberFormatException ex) {
            withdrawTextArea.appendText("\nKwota nieprawidłowa.");
        }

    }

    @FXML
    public void backToMenuOnAction(){
        mainWindowController.loadMainWindowView();
    }
}
