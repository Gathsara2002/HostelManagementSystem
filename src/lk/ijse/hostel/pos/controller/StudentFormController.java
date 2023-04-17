/**
 * @author : Gathsara
 * created : 4/13/2023 -- 4:44 PM
 **/

package lk.ijse.hostel.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lk.ijse.hostel.pos.bo.custom.StudentBO;
import lk.ijse.hostel.pos.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostel.pos.dto.StudentDTO;
import lk.ijse.hostel.pos.util.Navigation;
import lk.ijse.hostel.pos.util.Routes;
import lk.ijse.hostel.pos.view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

    StudentBO studentBO = new StudentBOImpl();

    public AnchorPane studentAP;
    public Circle btnHome;
    public ImageView btnBack;
    public JFXTextField txtAddress;
    public JFXTextField txtStdName;
    public JFXTextField txtDate;
    public JFXTextField txtContact;
    public JFXTextField txtSid;
    public JFXRadioButton rbtnMale;
    public Label lblGender;
    public JFXRadioButton rbtnFemale;
    public TableView<StudentTM> tblStudent;
    public TableColumn colSid;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDob;
    public TableColumn colGender;
    public JFXButton btnNewStd;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;
    public DatePicker datePicker;
    public JFXComboBox cmbStdId;

    public void homeOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, studentAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        try {
            Navigation.navigate(Routes.BACK_TO_DASHBOARD, studentAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rbtnMaleOnAction(ActionEvent actionEvent) {
    }

    public void rbtnFemaleOnAction(ActionEvent actionEvent) {
    }

    public void newStdaOnAction(ActionEvent actionEvent) {
        setActive();
        String newId = null;
        try {
            newId = studentBO.generateNewId();
            txtSid.setText(newId);
            clearFields();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String sid = txtSid.getText();
        String name = txtStdName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String gender = "Male";
        if (rbtnFemale.isSelected()) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        LocalDate dob = datePicker.getValue();
        try {
            studentBO.saveStudent(new StudentDTO(sid, name, address, contact, dob, gender));
            tblStudent.getItems().add(new StudentTM(sid, name, address, contact, dob, gender));
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Student Added Successfully !").show();
        } catch (SQLException | ClassNotFoundException throwables) {
            new Alert(Alert.AlertType.WARNING, "Something Wrong Happened !").show();
        }
    }

    //--- Update student data

    public void updateOnAction(ActionEvent actionEvent) {
        String sid = txtSid.getText();
        String name = txtStdName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        String gender = "Male";
        if (rbtnFemale.isSelected()) {
            gender = "Female";
        } else {
            gender = "Male";
        }
        LocalDate dob = datePicker.getValue();

        try {
            studentBO.updateStudent(new StudentDTO(sid, name, address, contact, dob, gender));
            clearFields();
            new Alert(Alert.AlertType.CONFIRMATION, "Student updated successfully !").show();

        } catch (SQLException | ClassNotFoundException throwables) {
            new Alert(Alert.AlertType.ERROR, "Something happened !").show();
        }
    }

    //--- Delete student

    public void deleteOnAction(ActionEvent actionEvent) {
        String value = (String) cmbStdId.getValue();
        try {
            boolean isDeleted = studentBO.deleteStudent(value);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION,"Student deleted successfully").show();
                clearFields();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //--- Create combo box for select student ids

    public void sidOnAction(ActionEvent actionEvent) {
        String value = (String) cmbStdId.getValue();
        try {
            StudentDTO studentDTO = studentBO.searchStudent(value);
            fillStudentData(studentDTO);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //--- Set student data when user select combo box

    private void fillStudentData(StudentDTO studentDTO) {
        txtSid.setText(studentDTO.getStudent_id());
        txtContact.setText(studentDTO.getContact_no());
        txtAddress.setText(studentDTO.getAddress());
        txtStdName.setText(studentDTO.getName());
        datePicker.setValue(studentDTO.getDob());

        if (studentDTO.getGender().equalsIgnoreCase("Male")) {
            rbtnMale.fire();
        } else {
            rbtnFemale.fire();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initUi();
        setStudentIds();
        setCellFactoryValues();
        loadAllStudents();
    }

    private void initUi() {
        txtSid.setDisable(true);
        txtAddress.setDisable(true);
        txtContact.setDisable(true);
        txtStdName.setDisable(true);
        txtDate.setDisable(true);
        rbtnFemale.setDisable(true);
        rbtnMale.setDisable(true);
        datePicker.setDisable(true);

        btnSave.setDisable(true);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
    }

    //-----Set buttons and text fields active

    private void setActive() {
        txtSid.setDisable(false);
        txtAddress.setDisable(false);
        txtContact.setDisable(false);
        txtStdName.setDisable(false);
        txtDate.setDisable(false);
        rbtnFemale.setDisable(false);
        rbtnMale.setDisable(false);
        datePicker.setDisable(false);
        btnSave.setDisable(false);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
    }

    //-----Ser student's ids to combo box

    private void setStudentIds() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();
            for (StudentDTO studentDTO : allStudent) {
                list.add(studentDTO.getStudent_id());
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        cmbStdId.setItems(list);
    }

    //--- Load students to table

    private void loadAllStudents() {
        tblStudent.getItems().clear();
        try {
            ArrayList<StudentDTO> allStudent = studentBO.getAllStudent();
            for (StudentDTO studentDTO : allStudent) {
                tblStudent.getItems().add(new StudentTM(studentDTO.getStudent_id(), studentDTO.getName(), studentDTO.getAddress(),
                        studentDTO.getContact_no(), studentDTO.getDob(), studentDTO.getGender()));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setCellFactoryValues() {
        colSid.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }

    //--- to clear text fields

    private void clearFields(){
        txtStdName.clear();
        txtAddress.clear();
        txtContact.clear();
        datePicker.getEditor().clear();
        txtStdName.requestFocus();
    }
}
