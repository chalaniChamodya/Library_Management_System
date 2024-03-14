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

public class StaffMemberUpdateFormController {
    public Label lblUserId;
    public TextField lblUserName;
    public TextField lblAddress;
    public TextField lblPassword;
    public TextField lblEmail;
    public TextField lblMobileNo;

    UserBO userBO = new UserBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
    }

    private void setData() throws SQLException, ClassNotFoundException {
        UserDTO dto = userBO.getData(StaffMemberBarFormController.userId);
        lblUserId.setText(String.valueOf(dto.getId()));
        lblUserName.setText(dto.getName());
        lblAddress.setText(dto.getAddress());
        lblEmail.setText(dto.getEmail());
        lblMobileNo.setText(String.valueOf(dto.getMobileNo()));
    }

    public void btnUpdateMemberOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        UserDTO dto = new UserDTO();
        dto.setId(Integer.parseInt(lblUserId.getText()));
        dto.setName(lblUserName.getText());
        dto.setAddress(lblAddress.getText());
        dto.setEmail(lblEmail.getText());
        dto.setPassword(lblPassword.getText());
        dto.setMobileNo(Integer.parseInt(lblMobileNo.getText()));

        boolean isSaved = userBO.UpdateUser(dto);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "User Updated Successfully !").show();
            Navigation.closePopup();
            StaffMemberFormController.getInstance().getAllId();
        }else{
            new Alert(Alert.AlertType.ERROR, "User doesn't Update Yet !").show();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePopup();
    }
}
