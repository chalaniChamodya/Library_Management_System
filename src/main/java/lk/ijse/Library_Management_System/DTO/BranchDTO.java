package lk.ijse.Library_Management_System.DTO;

import lk.ijse.Library_Management_System.Entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BranchDTO {
    private int id;
    private String address;
    private int totalNoOfBooks;
    private int adminId;
}
