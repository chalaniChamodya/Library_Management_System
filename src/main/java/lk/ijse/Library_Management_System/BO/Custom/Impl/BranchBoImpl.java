package lk.ijse.Library_Management_System.BO.Custom.Impl;

import lk.ijse.Library_Management_System.BO.Custom.BranchBO;
import lk.ijse.Library_Management_System.DAO.Custom.BranchDao;
import lk.ijse.Library_Management_System.DAO.DAOFactory;
import lk.ijse.Library_Management_System.DTO.BranchDTO;
import lk.ijse.Library_Management_System.Entity.Branch;

import java.sql.SQLException;
import java.util.ArrayList;

public class BranchBoImpl implements BranchBO {
    BranchDao branchDao = (BranchDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCH);
    @Override
    public boolean saveBranch(BranchDTO dto) throws SQLException, ClassNotFoundException {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setNoOfTotalBooks(dto.getTotalNoOfBooks());
        return branchDao.save(branch);
    }

    @Override
    public boolean deleteBranch(int branchId) throws SQLException, ClassNotFoundException {
        return branchDao.delete(branchId);
    }

    @Override
    public BranchDTO getData(int id) throws SQLException, ClassNotFoundException {
        Branch branch = branchDao.getData(id);
        BranchDTO dto = new BranchDTO();
        dto.setId(branch.getId());
        dto.setAddress(branch.getAddress());
        dto.setTotalNoOfBooks(branch.getNoOfTotalBooks());
        return dto;
    }

    @Override
    public ArrayList<String> getAllBranchId() throws SQLException, ClassNotFoundException {
        return branchDao.getAllId();
    }

    @Override
    public int generateNextBranchId() throws SQLException, ClassNotFoundException {
        int lastID = branchDao.generateNewId();
        int newId = lastID++;
        return newId;
    }

    @Override
    public boolean UpdateBranch(BranchDTO dto) throws SQLException, ClassNotFoundException {
        Branch branch = new Branch();
        branch.setId(dto.getId());
        branch.setAddress(dto.getAddress());
        branch.setNoOfTotalBooks(dto.getTotalNoOfBooks());
        return branchDao.update(branch);
    }
}
