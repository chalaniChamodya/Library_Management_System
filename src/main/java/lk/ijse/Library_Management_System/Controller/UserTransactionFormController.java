package lk.ijse.Library_Management_System.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.Impl.TransactionBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.User;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTransactionFormController {
    public AnchorPane pagingPane;
    public ComboBox cmbBook1;
    public Label lblBookId;
    public Label lblBorrowDate;
    public Label lblDueDate;
    public ComboBox cmbBook2;
    public Label txtTime;
    public Label lblBookId1;
    public Label lblBookId2;
    public ComboBox cmbBook3;
    public Label lblBookId3;

    BookBO bookBO = new BookBoImpl();
    TransactionBO transactionBO = new TransactionBoImpl();

    UserBO userBO = new UserBoImpl();

    public void initialize(){
        setDataInBookCmb();
        lblBorrowDate.setText(String.valueOf(LocalDate.now()));
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(21);
        lblDueDate.setText(String.valueOf(dueDate));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> txtTime.setText(timeNow())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date()) ;
    }

    private void setDataInBookCmb() {
        ArrayList<String> books = bookBO.getAvailableBookNames();
        cmbBook1.getItems().addAll(books);
        cmbBook2.getItems().addAll(books);
        cmbBook3.getItems().addAll(books);
    }

    public void cmbBookNameOnAction(ActionEvent actionEvent) {
        lblBookId1.setText(bookBO.getBookId(String.valueOf(cmbBook1.getSelectionModel().getSelectedItem())));
    }
    public void cmbBookName2OnAction(ActionEvent actionEvent) {
        lblBookId2.setText(bookBO.getBookId(String.valueOf(cmbBook2.getSelectionModel().getSelectedItem())));
    }

    public void cmbBookName3OnAction(ActionEvent actionEvent) {
        lblBookId3.setText(bookBO.getBookId(String.valueOf(cmbBook3.getSelectionModel().getSelectedItem())));
    }

    public void bookIdOnAction(MouseEvent mouseEvent) {
       //
    }

    public void btnOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //System.out.println("button clicked");


    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        clearFeilds();
    }

    private void clearFeilds() {
        lblBookId.setText("");
        lblBookId2.setText("");
        lblBookId3.setText("");
        lblDueDate.setText("");
        lblBorrowDate.setText("");
    }


    public void btnDoneTransactionOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        TransactionDTO dto = new TransactionDTO();

        List<BookDTO> books = new ArrayList<>();
        BookDTO book1 = bookBO.getData(Integer.parseInt(lblBookId.getText()));
        books.add(book1);

        //dto.setBooks(books);

        UserDTO userDto = userBO.getData(UserLoginFormController.logedUserId);
        User user = new User();
        user.setId(UserLoginFormController.logedUserId);
        user.setName(userDto.getName());

        dto.setUser(user);
        dto.setBorrowedDate(lblBorrowDate.getText());
        dto.setDueDate(lblDueDate.getText());

        //boolean isSaved = transactionBO.saveTransaction(dto);
        boolean isSaved = transactionBO.saveUserBookBorrow(dto, books);
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Transaction Successful! ").show();
            clearFeilds();
        }else {
            new Alert(Alert.AlertType.ERROR, "Transaction didn't successful !").show();
        }
    }
}
