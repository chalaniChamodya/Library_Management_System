package lk.ijse.Library_Management_System.Utill;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.Library_Management_System.Controller.StaffGlobalFormController;
import lk.ijse.Library_Management_System.Controller.UserGlobalFormController;

import java.io.IOException;

public class Navigation {
    private static Stage stage;
    private static Scene scene;
    private static Parent parent;

    public static void switchNavigation(String link, ActionEvent event) throws IOException {
        parent = FXMLLoader.load(Navigation.class.getResource("/view/" + link));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void switchPaging(Pane pane, String path) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }

    public static void switchPaging(AnchorPane pane, String path) throws IOException {
        pane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/view/"+path));
        Parent root = loader.load();
        pane.getChildren().add(root);
    }

    public static void popupPane(String path) throws IOException {
        StaffGlobalFormController.getInstance().crudPane.setVisible(true);
        switchPaging(StaffGlobalFormController.getInstance().crudPane, path);
    }

    public static void popupPaneUser(String path) throws IOException {
        UserGlobalFormController.getInstance().crudPane.setVisible(true);
        switchPaging(UserGlobalFormController.getInstance().crudPane, path);
    }

    public static void closePopup(){
        StaffGlobalFormController.getInstance().crudPane.getChildren().clear();
        StaffGlobalFormController.getInstance().crudPane.setVisible(false);
    }
    public static void closePopupUser(){
        UserGlobalFormController.getInstance().crudPane.getChildren().clear();
        UserGlobalFormController.getInstance().crudPane.setVisible(false);
    }
}
