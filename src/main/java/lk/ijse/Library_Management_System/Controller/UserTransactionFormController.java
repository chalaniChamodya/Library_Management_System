package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.Impl.TransactionBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserTransactionFormController {
    public AnchorPane pagingPane;
    public TextField txtHandOverDate;
    public ComboBox cmbBook1;
    public Label lblBookId;
    public Label lblBorrowDate;
    public Label lblDueDate;
    public ComboBox cmbBook2;
    public Label txtTime;

    BookBO bookBO = new BookBoImpl();
    TransactionBO transactionBO = new TransactionBoImpl();

    public void initialize(){
        setDataInBookCmb();
        lblBorrowDate.setText(String.valueOf(LocalDate.now()));
    }

    private void setDataInBookCmb() {
        ArrayList<String> books = bookBO.getAvailableBookNames();
        cmbBook1.getItems().addAll(books);
    }

    public void btnAvailableBooksOnAction(ActionEvent actionEvent) {
    }

    public void btnDoneTransactionOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


    }

    public void btnCacelOnAction(ActionEvent actionEvent) {

    }

    public void cmbBookNameOnAction(ActionEvent actionEvent) {
        lblBookId.setText(bookBO.getBookId(String.valueOf(cmbBook1.getSelectionModel().getSelectedItem())));
    }

    public void btnDoneOnAction(ActionEvent actionEvent) {

    }

    public void bookIdOnAction(MouseEvent mouseEvent) {
       //
    }

    public void btnOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println("button clicked");

        TransactionDTO dto = new TransactionDTO();

        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(Integer.parseInt(lblBookId.getText()));
        book1.setName(String.valueOf(cmbBook1.getSelectionModel().getSelectedItem()));
        books.add(book1);

        dto.setBooks(books);

        User user = new User();
        user.setId(UserLoginFormController.logedUserId);

        dto.setUser(user);
        dto.setBorrowedDate(lblBorrowDate.getText());

        boolean isSaved = transactionBO.saveTransaction(dto);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Transaction Successfull! ").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Transation didn't successful !").show();
        }
    }
}
