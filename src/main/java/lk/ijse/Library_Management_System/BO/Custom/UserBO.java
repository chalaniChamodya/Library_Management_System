package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllUserId() throws SQLException, ClassNotFoundException;
    UserDTO getData(int id) throws SQLException, ClassNotFoundException;

    boolean deleteUser(int bookId) throws SQLException, ClassNotFoundException;

    int generateNextUserId() throws SQLException, ClassNotFoundException;

    boolean UpdateUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    int checkUsernameAndPassword(String userName, String password) throws SQLException, ClassNotFoundException;

    int getAllUserCount();
}
