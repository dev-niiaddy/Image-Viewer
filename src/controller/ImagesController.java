package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ImagesController implements Initializable, DirectoryStream.Filter<Path> {

    @FXML
    private ImageView imageView;

    private List<Path> pathList;

    private int imageIndex = -1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initImages();
        onNextAction(new ActionEvent());
    }

    public void onNextAction(ActionEvent event){

        if(imageIndex < pathList.size() - 1) {

            try {

                Image image = new Image(pathList.get(++imageIndex).toUri().toURL().toExternalForm());
                imageView.setImage(image);

            }catch (IOException e) {
                e.printStackTrace();
            }
        }


        event.consume();
    }

    public void onPreviousAction(ActionEvent event) {

        if( imageIndex > 0) {

            try {

                Image image = new Image(pathList.get(--imageIndex).toUri().toURL().toExternalForm());
                imageView.setImage(image);

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initImages() {
        pathList = new ArrayList<>();

        DirectoryStream<Path> pathDirectoryStream = loadImages();

        if(pathDirectoryStream != null) {

            pathDirectoryStream.forEach(path -> pathList.add(path));
        }
    }

    private DirectoryStream<Path> loadImages() {
        try {

            Path path = new File("C:/Users/Addy/Pictures").toPath();
            return Files.newDirectoryStream(path, this);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean accept(Path entry) {

        String stringPath = entry.toString();

        return stringPath.endsWith("jpg") || stringPath.endsWith("png")
                || stringPath.endsWith("JPG") || stringPath.endsWith("PNG")
                || stringPath.endsWith("jpeg") || stringPath.endsWith("JPEG");
    }
}
