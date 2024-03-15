package lk.ijse.Library_Management_System.DAO.Custom;

import lk.ijse.Library_Management_System.DAO.SuperDAO;

public interface QueryDao extends SuperDAO {
    int getAllOverdueBookCount();
}
