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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import lk.ijse.hostel.pos.bo.BOFactory;
import lk.ijse.hostel.pos.bo.custom.ReservationBO;
import lk.ijse.hostel.pos.dto.ReservationDT0;
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
        String value = String.valueOf(cmbSid.getValue());
        try {
            StudentDTO studentDTO = reservationBO.searchStudent(value);
            fillStudentData(studentDTO);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //--- Search room and get details

    public void cmbRoomOnAction(ActionEvent actionEvent) {
        setActive2();
        String value = String.valueOf(cmbRoom.getValue());
        try {
            RoomDTO roomDTO = reservationBO.searchAllRooms(value);
            fillRoomData(roomDTO);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void yesOnAction(ActionEvent actionEvent) {
        txtAdvance.setDisable(false);
    }

    public void noOnAction(ActionEvent actionEvent) {
        txtAdvance.setDisable(true);
    }

    public void reserveOnAction(ActionEvent actionEvent) {
        String resId = txtResNo.getText();
        LocalDate date = LocalDate.parse(lblDate.getText());
        double room_key_money = Double.parseDouble(txtKeyMoney.getText());

        double advance;
        if (txtAdvance.isDisable()){
            advance=0;
        }else {
            advance= Double.parseDouble(txtAdvance.getText());
        }

        String status = String.valueOf((room_key_money - advance));

        String stdId = String.valueOf(cmbSid.getValue());
        String stdName = txtStdId.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate dob = LocalDate.parse(txtDob.getText());
        String gender = txtGender.getText();

        String roomId = String.valueOf(cmbRoom.getValue());
        String roomType = txtId.getText();
        String keyMoney = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtqty.getText());

        saveReservation(new ReservationDT0(resId, date, status, advance, stdId, roomId));

        clearText();

    }

    private void saveReservation(ReservationDT0 dto) {
        try {
            boolean isSaved = reservationBO.saveReservation(dto);
            new Alert(Alert.AlertType.CONFIRMATION, "Room reserved successfully !").show();
        } catch (SQLException | ClassNotFoundException throwables) {
            new Alert(Alert.AlertType.WARNING, "Something happened !").show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDate();
        setTime();
        setRoomIds();
        setStudentIds();
        initUI();
        generateNewRegId();
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
        rbtnYes.setDisable(true);
        rbtnNo.setDisable(true);
    }

    private void setActive1() {
        txtStdId.setDisable(false);
        txtAddress.setDisable(false);
        txtContact.setDisable(false);
        txtDob.setDisable(false);
        txtGender.setDisable(false);
    }

    private void setActive2() {
        txtKeyMoney.setDisable(false);
        txtqty.setDisable(false);
        txtId.setDisable(false);
        btnReserve.setDisable(false);
        rbtnNo.setDisable(false);
        rbtnYes.setDisable(false);

    }

    private void fillStudentData(StudentDTO studentDTO) {
        txtStdId.setText(studentDTO.getName());
        txtContact.setText(studentDTO.getContact_no());
        txtAddress.setText(studentDTO.getAddress());
        txtDob.setText(String.valueOf(studentDTO.getDob()));
        txtGender.setText(studentDTO.getGender());
    }

    private void fillRoomData(RoomDTO roomDTO) {
        txtqty.setText(String.valueOf(roomDTO.getQty()));
        txtId.setText(roomDTO.getType());
        txtKeyMoney.setText(roomDTO.getKey_money());

    }

    //--- Generate new register id

    private void generateNewRegId() {
        try {
            txtResNo.setText(reservationBO.generateNewId());
            txtAdvance.requestFocus();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //--- Clear text fields after reservation

    private void clearText() {
        txtStdId.clear();
        txtAddress.clear();
        txtContact.clear();
        txtDob.clear();
        txtGender.clear();
        txtAdvance.clear();
        txtKeyMoney.clear();
        txtqty.clear();
        txtId.clear();
    }
}
