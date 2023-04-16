/**
 * @author : Gathsara
 * created : 4/15/2023 -- 2:26 PM
 **/

package lk.ijse.hostel.pos.dao.custom;
import lk.ijse.hostel.pos.dao.CrudDAO;
import lk.ijse.hostel.pos.entity.Student;

import java.sql.SQLException;

public interface StudentDAO extends CrudDAO<Student,String> {
    String generateNewId() throws SQLException, ClassNotFoundException;
}
