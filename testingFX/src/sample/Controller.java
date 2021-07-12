package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.Printer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;

public class Controller {

    @FXML
    public void buttonClicked() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("pane2.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    }
}
