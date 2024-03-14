package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.sql.SQLException;

public class StaffMemberAddFormController {
    public Label lblUserId;
    public TextField txtUserName;
    public TextField txtAddress;
    public TextField txtPassword;
    public TextField txtMobileNo;
    public TextField txtEmail;

    UserBO userBO = new UserBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setBookId();
    }

    private void setBookId() throws SQLException, ClassNotFoundException {
        int id = userBO.generateNextUserId();
        lblUserId.setText(String.valueOf(id));
    }
    public void btnAddMemberOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        UserDTO dto = new UserDTO();
        dto.setId(Integer.parseInt(lblUserId.getText()));
        dto.setName(txtUserName.getText());
        dto.setAddress(txtAddress.getText());
        dto.setEmail(txtEmail.getText());
        dto.setPassword(txtPassword.getText());
        dto.setMobileNo(Integer.parseInt(txtMobileNo.getText()));

        boolean isSaved = userBO.saveUser(dto);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "User Saved Successfully !").show();
            Navigation.closePopup();
            StaffMemberFormController.getInstance().getAllId();
        }else{
            new Alert(Alert.AlertType.ERROR, "Book doesn't Saved Yet !").show();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePopup();
    }
}
