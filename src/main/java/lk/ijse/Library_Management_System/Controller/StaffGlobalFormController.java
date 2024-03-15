package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;

public class StaffGlobalFormController {
    private static StaffGlobalFormController controller;
    public Pane btnDashboardLine;
    public Pane btnBookLine;
    public Pane btnBranchLine;
    public Pane btnMemberLine;
    public Pane pagingPane;
    public AnchorPane crudPane;

    public StaffGlobalFormController(){
        controller = this;
    }

    public static StaffGlobalFormController getInstance(){
        return controller;
    }

    public void initialize() throws IOException {
        btnDashboardLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane,"StaffDashboardForm.fxml");
    }

    public void btnDashboardOnAction(ActionEvent actionEvent) throws IOException {
        btnBookLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: #064273");
        btnBranchLine.setStyle("-fx-background-color: #064273");
        btnDashboardLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane,"StaffDashboardForm.fxml");
    }

    public void btnBookOnAction(ActionEvent actionEvent) throws IOException {
        btnDashboardLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: #064273");
        btnBranchLine.setStyle("-fx-background-color: #064273");
        btnBookLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane,"StaffBookForm.fxml");
    }

    public void btnBranchOnAction(ActionEvent actionEvent) throws IOException {
        btnBranchLine.setStyle("-fx-background-color: white");
        btnDashboardLine.setStyle("-fx-background-color: #064273");
        btnBookLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: #064273");
        Navigation.switchPaging(pagingPane, "StaffBranchForm.fxml");
    }

    public void btnMembersOnAction(ActionEvent actionEvent) throws IOException {
        btnDashboardLine.setStyle("-fx-background-color: #064273");
        btnBookLine.setStyle("-fx-background-color: #064273");
        btnBranchLine.setStyle("-fx-background-color: #064273");
        btnMemberLine.setStyle("-fx-background-color: white");
        Navigation.switchPaging(pagingPane, "StaffMemberForm.fxml");
    }
}
