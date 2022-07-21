package pl.javastart.BankProjectTest;

import Model.Database.Connector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainView.fxml"));
        StackPane mainPain = loader.load();
        Scene scene = new Scene(mainPain);
        stage.setScene(scene);
        stage.setTitle("Bank App");
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
