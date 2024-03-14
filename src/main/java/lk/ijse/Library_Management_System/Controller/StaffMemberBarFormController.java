package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class StaffMemberBarFormController {
    public Label lblUserId;
    public Label lblUserName;
    public Label lblMobileNo;
    public Label lblAddress;
    public Label lblEmail;
    static int userId;

    UserBO userBO = new UserBoImpl();

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("StaffMemberUpdateForm.fxml");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure ?").showAndWait();
        if(type.isPresent()){
            boolean isdeleted = userBO.deleteUser(userId);
            if(isdeleted){
                new Alert(Alert.AlertType.INFORMATION,"Book Deleted").show();
                StaffMemberFormController.getInstance().getAllId();
            }
        }
    }

    public void setData(int id) throws SQLException, ClassNotFoundException {
        userId = id;
        UserDTO dto = userBO.getData(id);
        lblUserId.setText(String.valueOf(dto.getId()));
        lblUserName.setText(dto.getName());
        lblAddress.setText(dto.getAddress());
        lblEmail.setText(dto.getEmail());
        lblMobileNo.setText(String.valueOf(dto.getMobileNo()));
    }
}
