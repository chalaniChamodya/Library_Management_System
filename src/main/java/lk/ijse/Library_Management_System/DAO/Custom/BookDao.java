package lk.ijse.Library_Management_System.DAO.Custom;

import lk.ijse.Library_Management_System.DAO.CrudDao;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.Entity.Book;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookDao extends CrudDao<Book> {

    void setSession(Session session);
    ArrayList<String> getAvailableBookData();
    ArrayList<String> getAvailableBookNames();

    String getBookId(String bookName);

    Book updateBookAvailability(int bookId) throws SQLException, ClassNotFoundException;

    int getAllBookCount();
    int getAllBorrowedBookCount();
}
