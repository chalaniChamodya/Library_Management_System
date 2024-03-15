package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import lk.ijse.Library_Management_System.BO.Custom.Impl.TransactionBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;

public class UserTransactionBarFormController {
    public Label lblTranId;
    public Label lblBookId;
    public Label lblBorrowDate;
    public Label lblDueDate;
    public Label lblReturnDate;

    static int transactionId;

    TransactionBO transactionBO = new TransactionBoImpl();

    public void setData(int id) throws SQLException, ClassNotFoundException {
        transactionId = id;
        TransactionDTO dto;

        dto = transactionBO.getData(id);

        lblTranId.setText(String.valueOf(dto.getId()));
        lblBookId.setText(String.valueOf(dto.getBooks().get(0).getId()));
        lblBorrowDate.setText(dto.getBorrowedDate());
        lblDueDate.setText(dto.getDueDate());
        lblReturnDate.setText(dto.getHandOverDate());
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPaneUser("UserTransactionUpdateForm.fxml");
    }
}
