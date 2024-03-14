package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.sql.SQLException;
import java.util.NavigableMap;

public class UserProfileEditFormController {
    public Label lblId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPassword;
    public TextField txtMobileNo;
    public TextField txtEmail;

    UserBO userBO =new UserBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
    }

    public void setData() throws SQLException, ClassNotFoundException {
        UserDTO dto = userBO.getData(UserLoginFormController.logedUserId);
        lblId.setText(String.valueOf(dto.getId()));
        txtName.setText(dto.getName());
        txtAddress.setText(dto.getAddress());
        txtEmail.setText(dto.getEmail());
        txtMobileNo.setText(String.valueOf(dto.getMobileNo()));
        txtPassword.setText(dto.getPassword());
    }
    public void btnEditProfileOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        UserDTO dto = new UserDTO();
        dto.setId(Integer.parseInt(lblId.getText()));
        dto.setName(txtName.getText());
        dto.setAddress(txtAddress.getText());
        dto.setEmail(txtEmail.getText());
        dto.setPassword(txtPassword.getText());
        dto.setMobileNo(Integer.parseInt(txtMobileNo.getText()));

        boolean isUpdated = userBO.UpdateUser(dto);

        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION, "Profile updated successfully !").show();
            Navigation.closePopupUser();
            UserProfileFormController.getInstance().setData();
        }else {
            new Alert(Alert.AlertType.ERROR, "Couldn't Update Profile!").show();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePopupUser();
    }
}
