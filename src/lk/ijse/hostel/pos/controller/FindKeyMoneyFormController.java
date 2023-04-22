/**
 * @author : Gathsara
 * created : 4/14/2023 -- 2:11 PM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.bo.BOFactory;
import lk.ijse.hostel.pos.bo.custom.FindRemainKeyMoneyBO;
import lk.ijse.hostel.pos.dto.CustomDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;
import lk.ijse.hostel.pos.view.tm.ReservationTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FindKeyMoneyFormController implements Initializable {

    private final FindRemainKeyMoneyBO keyMoneyBO = (FindRemainKeyMoneyBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.QUERY);

    public AnchorPane findeKeyMoneyAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXComboBox cmbResNo;
    public TableView<ReservationTM> tblFindeKeyMoney;
    public TableColumn colResNo;
    public TableColumn colRoomId;
    public TableColumn colSid;
    public TableColumn colSName;
    public TableColumn colKeyMoney;
    public TableColumn colAdvance;
    public TableColumn colStatus;
    public TableColumn colData;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, findeKeyMoneyAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, findeKeyMoneyAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resNoOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         colResNo.setCellValueFactory(new PropertyValueFactory<>("res_id"));
         colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_Id"));
         colSid.setCellValueFactory(new PropertyValueFactory<>("student_Id"));
         colSName.setCellValueFactory(new PropertyValueFactory<>("name"));
         colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
         colAdvance.setCellValueFactory(new PropertyValueFactory<>("payment"));
         colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
         colData.setCellValueFactory(new PropertyValueFactory<>("date"));

        try {
            ArrayList<CustomDTO> remainMoney = keyMoneyBO.getRemainKeyMoney();

            for (CustomDTO dto : remainMoney) {

                tblFindeKeyMoney.getItems().add(new ReservationTM(dto.getRes_id(),dto.getStudent_Id(),dto.getRoom_type_Id(),
                        dto.getName(),dto.getDate(),dto.getKey_money(),dto.getPayment(),dto.getStatus()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //0912254500

    }
}
