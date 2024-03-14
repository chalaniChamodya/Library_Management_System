package lk.ijse.Library_Management_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private int id;
    private String name;
    private String author;
    private String status;
    private int noOfCopies;
    private int adminId;
}
