package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.BookDao;
import lk.ijse.Library_Management_System.DAO.Custom.TransactionDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.Transaction;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionDaoImpl implements TransactionDao {
    private final Session session;

    public TransactionDaoImpl() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public Transaction getData(int id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Transaction> getAllDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Transaction dto) throws SQLException, ClassNotFoundException {
        //Session session1 = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction hibernateTransaction = session.beginTransaction();

        try {
            int isSavedTrans = (int) session.save(dto);
            if(isSavedTrans > 0){
                //System.out.println("transaction save");
                BookDao bookDao = (BookDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);
                int bookId = dto.getBooks().get(0).getId();

                Book UpdateBook = bookDao.updateBookAvailability(bookId);
                session.update(UpdateBook);

                hibernateTransaction.commit();
                session.close();
                return true;
            }
        }catch (Exception e){
            hibernateTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Transaction dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public int generateNewId() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
