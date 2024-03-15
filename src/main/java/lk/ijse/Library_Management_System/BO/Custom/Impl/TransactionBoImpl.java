package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;
import lk.ijse.Library_Management_System.DAO.Custom.TransactionDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.TransactionDTO;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionBoImpl implements TransactionBO {

    TransactionDao transactionDao = (TransactionDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);
    /*@Override
    public boolean saveTransaction(TransactionDTO dto) throws SQLException, ClassNotFoundException {
        Transaction transaction = new Transaction();
        transaction.setBooks(dto.getBooks());
        transaction.setId(dto.getId());
        transaction.setUser(dto.getUser());
        transaction.setBorrowedDate(String.valueOf(dto.getBorrowedDate()));

        return transactionDao.save(transaction);
    }*/

    @Override
    public boolean saveUserBookBorrow(TransactionDTO transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException {
        Transaction bookTransaction = new Transaction();

        bookTransaction.setId(transactionDto.getId());
        bookTransaction.setBorrowedDate(transactionDto.getBorrowedDate());
        bookTransaction.setDueDate(transactionDto.getDueDate());
        bookTransaction.setUser(transactionDto.getUser());

        List<Book> tranBookList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = new Book();
            book.setId(bookList.get(i).getId());
            book.setName(bookList.get(i).getName());

            int oldCopies = bookList.get(i).getNoOfCopies();
            int newCopies =  oldCopies -1;

            book.setNoOfCopies(newCopies);

            if (newCopies == 0){
                book.setBookStatus("No");
            }else{
                book.setBookStatus(bookList.get(i).getStatus());
            }

            book.setAuthor(bookList.get(i).getAuthor());

            tranBookList.add(book);
        }

        bookTransaction.setBooks(tranBookList);

        return transactionDao.saveUserBookBorrow(bookTransaction, bookList);
    }

    @Override
    public boolean UpdateUserBookBorrow(TransactionDTO transactionDto, List<BookDTO> bookList) throws SQLException, ClassNotFoundException {
        Transaction bookTransaction = new Transaction();

        bookTransaction.setId(transactionDto.getId());
        bookTransaction.setBorrowedDate(transactionDto.getBorrowedDate());
        bookTransaction.setDueDate(transactionDto.getDueDate());
        bookTransaction.setUser(transactionDto.getUser());
        bookTransaction.setHandOverDate(transactionDto.getHandOverDate());

        List<Book> tranBookList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = new Book();
            book.setId(bookList.get(i).getId());
            book.setName(bookList.get(i).getName());
            book.setNoOfCopies(bookList.get(i).getNoOfCopies());
            book.setAuthor(bookList.get(i).getAuthor());
            book.setBookStatus(bookList.get(i).getStatus());
            tranBookList.add(book);
        }

        bookTransaction.setBooks(tranBookList);

        return transactionDao.UpdateUserBookBorrow(bookTransaction, bookList);
    }


    @Override
    public ArrayList<String> getAllTransactionId() throws SQLException, ClassNotFoundException {
        return transactionDao.getAllId();
    }

    @Override
    public TransactionDTO getData(int id) throws SQLException, ClassNotFoundException {
        Transaction transaction = transactionDao.getData(id);
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setBooks(transaction.getBooks());
        dto.setBorrowedDate(transaction.getBorrowedDate());
        dto.setDueDate(transaction.getDueDate());
        dto.setHandOverDate(transaction.getHandOverDate());
        return dto;
    }

    @Override
    public ArrayList<String> getAllUserTransactionId(int userId) throws SQLException, ClassNotFoundException {
        return transactionDao.getAllUserTransactionId(userId);
    }
}
