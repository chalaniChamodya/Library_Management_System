package lk.ijse.Library_Management_System.BO.Custom;

import lk.ijse.Library_Management_System.BO.SuperBO;
import lk.ijse.Library_Management_System.DTO.BookDTO;
import lk.ijse.Library_Management_System.DTO.BranchDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BranchBO extends SuperBO {
    boolean saveBranch(BranchDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteBranch(int branchId) throws SQLException, ClassNotFoundException;

    BranchDTO getData(int id) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllBranchId() throws SQLException, ClassNotFoundException;
    int generateNextBranchId() throws SQLException, ClassNotFoundException;

    boolean UpdateBranch(BranchDTO dto) throws SQLException, ClassNotFoundException;
}
