package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.QueryBO;
import lk.ijse.Library_Management_System.DAO.Custom.QueryDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;

public class QueryBoImpl implements QueryBO {
    QueryDao queryDao = (QueryDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);
    @Override
    public int getAllOverdueBookCount() {
        return queryDao.getAllOverdueBookCount();
    }
}
