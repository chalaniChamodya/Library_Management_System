package lk.ijse.Library_Management_System.DAO.Custom.Impl;

import lk.ijse.Library_Management_System.Configuration.SessionFactoryConfig;
import lk.ijse.Library_Management_System.DAO.Custom.AdminDao;
import lk.ijse.Library_Management_System.Entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private final Session session;

    public AdminDaoImpl() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    @Override
    public Admin getData(int id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Admin> getAllDetail() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Admin admin) throws SQLException, ClassNotFoundException {
        //Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        int adminId = (int) session.save(admin);
        transaction.commit();
        session.close();
        return adminId > 0;
    }

    @Override
    public boolean update(Admin dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public int generateNewId() throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int checkUsernameAndPassword(String username, String password) {
        //Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "SELECT admin_id FROM admin WHERE admin_name=:1 AND password=:2";
        NativeQuery query = session.createSQLQuery(sql);
        query.setParameter("1",username);
        query.setParameter("2", password);

        List<Object[]> list = query.list();

        Object user = list.get(0);

        int id = (int) user;

        session.close();
        return id;
    }
}
