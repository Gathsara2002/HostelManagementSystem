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

import java.io.IOException;
import java.net.URL;

public class LoginForm {

    public AnchorPane loginAP;
    public JFXButton btnLogin;
    public TextField txtUsername;
    public TextField txtPassword;

//    String passWord=txtPassword.getText();
//    String userName=txtUsername.getText();

    public void logInOnAction(ActionEvent actionEvent) {

        try {
            URL resource = getClass().getResource("/lk/ijse/hostel/pos/view/DashBordForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginAP.getScene().getWindow();
            window.setScene(new Scene(load));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
