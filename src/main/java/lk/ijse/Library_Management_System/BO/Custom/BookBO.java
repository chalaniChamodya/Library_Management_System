package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;
import lk.ijse.Library_Management_System.DTO.BookDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookBO extends SuperBO {
    boolean saveBook(BookDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllBookId() throws SQLException, ClassNotFoundException;
    BookDTO getData(int id) throws SQLException, ClassNotFoundException;

    boolean deleteBook(int bookId) throws SQLException, ClassNotFoundException;

    int generateNextBookId() throws SQLException, ClassNotFoundException;

    boolean UpdateBook(BookDTO book) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAvailableBooks();
    ArrayList<String> getAvailableBookNames();

    String getBookId(String bookName);
}
