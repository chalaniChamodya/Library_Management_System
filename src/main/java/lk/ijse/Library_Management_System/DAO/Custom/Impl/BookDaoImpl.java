package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.BookDao;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.Entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.hibernate.query.NativeQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookDaoImpl implements BookDao {
    Session session;
    //private final Session session ;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Book getData(int id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        //int bookId = Integer.parseInt(id);
        Book existingBook = session.get(Book.class, id);

        return existingBook;
        /*BookDTO dto = new BookDTO();
        dto.setId(id);
        dto.setName(existingBook.getName());
        session.close();
        return dto;*/
    }

    @Override
    public ArrayList<Book> getAllDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Book book) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        /*Book book = new Book();
        book.setId(Integer.parseInt(String.valueOf(dto.getId())));
        book.setName(dto.getName());*/

        int bookId = (int) session.save(book);
        transaction.commit();
        session.close();
        return bookId > 0;
    }

    @Override
    public boolean update(Book book) throws SQLException, ClassNotFoundException {
        try{
            Session session = SessionFactoryConfig.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }

    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        try {
            Session session = SessionFactoryConfig.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            session.delete(book);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }
    }

    @Override
    public int generateNewId() throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "SELECT book_id FROM book ORDER BY book_id DESC LIMIT 1";
        NativeQuery query = session.createSQLQuery(sql);
        List<Object[]> idList = query.list();
        int[] ids = new int[idList.size()];

        //Object[] id = idList.get(0);
        for (int i = 0; i < idList.size(); i++) {
            //System.out.println("new ID\n" + );
            //ids[i] = idList.get(i);
        }
        //int id = Integer.parseInt(ids.get(0));
        return 0;
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        /*String sql = "SELECT book_id FROM book ORDER BY LENGTH(book_id),book_id ";
        NativeQuery query = session1.createSQLQuery(sql);
        List<Object[]> list = query.list();

        ArrayList<String> idList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            idList.add(Arrays.toString(list.get(i)));
        }

        session1.close();

        return idList;*/

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
        Root<Book> root = criteria.from(Book.class);
        criteria.select(root);

        //criteria.where(builder.equal(root.get("book_id")));

        List<Book> entities = session.createQuery(criteria).getResultList();

        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        //bookList.addAll(Collections.singleton(entities.get(1)));

        for (int i = 0; i < entities.size(); i++) {
            bookList.add(entities.get(i));
        }
        //System.out.println(bookList);

        for (int i = 0; i < bookList.size(); i++) {
            idList.add(String.valueOf(bookList.get(i).getId()));
        }

        //System.out.println(idList);
        session.close();
        return idList;
    }

    @Override
    public ArrayList<String> getAvailableBookData() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "SELECT book_id FROM book WHERE available_status=:1";
        NativeQuery query = session.createSQLQuery(sql);
        query.setParameter("1","Available");

        List<Object[]> list = query.list();

        ArrayList<Object> list2 = new ArrayList<>();
        list2.addAll(list);

        ArrayList<String> bookID= new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object object = list2.get(i);
            String id = String.valueOf(object);
            bookID.add(id);
        }
        session.close();
        return bookID;
    }

    @Override
    public ArrayList<String> getAvailableBookNames() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "SELECT book_name FROM book WHERE available_status=:1";
        NativeQuery query = session.createSQLQuery(sql);
        query.setParameter("1","Available");

        List<Object[]> list = query.list();

        ArrayList<Object> list2 = new ArrayList<>();
        list2.addAll(list);

        ArrayList<String> bookNames= new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object object = list2.get(i);
            String id = String.valueOf(object);
            bookNames.add(id);
        }
        session.close();
        return bookNames;
    }

    @Override
    public String getBookId(String bookName) {
        Session session1 = SessionFactoryConfig.getInstance().getSession();
        String sql = "SELECT book_id FROM book WHERE book_name=:1";
        NativeQuery query = session1.createSQLQuery(sql);
        query.setParameter("1",bookName);

        List<Object[]> list = query.list();

        ArrayList<Object> list2 = new ArrayList<>();
        list2.addAll(list);

        String bookId = String.valueOf(list2.get(0));

        session1.close();

        return bookId;
    }

    @Override
    public Book updateBookAvailability(int bookId) throws SQLException, ClassNotFoundException {
        try{
            Book book = getData(bookId);

            int BookCopies = book.getNoOfCopies();
            int newBookCopies = BookCopies -1;

            Book updateBok = new Book();

            updateBok.setId(book.getId());
            updateBok.setName(book.getName());
            updateBok.setAuthor(book.getAuthor());
            updateBok.setNoOfCopies(newBookCopies);
            if (newBookCopies > 0){
                updateBok.setBookStatus("Available");
            }else{
                updateBok.setBookStatus("No");
            }
            return updateBok;

        }catch (Exception e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return null;
        }
    }

    @Override
    public int getAllBookCount() {
        Session session = SessionFactoryConfig.getInstance().getSession();

        String sql = "SELECT COUNT(book_id) FROM book ";
        NativeQuery query = session.createSQLQuery(sql);

        List<Object[]> list = query.list();

        Object book = list.get(0);

        String bookCounts = String.valueOf(book);
        int bookCount = Integer.parseInt(bookCounts);

        session.close();
        return bookCount;
    }

    @Override
    public int getAllBorrowedBookCount() {
        Session session = SessionFactoryConfig.getInstance().getSession();

        String sql = "SELECT COUNT(book_id) FROM book WHERE available_status = :1 ";
        NativeQuery query = session.createSQLQuery(sql);
        String available = "No";
        query.setParameter("1",available);

        List<Object[]> list = query.list();

        Object book = list.get(0);

        String bookCounts = String.valueOf(book);
        int bookCount = Integer.parseInt(bookCounts);

        session.close();
        return bookCount;
    }
}
