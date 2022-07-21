package Controler;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaxOfficeViewController {

    private MainWindowController mainWindowController;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    private TextField indexTextField;

    @FXML
    private TextArea depositTextArea;

    @FXML
    public void showAllOnAction (){
        depositTextArea.appendText(mainWindowController.taxOffice.raport());
    }

    @FXML
    public void showOnAction (){
        String idx = indexTextField.getText();
        try {
            int idxInt = Integer.parseInt(idx);
            depositTextArea.appendText(mainWindowController.taxOffice.raport(idxInt));
        }
        catch (NumberFormatException ex)
        {
            depositTextArea.appendText("Należy podać liczbę.");
        }
        catch (Exception ex)
        {
            depositTextArea.appendText(ex.getMessage());
        }

    }
    @FXML
    public void backToMenuOnAction() {
        mainWindowController.loadMainWindowView();
    }

}
