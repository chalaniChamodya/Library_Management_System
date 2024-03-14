package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.AdminBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.AdminBoImpl;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;

public class StaffLoginFormController {
    private static StaffLoginFormController controller;
    public TextField txtUsername;
    public PasswordField txtPassword;

    static int logedStaffId;

    public StaffLoginFormController(){controller = this;}

    public static StaffLoginFormController getInstance(){return controller;}

    AdminBO adminBO = new AdminBoImpl();
    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        int id = adminBO.checkUsernameAndPassword(txtUsername.getText(), txtPassword.getText());
        try {
            if (id > 0){
                logedStaffId = id;
                Navigation.switchNavigation("StaffGlobalForm.fxml", actionEvent);
            }else {
                new Alert(Alert.AlertType.ERROR, "Opps ! \nIncorrect Username or Password !").show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
