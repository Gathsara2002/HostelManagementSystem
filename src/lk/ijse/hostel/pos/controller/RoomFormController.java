/**
 * @author : Gathsara
 * created : 4/14/2023 -- 9:21 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.bo.BOFactory;
import lk.ijse.hostel.pos.bo.custom.RoomBO;
import lk.ijse.hostel.pos.dto.RoomDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;
import lk.ijse.hostel.pos.view.tm.RoomTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {

    private final RoomBO roomBO = (RoomBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ROOM);

    public AnchorPane roomAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXTextField txtRoomType;
    public JFXTextField txtQty;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomId;
    public TableView<RoomTM> tblRoom;
    public TableColumn colRoomId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public JFXButton btnAddRoom;
    public JFXButton btnSave;
    public TableColumn colQty;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public JFXComboBox cmbRoomId;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, roomAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newRoomOnAction(ActionEvent actionEvent) {
    }

    //--- Save room data

    public void saveOnAction(ActionEvent actionEvent) {
        String id = txtRoomId.getText();
        String type = txtRoomType.getText();
        String keyMoney = txtKeyMoney.getText();
        int qty = Integer.parseInt(txtQty.getText());

        try {
            boolean isSaved = roomBO.saveRooms(new RoomDTO(id, type, keyMoney, qty));
            if (isSaved) {
                tblRoom.getItems().add(new RoomTM(id, type, keyMoney, qty));
                clearFields();
                loadAllRooms();
                setRoomIds();
                new Alert(Alert.AlertType.CONFIRMATION, "Room added to system !").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            new Alert(Alert.AlertType.WARNING, "Something Wrong Happened !").show();
        }
        btnAddRoom.fire();
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, roomAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void roomIdOnAction(ActionEvent actionEvent) {
    }

    private void initUi() {
        txtRoomId.setDisable(true);
        txtRoomType.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtQty.setDisable(true);

        btnSave.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initUi();
        setCellValueFactory();
        loadAllRooms();
        setRoomIds();
    }

    private void setCellValueFactory() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    //--- Set room ids to cob box

    private void setRoomIds() {
        ObservableList<String> roomIds = FXCollections.observableArrayList();
        try {
            ArrayList<RoomDTO> allRooms = roomBO.getAllRooms();
            for (RoomDTO allRoom : allRooms) {
                roomIds.add(allRoom.getRoom_type_id());
            }
            cmbRoomId.setItems(roomIds);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void clearFields() {
        txtRoomId.clear();
        txtRoomType.clear();
        txtQty.clear();
        txtKeyMoney.clear();
        txtRoomId.requestFocus();
    }

    //--- Load rooms to table

    private void loadAllRooms() {
        tblRoom.getItems().clear();
        try {
            ArrayList<RoomDTO> allRooms = roomBO.getAllRooms();
            for (RoomDTO roomDTO : allRooms) {
                tblRoom.getItems().add(new RoomTM(roomDTO.getRoom_type_id(), roomDTO.getType(),
                        roomDTO.getKey_money(), roomDTO.getQty()));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setActive() {
        txtRoomId.setDisable(false);
        txtRoomType.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtQty.setDisable(false);
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
    }
}
