package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.sql.SQLException;

public class StaffBookUpdateFormController {
    public Label lblBookId;
    public TextField txtBookName;
    public TextField txtAuthorName;
    public ComboBox cmbGenre;
    public TextField txtNoOfCopies;

    BookBO bookBO = new BookBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
    }

    private void setData() throws SQLException, ClassNotFoundException {
        BookDTO dto = bookBO.getData(StaffBookBarFormController.bookId);
        lblBookId.setText(String.valueOf(dto.getId()));
        txtBookName.setText(dto.getName());
        txtAuthorName.setText(dto.getAuthor());
        txtNoOfCopies.setText(String.valueOf(dto.getNoOfCopies()));
        //cmbGenre.setItems(dto.get);
    }

    public void btnUpdateBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BookDTO book = new BookDTO();
        book.setId(Integer.parseInt(lblBookId.getText()));
        book.setName(txtBookName.getText());
        book.setAdminId(1);
        book.setAuthor(txtAuthorName.getText());
        book.setStatus("Available");
        book.setNoOfCopies(Integer.parseInt(txtNoOfCopies.getText()));

        boolean isSaved = bookBO.UpdateBook(book);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Book Updated Successfully !").show();
            Navigation.closePopup();
            StaffBookFormController.getInstance().getAllId();
        }else{
            new Alert(Alert.AlertType.ERROR, "Book doesn't Update Yet !").show();
        }
    }

    public void btnCancelBookOnAction(ActionEvent actionEvent) {
        Navigation.closePopup();
    }
}
