package lk.ijse.Library_Management_System.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "available_status")
    private String bookStatus;

    @Column(name = "no_of_copies")
    private int noOfCopies;

    @ManyToOne()
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private List<Transaction> transactions = new ArrayList<>();

    public Book() {
    }

    public Book(int id, String name, String author, String bookStatus, int noOfCopies, Admin admin, List<Transaction> transactions) {
        this.bookId = id;
        this.name = name;
        this.author = author;
        this.bookStatus = bookStatus;
        this.noOfCopies = noOfCopies;
        this.admin = admin;
        this.transactions = transactions;
    }

    public int getId() {
        return bookId;
    }

    public void setId(int id) {
        this.bookId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", bookStatus='" + bookStatus + '\'' +
                ", noOfCopies=" + noOfCopies +
                ", admin=" + admin +
                ", transactions=" + transactions +
                '}';
    }
}
