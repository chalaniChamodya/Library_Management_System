package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class StaffBookBarFormController {
    public Label txtBookId;
    public Label txtBookName;
    public Label txtAuthor;
    public Label txtStatus;
    public Label txtCopies;
    static int bookId;

    BookBO bookBO = new BookBoImpl();
    public void setData(int id) throws SQLException, ClassNotFoundException {
        bookId = id;
        BookDTO dto;
        //System.out.println("book detail"+bookBO.getData(id));
        dto = bookBO.getData(id);
        this.txtBookId.setText(String.valueOf(id));
        this.txtBookName.setText(dto.getName());
        this.txtAuthor.setText(dto.getAuthor());
        this.txtStatus.setText(dto.getStatus());
        this.txtCopies.setText(String.valueOf(dto.getNoOfCopies()));
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("StaffBookUpdateForm.fxml");
    }

    public void pbtnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure ?").showAndWait();
        if(type.isPresent()){
            boolean isdeleted = bookBO.deleteBook(bookId);
            if(isdeleted){
                new Alert(Alert.AlertType.INFORMATION,"Book Deleted").show();
                StaffBookFormController.getInstance().getAllId();
            }
        }
    }
}
