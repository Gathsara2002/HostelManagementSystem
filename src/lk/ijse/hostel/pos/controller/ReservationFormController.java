/**
 * @author : Gathsara
 * created : 4/14/2023 -- 10:08 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {
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
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD,reservationAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD,reservationAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setDate();
        setTime();
    }

    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    private void setTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, event -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());

        }),
                new KeyFrame(Duration.seconds(1))

        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }
}
