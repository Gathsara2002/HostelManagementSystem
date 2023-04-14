/**
 * @author : Gathsara
 * created : 4/14/2023 -- 12:23 PM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;

public class UserFormController {
    public AnchorPane userAP;
    public Circle btnHome;
    public ImageView btnBack;
    public PasswordField pfPassword;
    public JFXButton btnUpdate;
    public ImageView btnshowPassword;
    public ImageView btnHidePw;
    public TextField txtUsername;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD,userAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD,userAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void showPwOnAction(MouseEvent mouseEvent) {
    }

    public void hidePwOnAction(MouseEvent mouseEvent) {
    }
}
