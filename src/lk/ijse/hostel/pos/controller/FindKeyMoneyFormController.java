/**
 * @author : Gathsara
 * created : 4/14/2023 -- 2:11 PM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class FindKeyMoneyFormController {
    public AnchorPane findeKeyMoneyAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXComboBox cmbResNo;
    public TableView tblFindeKeyMoney;
    public TableColumn colResNo;
    public TableColumn colRoomId;
    public TableColumn colSid;
    public TableColumn colSName;
    public TableColumn colRoomType;
    public TableColumn colKeyMoney;
    public TableColumn colAdvance;
    public TableColumn colStatus;

    public void homeOnAction(MouseEvent mouseEvent) {
    }

    public void backOnAction(MouseEvent mouseEvent) {
    }

    public void resNoOnAction(ActionEvent actionEvent) {
    }
}
