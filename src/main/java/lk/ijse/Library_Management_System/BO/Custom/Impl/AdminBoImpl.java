package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.AdminBO;
import lk.ijse.Library_Management_System.DAO.Custom.AdminDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.AdminDTO;
import lk.ijse.Library_Management_System.Entity.Admin;

import java.sql.SQLException;

public class AdminBoImpl implements AdminBO {

    AdminDao adminDao = (AdminDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public boolean saveAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException {
        Admin admin = new Admin();
        admin.setId(dto.getId());
        admin.setName(dto.getName());
        admin.setPosition(dto.getPosition());
        admin.setPassword(dto.getPassword());
        admin.setEmail(dto.getEmail());
        admin.setBooks(dto.getBookList());
        return adminDao.save(admin);
    }

    @Override
    public int checkUsernameAndPassword(String username, String password) {
        return adminDao.checkUsernameAndPassword(username,password);
    }
}
