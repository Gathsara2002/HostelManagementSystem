/**
 * @author : Gathsara
 * created : 4/15/2023 -- 3:09 PM
 **/

package lk.ijse.hostel.pos.dao.custom;

import lk.ijse.hostel.pos.dao.CrudDAO;
import lk.ijse.hostel.pos.entity.Reservation;

import java.sql.SQLException;

public interface ReservationDAO extends CrudDAO<Reservation,String> {
    String generateNewId() throws SQLException, ClassNotFoundException;
}
