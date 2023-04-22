/**
 * @author : Gathsara
 * created : 4/13/2023 -- 12:12 PM
 **/

package lk.ijse.hostel.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;

public class DashBordFormController {
    public AnchorPane dashBoardAP;
    public Button btnUser;
    public Button btnReserve;
    public Button btnRoom;
    public Button btnStudent;
    public Circle btnHome;
    public Button btnKeyMoney;

    public void manageUserOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER, dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnReserveOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.RESERVATION, dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageRoomOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ROOM_FORM, dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnStdOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.STUDENT_FORM, dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.LOGIN_FORM,dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnKeyMoneyOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.KEY_MONEY_FORM, dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToLoginOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.LOGIN_FORM,dashBoardAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
