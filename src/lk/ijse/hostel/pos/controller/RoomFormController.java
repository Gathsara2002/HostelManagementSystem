/**
 * @author : Gathsara
 * created : 4/14/2023 -- 9:21 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;
import lk.ijse.hostel.pos.view.tm.RoomTM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {
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

    public void saveOnAction(ActionEvent actionEvent) {
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
    }

    private void setCellValueFactory() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }
}
