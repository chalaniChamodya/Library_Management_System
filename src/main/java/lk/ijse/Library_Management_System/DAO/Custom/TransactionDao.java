package lk.ijse.Library_Management_System.DAO.Custom;

import lk.ijse.Library_Management_System.DAO.CrudDao;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.Entity.Transaction;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TransactionDao extends CrudDao<Transaction> {
    void setSession(Session session);
    boolean saveUserBookBorrow(Transaction transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException;
    boolean UpdateUserBookBorrow(Transaction transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllUserTransactionId(int userId) throws SQLException, ClassNotFoundException;
}
