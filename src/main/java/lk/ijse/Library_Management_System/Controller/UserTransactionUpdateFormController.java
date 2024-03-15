package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTransactionUpdateFormController {
    public Label lblTrend;
    public Label lblBorrowDate;
    public Label lblBookId;
    public Label lblDueDate;
    public DatePicker txtReturnDate;

    BookBO bookBO = new BookBoImpl();
    UserBO userBO = new UserBoImpl();
    TransactionBO transactionBO = new TransactionBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
    }

    private void setData() throws SQLException, ClassNotFoundException {
        TransactionDTO dto = transactionBO.getData(UserTransactionBarFormController.transactionId);

        lblBookId.setText(String.valueOf(dto.getBooks().get(0).getId()));
        lblTrend.setText(String.valueOf(dto.getId()));
        lblBorrowDate.setText(dto.getBorrowedDate());
        lblDueDate.setText(dto.getDueDate());
    }

    public void btnUpdateTransactionOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        TransactionDTO dto = new TransactionDTO();
        dto.setId(Integer.parseInt(lblTrend.getText()));

        BookDTO bookDto = bookBO.getData(Integer.parseInt(lblBookId.getText()));
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(book.getName());
        book.setAuthor(bookDto.getAuthor());
        book.setBookStatus("Available");
        int noOfCopies = bookDto.getNoOfCopies();
        book.setNoOfCopies(noOfCopies+1);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        dto.setBooks(bookList);

        UserDTO userDto = userBO.getData(UserLoginFormController.logedUserId);
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());

        dto.setUser(user);
        dto.setBorrowedDate(lblBorrowDate.getText());
        dto.setHandOverDate(String.valueOf(txtReturnDate.getValue()));
        dto.setDueDate(lblDueDate.getText());

        List<BookDTO> bookDTOList = new ArrayList<>();
        BookDTO updateBook = bookBO.getData(Integer.parseInt(lblBookId.getText()));
        updateBook.setNoOfCopies(noOfCopies);
        updateBook.setStatus("Available");
        bookDTOList.add(updateBook);

        transactionBO.UpdateUserBookBorrow(dto, bookDTOList);
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Navigation.closePopupUser();
    }
}
