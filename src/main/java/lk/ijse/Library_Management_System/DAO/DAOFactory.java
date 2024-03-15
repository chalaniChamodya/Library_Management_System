package lk.ijse.Library_Management_System.DAO;


import lk.ijse.Library_Management_System.DAO.Custom.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        BOOK,ADMIN, BRANCH,USER,TRANSACTION,QUERY
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case BOOK:
                return new BookDaoImpl();
            case ADMIN:
                return new AdminDaoImpl();
            case BRANCH:
                return new BranchDaoImpl();
            case USER:
                return new UserDaoImpl();
            case TRANSACTION:
                return new TransactionDaoImpl();
            case QUERY:
                return new QueryDaoImpl();
        }
        return null;
    }
}
