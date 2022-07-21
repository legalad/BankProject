package Controler;

import Model.Exceptions.NoAccountEx;
import Model.Exceptions.NoMoneyEx;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TransferViewController {

    MainWindowController mainWindowController;

    @FXML
    private TextField accountNrFrom;

    @FXML
    private TextField accountNrTo;

    @FXML
    private TextField ammountTransfer;

    @FXML
    private TextArea transferTextArea;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void transferOnAction() {
        String nrAccountFrom = accountNrFrom.getText().replaceAll("\\s", "");
        String nrAccountTo = accountNrTo.getText().replaceAll("\\s", "");
        double amount = -1;
        String output = "";
        if (nrAccountFrom.length() != 16 || nrAccountTo.length() != 16) {transferTextArea.appendText("\nNumer konta powinien składać się z 16 cyfr");}
        try {
            amount = Double.parseDouble(ammountTransfer.getText());
            if (amount > 0) {
                try {
                    if (mainWindowController.bank.transfer(nrAccountFrom, nrAccountTo, amount))
                        output = "\nPrzesłano środki (" + amount + " zł):\nZ konta: " + nrAccountFrom + "\nNa konto:" + nrAccountTo;
                } catch (NoAccountEx e) {
                    output = e.getMessage();
                } catch (NoMoneyEx e) {
                    output = e.getMessage();
                }
            }
            else output = ("\nNależy podać dodatnią kwotę.");
        }
        catch (NumberFormatException ex) {
            transferTextArea.appendText("\nKwota nieprawidłowa.");
        }

            transferTextArea.appendText(output);
    }

    @FXML
    public void backToMenuOnAction(){
        mainWindowController.loadMainWindowView();
    }
}
