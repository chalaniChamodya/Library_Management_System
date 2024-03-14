package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class UserProfileFormController {
    private static UserProfileFormController controller;
    public AnchorPane pagingPane;
    public Label txtTime;
    public Label lblUserId;
    public Label lblUserName;
    public Label lblAddress;
    public Label lblMobileNo;
    public Label lblEmail;

    UserBO userBO = new UserBoImpl();

    public UserProfileFormController() {
        controller = this;
    }
    public static UserProfileFormController getInstance(){
        return controller;
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
    }

    public void setData() throws SQLException, ClassNotFoundException {
        UserDTO dto = userBO.getData(UserLoginFormController.logedUserId);
        lblUserId.setText(String.valueOf(dto.getId()));
        lblUserName.setText(dto.getName());
        lblAddress.setText(dto.getAddress());
        lblEmail.setText(dto.getEmail());
        lblMobileNo.setText(String.valueOf(dto.getMobileNo()));
    }

    public void btnEditProfileOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPaneUser("UserProfileEditForm.fxml");
    }
}
