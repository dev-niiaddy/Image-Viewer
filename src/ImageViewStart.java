import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class ImageViewStart extends Application {

    private static final String APP_NAME = "CC Image Viewer";

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL mainSceneUrl = Paths.get("./src/resources/fxml/main.fxml").toUri().toURL();
        Parent parent = FXMLLoader.load(mainSceneUrl);
        Scene scene = new Scene(parent);


        primaryStage.setTitle(APP_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
