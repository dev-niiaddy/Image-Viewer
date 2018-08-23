package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private StackPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        onImageAction(new ActionEvent());
    }


    @FXML
    public void onImageAction(ActionEvent e) {
        try {
            URL imagesFxmlUrl = Paths.get("./src/resources/fxml/images.fxml").toUri().toURL();
            Parent parent = FXMLLoader.load(imagesFxmlUrl);

            rootPane.getChildren().add(parent);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @FXML
    public void onBackAction(ActionEvent e) {
        e.consume();
    }

    @FXML
    public void onCameraAction(ActionEvent e) {
        e.consume();
    }

    @FXML
    public void onSettingsAction(ActionEvent e) {
        e.consume();
    }


}
