package lk.ijse.Library_Management_System.Controller;

import javafx.scene.control.Label;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.DTO.BookDTO;

import java.sql.SQLException;

public class UserBookBarFormController {
    public Label lblBookId;
    public Label lblBookName;
    public Label lblAuthor;
    public Label lblStatus;
    public Label lblAction;

    BookBO bookBO = new BookBoImpl();

    public void setData(int id) throws SQLException, ClassNotFoundException {
        BookDTO dto = bookBO.getData(id);
        lblBookId.setText(String.valueOf(dto.getId()));
        lblBookName.setText(dto.getName());
        lblAuthor.setText(dto.getAuthor());
        lblStatus.setText("Available");
    }
}
