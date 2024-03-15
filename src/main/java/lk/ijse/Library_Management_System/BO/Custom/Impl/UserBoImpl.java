package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.DAO.Custom.UserDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.UserDTO;
import lk.ijse.Library_Management_System.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBoImpl implements UserBO {

    UserDao userDao = (UserDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMobileNo(dto.getMobileNo());
        //user.setAdmin(dto.get);
        return userDao.save(user);
    }

    @Override
    public ArrayList<String> getAllUserId() throws SQLException, ClassNotFoundException {
        return userDao.getAllId();
    }

    @Override
    public UserDTO getData(int id) throws SQLException, ClassNotFoundException {
        User user = userDao.getData(id);
        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setMobileNo(user.getMobileNo());

        return dto;
    }

    @Override
    public boolean deleteUser(int bookId) throws SQLException, ClassNotFoundException {
        return userDao.delete(bookId);
    }

    @Override
    public int generateNextUserId() throws SQLException, ClassNotFoundException {
        int lastID = userDao.generateNewId();
        int newId = lastID++;
        return newId;
    }

    @Override
    public boolean UpdateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        User user = new User();

        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setAddress(dto.getAddress());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMobileNo(dto.getMobileNo());

        return userDao.update(user);
    }

    @Override
    public int checkUsernameAndPassword(String userName, String password) throws SQLException, ClassNotFoundException {
        return userDao.checkUsernameAndPassword(userName,password);
    }

    @Override
    public int getAllUserCount() {
        return userDao.getAllUserCount();
    }

    @Override
    public String getUserId(String bookName) {
        return userDao.getUSerId(bookName);
    }
}
