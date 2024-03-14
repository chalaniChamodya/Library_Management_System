package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;
import lk.ijse.Library_Management_System.DAO.Custom.TransactionDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.Entity.Transaction;

import java.sql.SQLException;

public class TransactionBoImpl implements TransactionBO {

    TransactionDao transactionDao = (TransactionDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    @Override
    public boolean saveTransaction(TransactionDTO dto) throws SQLException, ClassNotFoundException {
        Transaction transaction = new Transaction();
        transaction.setBooks(dto.getBooks());
        transaction.setId(dto.getId());
        transaction.setUser(dto.getUser());
        transaction.setBorrowedDate(String.valueOf(dto.getBorrowedDate()));

        return transactionDao.save(transaction);
    }
}
