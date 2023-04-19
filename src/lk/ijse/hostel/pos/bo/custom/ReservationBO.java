/**
 * @author : Gathsara
 * created : 4/19/2023 -- 12:18 PM
 **/

package lk.ijse.hostel.pos.bo.custom;

import lk.ijse.hostel.pos.bo.SuperBO;
import lk.ijse.hostel.pos.dto.ReservationDT0;
import lk.ijse.hostel.pos.dto.RoomDTO;
import lk.ijse.hostel.pos.dto.StudentDTO;


import java.sql.SQLException;
import java.util.ArrayList;


public interface ReservationBO extends SuperBO {

    ArrayList<ReservationDT0> getAllReservation() throws SQLException, ClassNotFoundException;

    boolean saveReservation(ReservationDT0 dto) throws SQLException, ClassNotFoundException;

    boolean updateReservation(ReservationDT0 dto) throws SQLException, ClassNotFoundException;

    boolean deleteReservation(String id) throws SQLException, ClassNotFoundException;

    ReservationDT0 searchReservation(String id) throws SQLException, ClassNotFoundException;

    boolean existReservation(String id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException;

    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

    boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    RoomDTO searchAllRooms(String id) throws SQLException, ClassNotFoundException;

    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException;


}
