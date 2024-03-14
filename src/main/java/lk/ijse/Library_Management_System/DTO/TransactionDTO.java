package lk.ijse.Library_Management_System.DTO;

import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDTO {
    private int id;
    private String borrowedDate;
    private String dueDate;
    private String handOverDate;
    private User user;
    private List<Book> books = new ArrayList<>();
}
