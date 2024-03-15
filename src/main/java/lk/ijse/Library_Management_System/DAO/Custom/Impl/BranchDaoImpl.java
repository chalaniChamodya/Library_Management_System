package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.BranchDao;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.Branch;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchDaoImpl implements BranchDao {
    //private final Session session;



    @Override
    public Branch getData(int id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Branch branch = session.get(Branch.class, id);
        return branch;
    }

    @Override
    public ArrayList<Branch> getAllDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Branch dto) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int affectedRows = (int) session.save(dto);
        transaction.commit();
        session.close();
        return affectedRows > 0;
    }

    @Override
    public boolean update(Branch dto) throws SQLException, ClassNotFoundException {
        try {
            Session session = SessionFactoryConfig.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        try {
            Session session = SessionFactoryConfig.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            Branch branch = session.get(Branch.class, id);
            session.delete(branch);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }
    }

    @Override
    public int generateNewId() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Branch> criteria = builder.createQuery(Branch.class);
        Root<Branch> root = criteria.from(Branch.class);
        criteria.select(root);

        List<Branch> entities = session.createQuery(criteria).getResultList();

        ArrayList<Branch> branchList = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            branchList.add(entities.get(i));
        }
        //System.out.println(bookList);

        for (int i = 0; i < branchList.size(); i++) {
            idList.add(String.valueOf(branchList.get(i).getId()));
        }

        //System.out.println(idList);
        session.close();
        return idList;
    }
}
