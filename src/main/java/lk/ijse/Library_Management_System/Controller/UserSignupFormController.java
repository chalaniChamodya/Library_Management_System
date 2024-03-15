package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class UserSignupFormController {
    public TextField txtUsername;
    public PasswordField txtPassword;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtMobile;
    public PasswordField txtPassword1;

    public static int signupedUSerId;

    UserBO userBO = new UserBoImpl();
    public void btnSignupOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        UserDTO dto = new UserDTO();
        dto.setName(txtUsername.getText());
        dto.setAddress(txtAddress.getText());
        dto.setEmail(txtEmail.getText());
        dto.setMobileNo(Integer.parseInt(txtMobile.getText()));
        dto.setPassword(txtPassword1.getText());

        userBO.saveUser(dto);
        Navigation.switchNavigation("UserGlobalForm.fxml", actionEvent);

        signupedUSerId = Integer.parseInt(userBO.getUserId(txtUsername.getText()));
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchNavigation("PreLoginForm.fxml", actionEvent);
    }

}
