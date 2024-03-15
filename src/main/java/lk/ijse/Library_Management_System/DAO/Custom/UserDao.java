package lk.ijse.Library_Management_System.DAO.Custom;

import lk.ijse.Library_Management_System.DAO.CrudDao;
import lk.ijse.Library_Management_System.Entity.User;

public interface UserDao extends CrudDao<User> {
    int checkUsernameAndPassword(String userName, String password);

    int getAllUserCount();
}
