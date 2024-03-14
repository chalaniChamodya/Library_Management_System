package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/PreLoginForm.fxml"));
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Login page");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Throwable cause = e.getCause();
            cause.printStackTrace();
        }
    }
}