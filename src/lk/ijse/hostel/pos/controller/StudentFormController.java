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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class StudentFormController {

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
    public TableView tblStudent;
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
    }

    public void backOnAction(MouseEvent mouseEvent) {
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
}
