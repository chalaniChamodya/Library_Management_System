package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.BranchBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BranchBoImpl;
import lk.ijse.Library_Management_System.DTO.BranchDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.sql.SQLException;

public class StaffBranchAddFormController {
    public Label lblBranchId;
    public TextField txtBranchAddress;
    public TextField txtTotalBooks;

    BranchBO branchBO = new BranchBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setBranchId();
    }

    private void setBranchId() throws SQLException, ClassNotFoundException {
        int id = branchBO.generateNextBranchId();
        lblBranchId.setText(String.valueOf(id));
    }

    public void btnAddBranchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BranchDTO branch = new BranchDTO();
        branch.setAdminId(1);
        branch.setAddress(txtBranchAddress.getText());
        branch.setTotalNoOfBooks(Integer.parseInt(txtTotalBooks.getText()));

        boolean isSaved = branchBO.saveBranch(branch);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Branch Saved Successfully !").show();
            Navigation.closePopup();
            StaffBranchFormController.getInstance().getAllId();
        }else{
            new Alert(Alert.AlertType.ERROR, "Branch doesn't Saved Yet !").show();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePopup();
    }
}
