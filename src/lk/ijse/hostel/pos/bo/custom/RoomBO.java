/**
 * @author : Gathsara
 * created : 4/17/2023 -- 12:13 PM
 **/

package lk.ijse.hostel.pos.bo.custom;

import lk.ijse.hostel.pos.bo.SuperBO;
import lk.ijse.hostel.pos.dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {

    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

    RoomDTO searchAllRooms(String id) throws SQLException, ClassNotFoundException;

    boolean saveRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteRooms(String id) throws SQLException, ClassNotFoundException;

    boolean existRoomsID(String id) throws SQLException, ClassNotFoundException;
}
