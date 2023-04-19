/**
 * @author : Gathsara
 * created : 4/19/2023 -- 12:54 PM
 **/

package lk.ijse.hostel.pos.bo.custom.impl;

import lk.ijse.hostel.pos.bo.custom.ReservationBO;
import lk.ijse.hostel.pos.dao.DAOFactory;
import lk.ijse.hostel.pos.dao.custom.ReservationDAO;
import lk.ijse.hostel.pos.dao.custom.RoomDAO;
import lk.ijse.hostel.pos.dao.custom.StudentDAO;
import lk.ijse.hostel.pos.dto.ReservationDT0;
import lk.ijse.hostel.pos.dto.RoomDTO;
import lk.ijse.hostel.pos.dto.StudentDTO;
import lk.ijse.hostel.pos.entity.Reservation;
import lk.ijse.hostel.pos.entity.Room;
import lk.ijse.hostel.pos.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public ArrayList<ReservationDT0> getAllReservation() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> all = reservationDAO.getAll();
        ArrayList<ReservationDT0> allReservation = new ArrayList<>();
        for (Reservation reservation : all) {
            allReservation.add(new ReservationDT0(reservation.getRes_id(), reservation.getDate(), reservation.getStatus(),
                    reservation.getPayment(), reservation.getStudent_id().getStudent_id(), reservation.getRoom_type_id().getRoom_type_id()));
        }
        return allReservation;
    }

    //---- Save reservation (transaction)
    @Override
    public boolean saveReservation(ReservationDT0 dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateReservation(ReservationDT0 dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteReservation(String id) throws SQLException, ClassNotFoundException {
        return reservationDAO.delete(id);
    }

    @Override
    public ReservationDT0 searchReservation(String id) throws SQLException, ClassNotFoundException {
        Reservation search = reservationDAO.search(id);
        ReservationDT0 reservationDT0 = new ReservationDT0(search.getRes_id(), search.getDate(), search.getStatus(),
                search.getPayment(), search.getStudent_id().getStudent_id(), search.getRoom_type_id().getRoom_type_id());

        return reservationDT0;
    }

    @Override
    public boolean existReservation(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return reservationDAO.generateNewId();
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();
        for (Student student : all) {
            allStudent.add(new StudentDTO(student.getStudent_id(), student.getName(), student.getAddress(), student.getContact_no(), student.getDob(), student.getGender()));
        }
        return allStudent;
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();
        for (Room room : all) {
            allRoom.add(new RoomDTO(room.getRoom_type_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        return allRoom;
    }

    @Override
    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(dto.getRoom_type_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public RoomDTO searchAllRooms(String id) throws SQLException, ClassNotFoundException {
        Room search = roomDAO.search(id);
        return new RoomDTO(search.getRoom_type_id(), search.getType(), search.getKey_money(), search.getQty());
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException {
        Student search = studentDAO.search(id);
        return new StudentDTO(search.getStudent_id(), search.getName(), search.getAddress(),
                search.getContact_no(), search.getDob(), search.getGender());
    }
}
