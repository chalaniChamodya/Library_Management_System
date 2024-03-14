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
import lk.ijse.Library_Management_System.BO.Custom.BranchBO;
import lk.ijse.Library_Management_System.BO.Custom.Impl.BranchBoImpl;
import lk.ijse.Library_Management_System.Utill.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StaffBranchFormController {

    private static StaffBranchFormController controller;
    public AnchorPane pagingPane;
    public TextField txtSearchBook;
    public Label txtTime;
    public VBox vBox;

    BranchBO branchBO = new BranchBoImpl();

    public StaffBranchFormController(){
        controller = this;
    }
    public static StaffBranchFormController getInstance(){
        return controller;
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        getAllId();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> txtTime.setText(timeNow())));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public void getAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = null;
        list = branchBO.getAllBranchId();


        vBox.getChildren().clear();
        for(int i = 0; i< list.size(); i++){
            loadTableData(Integer.parseInt(list.get(i)));
            //System.out.println(Integer.parseInt(list.get(i)));
        }
    }
    private void loadTableData(int id) {
        //System.out.println("load table data");
        try {
            FXMLLoader loader = new FXMLLoader(StaffBranchFormController.class.getResource("/view/StaffBranchBarForm.fxml"));
            Parent root = null;
            root = loader.load();
            StaffBranchBarFormController controller = loader.getController();
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

    private String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date()) ;
    }

    public void btnAddBranchOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.popupPane("StaffBranchAddForm.fxml");
    }
}
