package lk.ijse.Library_Management_System.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.ijse.Library_Management_System.BO.BOFactory;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.Impl.QueryBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.Impl.UserBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.QueryBO;
import lk.ijse.Library_Management_System.BO.Custom.UserBO;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;

public class StaffDashboardFormController {
    public AnchorPane pagingPane;
    public VBox vBox;
    public Label txtTime;
    public Label lblTotalUsers;
    public Label lblTotalBooks;
    public Label lblBorrowedBooks;
    public VBox vBox1;
    public Label lblOverdueBooks;

    BookBO bookBO = new BookBoImpl();
    UserBO userBO = new UserBoImpl();
    QueryBO queryBO = new QueryBoImpl();

    public void initialize(){
        setData();
    }

    private void setData() {
        lblTotalUsers.setText(String.valueOf(userBO.getAllUserCount()));
        lblTotalBooks.setText(String.valueOf(bookBO.getAllBookCount()));
        lblBorrowedBooks.setText(String.valueOf(bookBO.getAllBorrowedBookCount()));
       // lblOverdueBooks.setText(String.valueOf(queryBO.getAllOverdueBookCount()));
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(pagingPane,"StaffMemberForm.fxml");
    }

    public void btnOverdueBooksOnAction(ActionEvent actionEvent) {
    }

    public void btnBorrowedBooksOnAction(ActionEvent actionEvent) {
    }

    public void btnTotalBookOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(pagingPane,"StaffBookForm.fxml");
    }
}
