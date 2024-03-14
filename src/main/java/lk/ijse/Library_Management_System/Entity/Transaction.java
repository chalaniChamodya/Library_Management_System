package lk.ijse.Library_Management_System.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    @Column(name = "borrowed_date")
    private String borrowedDate;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "handover_date")
    private String handOverDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Transaction() {
    }

    public Transaction(int id, String borrowedDate, String dueDate, String handOverDate, User user, List<Book> books) {
        this.id = id;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.handOverDate = handOverDate;
        this.user = user;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getHandOverDate() {
        return handOverDate;
    }

    public void setHandOverDate(String handOverDate) {
        this.handOverDate = handOverDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                ", handOverDate=" + handOverDate +
                ", user=" + user +
                ", books=" + books +
                '}';
    }
}
