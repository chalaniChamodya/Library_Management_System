package lk.ijse.Library_Management_System.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import lk.ijse.Library_Management_System.BO.Custom.BookBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BookBoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserBookFormController {
    private static UserBookFormController controller;
    public AnchorPane pagingPane;
    public VBox vBox;
    public TextField txtSearchBook;
    public Label txtTime;

    BookBO bookBO = new BookBoImpl();

    public UserBookFormController(){
        controller = this;
    }

    public static UserBookFormController getInstance(){
        return controller;
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        getAllId();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> txtTime.setText(timeNow())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date()) ;
    }

    public void getAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = null;
        list = bookBO.getAvailableBooks();


        vBox.getChildren().clear();
        for(int i = 0; i< list.size(); i++){
            loadTableData(Integer.parseInt(list.get(i)));
        }
    }

    private void loadTableData(int id) {
        try {
            FXMLLoader loader = new FXMLLoader(UserBookFormController.class.getResource("/view/UserBookBarForm.fxml"));
            Parent root = null;
            root = loader.load();
            UserBookBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnAvailableBooksOnAction(ActionEvent actionEvent) {
    }

    public void btnAllBooksOnAction(ActionEvent actionEvent) {
    }
}
