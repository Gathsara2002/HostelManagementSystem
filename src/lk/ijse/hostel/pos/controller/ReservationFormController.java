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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.hostel.pos.bo.BOFactory;
import lk.ijse.hostel.pos.bo.custom.ReservationBO;
import lk.ijse.hostel.pos.dto.RoomDTO;
import lk.ijse.hostel.pos.dto.StudentDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.RESERVATION);

    public AnchorPane reservationAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXTextField txtAddress;
    public JFXTextField txtDob;
    public JFXTextField txtContact;
    public JFXTextField txtGender;
    public JFXComboBox cmbSid;
    public JFXTextField txtResNo;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox cmbRoom;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtqty;
    public JFXRadioButton rbtnYes;
    public Label lblStatus;
    public JFXRadioButton rbtnNo;
    public JFXTextField txtAdvance;
    public JFXButton btnReserve;
    public JFXTextField txtId;
    public ToggleGroup status;
    public JFXTextField txtStdId;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, reservationAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, reservationAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--- Search and get student data from combo box

    public void cmbSidOnAction(ActionEvent actionEvent) {
        setActive1();
        String value = (String) cmbSid.getValue();
        try {
            StudentDTO studentDTO = reservationBO.searchStudent(value);
            fillStudentData(studentDTO);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
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
        setRoomIds();
        setStudentIds();
        initUI();
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

    //---Set room name to combo box

    private void setRoomIds() {

        try {
            ArrayList<RoomDTO> allRooms = reservationBO.getAllRooms();
            for (RoomDTO allRoom : allRooms) {
                cmbRoom.getItems().add(allRoom.getRoom_type_id());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //---Set student name to combo box

    private void setStudentIds() {
        try {
            ArrayList<StudentDTO> allStudent = reservationBO.getAllStudent();
            for (StudentDTO studentDTO : allStudent) {
                cmbSid.getItems().add(studentDTO.getStudent_id());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initUI() {
        txtStdId.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        txtDob.setDisable(true);
        txtGender.setDisable(true);
        txtAdvance.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtqty.setDisable(true);
        txtId.setDisable(true);
        btnReserve.setDisable(true);
    }

    private void setActive1() {
        txtStdId.setDisable(false);
        txtAddress.setDisable(false);
        txtContact.setDisable(false);
        txtDob.setDisable(false);
        txtGender.setDisable(false);
    }

    private void setActive2() {
        txtAdvance.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtqty.setDisable(false);
        txtId.setDisable(false);
        btnReserve.setDisable(false);

    }

    private void fillStudentData(StudentDTO studentDTO) {
        txtStdId.setText(studentDTO.getName());
        txtContact.setText(studentDTO.getContact_no());
        txtAddress.setText(studentDTO.getAddress());
        txtDob.setText(String.valueOf(studentDTO.getDob()));
        txtGender.setText(studentDTO.getGender());
    }
}
