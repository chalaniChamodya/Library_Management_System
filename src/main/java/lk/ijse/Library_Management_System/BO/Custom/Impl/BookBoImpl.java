package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.DAO.Custom.BookDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.Entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookBoImpl implements BookBO {
    BookDao bookDao = (BookDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);
    @Override
    public boolean saveBook(BookDTO dto) throws SQLException, ClassNotFoundException {
        Book book = new Book();
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setBookStatus(dto.getStatus());
        //book.setAdmin(dto.getAdminId());
        book.setNoOfCopies(dto.getNoOfCopies());
        return bookDao.save(book);
    }

    @Override
    public ArrayList<String> getAllBookId() throws SQLException, ClassNotFoundException {
        return bookDao.getAllId();
    }

    @Override
    public BookDTO getData(int id) throws SQLException, ClassNotFoundException {
        Book book = bookDao.getData(id);
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        //dto.setAdminId(book.getAdmin());
        dto.setStatus(book.getBookStatus());
        dto.setAuthor(book.getAuthor());
        dto.setNoOfCopies(book.getNoOfCopies());
        return dto;
    }

    @Override
    public boolean deleteBook(int bookId) throws SQLException, ClassNotFoundException {
        return bookDao.delete(bookId);
    }

    @Override
    public int generateNextBookId() throws SQLException, ClassNotFoundException {
        int lastID = bookDao.generateNewId();
        int newId = lastID++;
        return newId;
    }

    @Override
    public boolean UpdateBook(BookDTO dto) throws SQLException, ClassNotFoundException {
        Book book = new Book();
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setBookStatus(dto.getStatus());
        //book.setAdmin(dto.getAdminId());
        book.setNoOfCopies(dto.getNoOfCopies());
        return bookDao.update(book);
    }

    @Override
    public ArrayList<String> getAvailableBooks() {
        return bookDao.getAvailableBookData();
    }

    @Override
    public ArrayList<String> getAvailableBookNames() {
        return bookDao.getAvailableBookNames();
    }

    @Override
    public String getBookId(String bookName) {
        return bookDao.getBookId(bookName);
    }

    @Override
    public int getAllBookCount() {
        return bookDao.getAllBookCount();
    }

    @Override
    public int getAllBorrowedBookCount() {
        return bookDao.getAllBorrowedBookCount();
    }
}
