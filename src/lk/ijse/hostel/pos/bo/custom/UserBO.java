/**
 * @author : Gathsara
 * created : 4/17/2023 -- 3:54 PM
 **/

package lk.ijse.hostel.pos.bo.custom;

import lk.ijse.hostel.pos.bo.SuperBO;
import lk.ijse.hostel.pos.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserDTO> getAllUser() throws SQLException, ClassNotFoundException;

    boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateStudent(UserDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteUser(String id) throws SQLException, ClassNotFoundException;

    UserDTO searchUser(String id) throws SQLException, ClassNotFoundException;

    boolean existUser(String id) throws SQLException, ClassNotFoundException;
}
