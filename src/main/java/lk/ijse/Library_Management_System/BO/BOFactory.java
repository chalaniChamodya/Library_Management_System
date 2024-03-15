package lk.ijse.Library_Management_System.BO;

import lk.ijse.Library_Management_System.BO.Custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() :boFactory;
    }

    public enum BOTypes{
        BOOK,ADMIN,BRANCH,USER, TRANSACTION,QUERY
    }

    public SuperBO getTypes(BOTypes boTypes){
        switch (boTypes){
            case BOOK:
                return (SuperBO) new BookBoImpl();
            case ADMIN:
                return new AdminBoImpl();
            case BRANCH:
                return new BranchBoImpl();
            case USER:
                return new UserBoImpl();
            case TRANSACTION:
                return new TransactionBoImpl();
            case QUERY:
                return new QueryBoImpl();
            default:
                return null;
        }
    }
}
