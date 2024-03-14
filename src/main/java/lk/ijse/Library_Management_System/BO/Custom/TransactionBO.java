package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;

import java.sql.SQLException;

public interface TransactionBO extends SuperBO {
    boolean saveTransaction(TransactionDTO dto) throws SQLException, ClassNotFoundException;
}
