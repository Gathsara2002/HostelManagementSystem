/**
 * @author : Gathsara
 * created : 4/13/2023 -- 10:08 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    public AnchorPane loginAP;
    public JFXButton btnLogin;
    public TextField txtUsername;
    public TextField txtPassword;

//    String passWord=txtPassword.getText();
//    String userName=txtUsername.getText();

    public void logInOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD_FORM,loginAP);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
