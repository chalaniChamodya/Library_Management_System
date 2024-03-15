package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.UserDao;
import lk.ijse.Library_Management_System.Entity.Book;
import lk.ijse.Library_Management_System.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //private final Session session;

    @Override
    public User getData(int id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public ArrayList<User> getAllDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        int affectedRows = (int) session.save(dto);
        transaction.commit();
        session.close();
        return affectedRows > 0;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        try {
            Session session = SessionFactoryConfig.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()). show();
            return false;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        try {
            Session session = SessionFactoryConfig.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
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
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);

        List<User> entities = session.createQuery(criteria).getResultList();

        ArrayList<User> userList = new ArrayList<>();
        ArrayList<String> idList = new ArrayList<>();

        for (int i = 0; i < entities.size(); i++) {
            userList.add(entities.get(i));
        }

        for (int i = 0; i < userList.size(); i++) {
            idList.add(String.valueOf(userList.get(i).getId()));
        }

        session.close();
        return idList;
    }

    @Override
    public int checkUsernameAndPassword(String userName, String password) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "SELECT user_id FROM user WHERE user_name=:1 AND password=:2";
        NativeQuery query = session.createSQLQuery(sql);
        query.setParameter("1",userName);
        query.setParameter("2", password);

        List<Object[]> list = query.list();

        Object user = list.get(0);

        int id = (int) user;

        session.close();
        return id;
    }

    @Override
    public int getAllUserCount() {
        Session session = SessionFactoryConfig.getInstance().getSession();

        String sql = "SELECT COUNT(user_id) FROM user ";
        NativeQuery query = session.createSQLQuery(sql);

        List<Object[]> list = query.list();

        Object user = list.get(0);

        String userCounts = String.valueOf(user);
        int userCount = Integer.parseInt(userCounts);

        session.close();
        return userCount;
    }
}
