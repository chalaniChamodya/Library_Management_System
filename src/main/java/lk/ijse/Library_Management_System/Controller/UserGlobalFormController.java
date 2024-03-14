package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;

public class UserGlobalFormController {
    private static UserGlobalFormController controller;
    public Pane btnDashboardLine;
    public Pane btnBookLine;
    public Pane btnMemberLine;
    public Pane btnTransactionLine;
    public Pane pagingPane;
    public AnchorPane crudPane;

    public UserGlobalFormController(){controller = this;}

    public static UserGlobalFormController getInstance() {
        return controller;
    }

    public void initialize(){
        btnDashboardLine.setStyle("-fx-background-color: white");
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) {
    }

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        btnDashboardLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: #064273");
        btnTransactionLine.setStyle("-fx-background-color: #064273");
        btnBookLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane,"UserBookForm.fxml");
    }

    public void btnTransactionOnAction(ActionEvent actionEvent) throws IOException {
        btnDashboardLine.setStyle("-fx-background-color: #064273");
        btnBookLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: #064273");
        btnTransactionLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane,"UserTransactionForm.fxml");
    }

    public void btnUserProfileOnAction(ActionEvent actionEvent) throws IOException {
        btnDashboardLine.setStyle("-fx-background-color: #064273");
        btnBookLine.setStyle("-fx-background-color: #064273");
        btnTransactionLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane,"UserProfileForm.fxml");
    }
}
