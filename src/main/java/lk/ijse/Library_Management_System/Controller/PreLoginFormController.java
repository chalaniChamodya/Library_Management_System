package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;

public class PreLoginFormController {
    public void btnStaffLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("StaffLoginForm.fxml", actionEvent);
    }

    public void btnMemberLoginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("UserLoginForm.fxml", actionEvent);
    }

    public void btnMemberSignupOnAction(ActionEvent actionEvent) {
    }
}
