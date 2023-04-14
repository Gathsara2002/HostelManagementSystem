/**
 * @author : Gathsara
 * created : 4/14/2023 -- 10:08 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class ReservationFormController {
    public AnchorPane reservationAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXTextField txtAddress;
    public JFXTextField txtStdName;
    public JFXTextField txtDob;
    public JFXTextField txtContact;
    public JFXTextField txtGender;
    public JFXComboBox cmbSid;
    public JFXTextField txtResNo;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox cmbRoom;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtqty;
    public JFXRadioButton rbtnYes;
    public Label lblStatus;
    public JFXRadioButton rbtnNo;
    public JFXTextField txtAdvance;
    public JFXButton btnReserve;

    public void homeOnAction(MouseEvent mouseEvent) {
    }

    public void backOnAction(MouseEvent mouseEvent) {
    }

    public void cmbSidOnAction(ActionEvent actionEvent) {
    }

    public void cmbRoomOnAction(ActionEvent actionEvent) {
    }

    public void yesOnAction(ActionEvent actionEvent) {
    }

    public void noOnAction(ActionEvent actionEvent) {
    }

    public void reserveOnAction(ActionEvent actionEvent) {
    }
}
