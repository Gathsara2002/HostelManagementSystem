/**
 * @author : Gathsara
 * created : 4/14/2023 -- 5:52 PM
 **/

package lk.ijse.hostel.pos.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();


        switch (route){
            case DASHBOARD_FORM:
                window.setTitle("Dashboard Form");
                initUI("DashBoardForm.fxml");
                break;

            case STUDENT_FORM:
                window.setTitle("Manage Student Form");
                initUI("StudentForm.fxml");
                break;

            case ROOM_FORM:
                window.setTitle("Manage Room Form");
                initUI("RoomForm.fxml");
                break;

            case USER:
                window.setTitle("Manage User Form");
                initUI("UserForm.fxml");
                break;

            case KEY_MONEY_FORM:
                window.setTitle("Find Remain Key Money Form");
                initUI("FindKeyMoneyForm.fxml");
                break;

            case RESERVATION:
                window.setTitle("Manage Reservation Form");
                initUI("ReservationForm.fxml");
                break;
        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/hostel/pos/view/" + location)));
    }
}
