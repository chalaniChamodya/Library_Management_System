package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;
import lk.ijse.Library_Management_System.DTO.AdminDTO;

import java.sql.SQLException;

public interface AdminBO extends SuperBO {
    boolean saveAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException;

    int checkUsernameAndPassword(String username, String password);
}
