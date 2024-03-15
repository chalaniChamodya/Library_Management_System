package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;

public class PreLoginFormController {
    public void btnLoginStaffOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("StaffLoginForm.fxml", actionEvent);
    }

    public void btnLoginUserOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("UserLoginForm.fxml", actionEvent);
    }

    public void btnSignupOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("UserSignupForm.fxml", actionEvent);
    }
}
