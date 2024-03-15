package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TransactionBO extends SuperBO {
    //boolean saveTransaction(TransactionDTO dto) throws SQLException, ClassNotFoundException;
    boolean saveUserBookBorrow(TransactionDTO transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException;

    boolean UpdateUserBookBorrow(TransactionDTO transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllTransactionId() throws SQLException, ClassNotFoundException;
    TransactionDTO getData(int id) throws SQLException, ClassNotFoundException;
}
