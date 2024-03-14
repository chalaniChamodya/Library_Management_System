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
import java.util.ArrayList;

public class StaffBookAddFormController {
    public Label lblBookId;
    public TextField txtBookName;
    public TextField txtAuthorName;
    public ComboBox cmbGenre;
    public TextField txtNoOfCopies;

    BookBO bookBO = new BookBoImpl();


    public void initialize() throws SQLException, ClassNotFoundException {
        setDataToComboBox();
        setBookId();
    }

    private void setBookId() throws SQLException, ClassNotFoundException {
        int id = bookBO.generateNextBookId();
        lblBookId.setText(String.valueOf(id));
    }

    private void setDataToComboBox() {
        ArrayList<String> genres = new ArrayList<>();
        genres.add("Fiction");
        genres.add("Non-Fiction");
        genres.add("Narrative");
        genres.add("Novel");
        genres.add("Mystery");
        cmbGenre.getItems().addAll(genres);
    }

    public void btnAddBookOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BookDTO book = new BookDTO();
        book.setName(txtBookName.getText());
        book.setAdminId(1);
        book.setAuthor(txtAuthorName.getText());
        book.setStatus("Available");
        book.setNoOfCopies(Integer.parseInt(txtNoOfCopies.getText()));

        boolean isSaved = bookBO.saveBook(book);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Book Saved Successfully !").show();
            Navigation.closePopup();
            StaffBookFormController.getInstance().getAllId();
        }else{
            new Alert(Alert.AlertType.ERROR, "Book doesn't Saved Yet !").show();
        }
    }

    public void btnCancelBookOnAction(ActionEvent actionEvent) {
        Navigation.closePopup();
    }
}
