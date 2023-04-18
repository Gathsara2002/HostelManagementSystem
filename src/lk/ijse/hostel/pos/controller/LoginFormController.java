/**
 * @author : Gathsara
 * created : 4/13/2023 -- 10:08 AM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.pos.bo.BOFactory;
import lk.ijse.hostel.pos.bo.custom.UserBO;
import lk.ijse.hostel.pos.dto.UserDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginFormController {

    public AnchorPane loginAP;
    public JFXButton btnLogin;
    public TextField txtUsername;
    public TextField txtPassword;
    public PasswordField passwordField;
    public Label lblWarning;

    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

    public void logInOnAction(ActionEvent actionEvent) {
        if (checkLogin()){
            try {
                Navigation.navigate(Routes.DASHBOARD_FORM, loginAP);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            lblWarning.setVisible(true);
            txtUsername.clear();
            passwordField.clear();
            txtUsername.requestFocus();
        }
    }

    public void hidePwOnAction(MouseEvent mouseEvent) {
    }

    public void showPwOnAction(MouseEvent mouseEvent) {
    }

    //--- Check username , password when user login to system

    private boolean checkLogin() {
        String userName1 = txtUsername.getText();
        String passWord1 = passwordField.getText();
        String userName2 = null;
        String passWord2=null;

        try {
            ArrayList<UserDTO> allUser = userBO.getAllUser();
            for (UserDTO userDTO : allUser) {

                userName2 = userDTO.getUserName();
                passWord2 = userDTO.getPassword();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return userName1.equalsIgnoreCase(userName2) && passWord1.equalsIgnoreCase(passWord2);
    }
}
