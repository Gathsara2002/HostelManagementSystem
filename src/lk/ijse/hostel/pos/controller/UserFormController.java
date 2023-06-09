/**
 * @author : Gathsara
 * created : 4/14/2023 -- 12:23 PM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.bo.BOFactory;
import lk.ijse.hostel.pos.bo.custom.UserBO;
import lk.ijse.hostel.pos.dto.UserDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserFormController implements Initializable {

    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

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
    public TextField txtShowPassword;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, userAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, userAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--- Update user details

    public void updateOnAction(ActionEvent actionEvent) {

        String userName = txtUsername.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String passWord = pfPassword.getText();

        if (btnshowPassword.isDisabled()) {
            passWord = txtShowPassword.getText();
        }

        if (!userName.matches("^[A-z]{3,50}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid username ! Try again").show();
            txtUsername.requestFocus();
            return;

        } else if (!name.matches("^[A-Za-z ]+$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid name ! Try again").show();
            txtName.requestFocus();
            return;

        } else if (!address.matches("^([A-z]{3,40})$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid address ! Try again").show();
            txtAddress.requestFocus();
            return;

        } else if (!contact.matches("^(07[0-9]{8})$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid contact number ! Try again").show();
            txtContact.requestFocus();
            return;

        } else if (!passWord.matches("^[0-9]{5,10}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid password ! Try again").show();
            pfPassword.requestFocus();
            return;
        }

        try {
            boolean isUpdated = userBO.updateUser(new UserDTO(userName, name, address, contact, passWord));
            if (isUpdated) {
                loadProfile();
                new Alert(Alert.AlertType.CONFIRMATION, "User updated !").show();
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    //--- Show / Hide passwords to user

    public void showPwOnAction(MouseEvent mouseEvent) {
        String id = txtUsername.getText();
        String passWord = null;
        try {
            UserDTO userDTO = userBO.searchUser(id);
            passWord = userDTO.getPassword();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        txtShowPassword.setText(passWord);
        pfPassword.setVisible(false);
        btnHidePw.setDisable(false);
        btnHidePw.setVisible(true);
        btnshowPassword.setDisable(true);
        btnshowPassword.setVisible(false);
        txtShowPassword.setVisible(true);
    }

    public void hidePwOnAction(MouseEvent mouseEvent) {
        String id = txtUsername.getText();
        String passWord = null;
        try {
            UserDTO userDTO = userBO.searchUser(id);
            passWord = userDTO.getPassword();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        pfPassword.setText(passWord);
        txtShowPassword.setVisible(false);
        btnHidePw.setDisable(true);
        btnHidePw.setVisible(false);
        btnshowPassword.setDisable(false);
        btnshowPassword.setVisible(true);
        pfPassword.setVisible(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadProfile();
        btnHidePw.setDisable(true);
        btnHidePw.setVisible(false);
        txtShowPassword.setVisible(false);

      /*  String userName="Admin";
        String name="Gathsara";
        String address="Galle";
        String contact="0763412498";
        String passWord="1234";

        UserDTO userDTO = new UserDTO(userName, name, address, contact, passWord);
        try {
            userBO.saveUser(userDTO);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }*/
    }

    //--- Load user data to ui

    private void loadProfile() {
        try {
            ArrayList<UserDTO> allUser = userBO.getAllUser();
            for (UserDTO userDTO : allUser) {
                txtUsername.setText(userDTO.getUserName());
                txtName.setText(userDTO.getName());
                txtAddress.setText(userDTO.getAddress());
                txtContact.setText(userDTO.getContact_no());
                pfPassword.setText(userDTO.getPassword());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
