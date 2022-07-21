module BankProjectTest {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    exports pl.javastart.BankProjectTest to javafx.graphics;
    exports Controler to javafx.fxml;
    opens Controler;
}