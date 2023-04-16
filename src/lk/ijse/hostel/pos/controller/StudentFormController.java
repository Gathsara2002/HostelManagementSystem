/**
 * @author : Gathsara
 * created : 4/13/2023 -- 4:44 PM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.bo.custom.StudentBO;
import lk.ijse.hostel.pos.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel.pos.dto.StudentDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;
import lk.ijse.hostel.pos.view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

    StudentBO studentBO = new StudentBOImpl();

    public AnchorPane studentAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXTextField txtAddress;
    public JFXTextField txtStdName;
    public JFXTextField txtDate;
    public JFXTextField txtContact;
    public JFXTextField txtSid;
    public JFXRadioButton rbtnMale;
    public Label lblGender;
    public JFXRadioButton rbtnFemale;
    public TableView<StudentTM> tblStudent;
    public TableColumn colSid;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public JFXButton btnNewStd;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public DatePicker datePicker;
    public JFXComboBox cmbStdId;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, studentAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, studentAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rbtnMaleOnAction(ActionEvent actionEvent) {
    }

    public void rbtnFemaleOnAction(ActionEvent actionEvent) {
    }

    public void newStdaOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void sidOnAction(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         initUi();
    }

    private void initUi() {
        txtSid.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        txtStdName.setDisable(true);
        rbtnFemale.setDisable(true);
        rbtnMale.setDisable(true);
        datePicker.setDisable(true);

        btnSave.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }


}
