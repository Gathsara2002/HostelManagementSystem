/**
 * @author : Gathsara
 * created : 4/17/2023 -- 12:14 PM
 **/

package lk.ijse.hostel.pos.bo.custom.impl;

import lk.ijse.hostel.pos.bo.custom.RoomBO;
import lk.ijse.hostel.pos.dao.DAOFactory;
import lk.ijse.hostel.pos.dao.custom.RoomDAO;
import lk.ijse.hostel.pos.dto.RoomDTO;
import lk.ijse.hostel.pos.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList();
        for (Room room : all) {
            allRoom.add(new RoomDTO(room.getRoom_type_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        return allRoom;
    }

    @Override
    public RoomDTO searchAllRooms(String id) throws SQLException, ClassNotFoundException {
        Room search = roomDAO.search(id);
        return new RoomDTO(search.getRoom_type_id(), search.getType(), search.getKey_money(), search.getQty());

    }

    @Override
    public boolean saveRooms(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(dto.getRoom_type_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(dto.getRoom_type_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public boolean deleteRooms(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(id);
    }

    @Override
    public boolean existRoomsID(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.exist(id);
    }
}
