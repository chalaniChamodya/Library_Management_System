package lk.ijse.Library_Management_System.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T> extends SuperDAO{
    T getData(int id) throws SQLException, ClassNotFoundException;
    ArrayList<T> getAllDetail() throws SQLException, ClassNotFoundException;
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(int id) throws SQLException, ClassNotFoundException;
    int generateNewId() throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllId() throws SQLException, ClassNotFoundException;
}
