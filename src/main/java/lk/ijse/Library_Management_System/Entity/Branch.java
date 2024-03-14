package lk.ijse.Library_Management_System.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "branch_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch_address")
    private String address;

    @Column(name = "no_of_total_books")
    private int noOfTotalBooks;

    @ManyToOne()
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Branch(){}

    public Branch(int id, String address, int noOfTotalBooks, Admin admin) {
        this.id = id;
        this.address = address;
        this.noOfTotalBooks = noOfTotalBooks;
        this.admin = admin;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfTotalBooks() {
        return noOfTotalBooks;
    }

    public void setNoOfTotalBooks(int noOfTotalBooks) {
        this.noOfTotalBooks = noOfTotalBooks;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", noOfTotalBooks=" + noOfTotalBooks +
                ", admin=" + admin +
                '}';
    }
}
