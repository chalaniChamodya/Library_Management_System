package lk.ijse.Library_Management_System.DAO.Custom;

import lk.ijse.Library_Management_System.DAO.CrudDao;
import lk.ijse.Library_Management_System.Entity.Admin;

public interface AdminDao extends CrudDao<Admin> {
    int checkUsernameAndPassword(String username, String password);
}
