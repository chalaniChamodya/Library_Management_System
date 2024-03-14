package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import lk.ijse.Library_Management_System.BO.Custom.BranchBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BranchBoImpl;
import lk.ijse.Library_Management_System.DTO.BranchDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class StaffBranchBarFormController {
    public Label txtBranchId;
    public Label txtAddress;
    public Label txtTotalBook;

    static int branchId;

    BranchBO branchBO = new BranchBoImpl();

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("StaffBranchUpdateForm.fxml");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure ?").showAndWait();
        if(type.isPresent()){
            boolean isdeleted = branchBO.deleteBranch(branchId);
            if(isdeleted){
                new Alert(Alert.AlertType.INFORMATION,"Book Deleted").show();
                StaffBranchFormController.getInstance().getAllId();
            }
        }
    }

    public void setData(int id) throws SQLException, ClassNotFoundException {
        branchId = id;
        BranchDTO dto = branchBO.getData(id);
        txtBranchId.setText(String.valueOf(dto.getId()));
        txtAddress.setText(dto.getAddress());
        txtTotalBook.setText(String.valueOf(dto.getTotalNoOfBooks()));
    }
}
