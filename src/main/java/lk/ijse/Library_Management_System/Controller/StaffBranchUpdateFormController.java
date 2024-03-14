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

public class StaffBranchUpdateFormController {
    public Label lblBranchId;
    public TextField txtBranchAddress;
    public TextField txtTotalBooks;

    BranchBO branchBO = new BranchBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
    }

    private void setData() throws SQLException, ClassNotFoundException {
        BranchDTO dto = branchBO.getData(StaffBranchBarFormController.branchId);
        lblBranchId.setText(String.valueOf(dto.getId()));
        txtBranchAddress.setText(dto.getAddress());
        txtTotalBooks.setText(String.valueOf(dto.getTotalNoOfBooks()));
    }

    public void btnUpdateBranchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BranchDTO dto = new BranchDTO();
        dto.setId(Integer.parseInt(lblBranchId.getText()));
        dto.setAddress(txtBranchAddress.getText());
        dto.setTotalNoOfBooks(Integer.parseInt(txtTotalBooks.getText()));

        boolean isSaved = branchBO.UpdateBranch(dto);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated Successfully !").show();
            Navigation.closePopup();
            StaffBranchFormController.getInstance().getAllId();
        }else{
            new Alert(Alert.AlertType.ERROR, "Branch doesn't Update Yet !").show();
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePopup();
    }
}
