package lk.ijse.Library_Management_System.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.Impl.TransactionBoImpl;
import lk.ijse.Library_Management_System.BO.Custom.TransactionBO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserDashboardFormController {
    public AnchorPane pagingPane;
    public VBox vBox;
    public Label txtTime;
    public Label lblTotalUsers;
    public Label lblAvailableBooks;
    public Label lblTotalBooks;
    public VBox vBox1;

    int id;

    BookBO bookBO = new BookBoImpl();
    TransactionBO transactionBO = new TransactionBoImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setData();
        lblTotalBooks.setText(String.valueOf(bookBO.getAllBookCount()));
        lblAvailableBooks.setText("1");
        getAllTransationId();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> txtTime.setText(timeNow())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void getAllTransationId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = null;

        if (UserLoginFormController.logedUserId > 0){
            id = UserLoginFormController.logedUserId;
        }else {
            id = UserSignupFormController.signupedUSerId;
        }
        list = transactionBO.getAllUserTransactionId(id);


        vBox1.getChildren().clear();
        for(int i = 0; i< list.size(); i++){
            loadTransactionTableData(Integer.parseInt(list.get(i)));
        }
    }

    private void loadTransactionTableData(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UserGlobalFormController.class.getResource("/view/UserTransactionBarForm.fxml"));
            Parent root = null;
            root = loader.load();
            UserTransactionBarFormController controller = loader.getController();
            controller.setData(id);
            vBox1.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date()) ;
    }

    private void setData() {
        //lblTotalUsers.setText("234");
    }

    public void btnUserOnAction(ActionEvent actionEvent) {
    }

    public void btnAvailableBooksOnAction(ActionEvent actionEvent) {
    }

    public void btnTotalBookOnAction(ActionEvent actionEvent) {
    }
}
