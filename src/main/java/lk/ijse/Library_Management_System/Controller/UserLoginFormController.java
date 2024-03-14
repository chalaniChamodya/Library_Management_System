package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class UserLoginFormController {
    private static UserLoginFormController controller;
    public TextField txtUsername;
    public PasswordField txtPassword;

    static int logedUserId;

    public UserLoginFormController() {
        controller = this;
    }

    public static UserLoginFormController getInstance(){
        return controller;
    }

    UserBO userBO = new UserBoImpl();

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int id = userBO.checkUsernameAndPassword(txtUsername.getText(), txtPassword.getText());
        try {
            if (id > 0){
                logedUserId = id;
                Navigation.switchNavigation("UserGlobalForm.fxml", actionEvent);
            }else {
                new Alert(Alert.AlertType.ERROR, "Opps ! \nIncorrect Username or Password !").show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
