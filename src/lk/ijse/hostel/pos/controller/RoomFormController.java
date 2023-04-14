/**
 * @author : Gathsara
 * created : 4/14/2023 -- 9:21 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RoomFormController {
    public AnchorPane roomAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXTextField txtRoomType;
    public JFXTextField txtQty;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomId;
    public TableView tblRoom;
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
    }

    public void roomIdOnAction(ActionEvent actionEvent) {
    }
}
