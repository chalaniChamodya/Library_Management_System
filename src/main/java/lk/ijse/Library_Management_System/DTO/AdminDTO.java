package lk.ijse.Library_Management_System.DTO;

import lk.ijse.Library_Management_System.Entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {
    private int id;
    private String name;
    private String position;
    private String password;
    private String email;
    private List<Book> bookList;
}
