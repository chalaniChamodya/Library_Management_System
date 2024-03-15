package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;
import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.BookDao;
import lk.ijse.Library_Management_System.DAO.Custom.TransactionDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.Transaction;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    Session session;
    BookDao bookDao = new BookDaoImpl();
    //private final Session session;
    @Override
    public Transaction getData(int id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction existingTran = session.get(Transaction.class, id);

        return existingTran;
    }

    @Override
    public ArrayList<Transaction> getAllDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Transaction dto) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction hibernateTransaction = session.beginTransaction();

        try {
            BookDao bookDao = (BookDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);
            int bookId = dto.getBooks().get(0).getId();

            Book UpdateBook = bookDao.updateBookAvailability(bookId);
            session.update(UpdateBook);

            int isSavedTrans = (int) session.save(dto);

            if(isSavedTrans > 0){
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
        Session session = SessionFactoryConfig.getInstance().getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Transaction> criteria = builder.createQuery(Transaction.class);
        Root<Transaction> root = criteria.from(Transaction.class);
        criteria.select(root);

        List<Transaction> entities = session.createQuery(criteria).getResultList();

        ArrayList<Transaction> TList = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            TList.add(entities.get(i));
        }

        for (int i = 0; i < TList.size(); i++) {
            idList.add(String.valueOf(TList.get(i).getId()));
        }

        session.close();
        return idList;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean saveUserBookBorrow(Transaction transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction bookTransaction = session.beginTransaction();

        this.setSession(session);
        session.save(transactionDto);

        for (BookDTO bookDto : bookList) {

            Book book = new Book();
            book.setBookStatus(bookDto.getStatus());
            //book.setGenre(bookDto.getGenre());
            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setId(bookDto.getId());
           // book.setAdmin();

            bookDao.update(book);

        }
        try {
            bookTransaction.commit();
            return true;
        } catch (Exception e) {
            bookTransaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean UpdateUserBookBorrow(Transaction transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction bookTransaction = session.beginTransaction();

        this.setSession(session);
        session.update(transactionDto);

        for (BookDTO bookDto : bookList) {

            Book book = new Book();
            book.setBookStatus(bookDto.getStatus());
            //book.setGenre(bookDto.getGenre());
            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setId(bookDto.getId());
            book.setNoOfCopies(bookDto.getNoOfCopies());
            book.setBookStatus(bookDto.getStatus());
            // book.setAdmin();

            bookDao.update(book);

        }
        try {
            bookTransaction.commit();
            return true;
        } catch (Exception e) {
            bookTransaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
