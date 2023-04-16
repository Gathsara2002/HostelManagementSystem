/**
 * @author : Gathsara
 * created : 4/15/2023 -- 3:55 PM
 **/

package lk.ijse.hostel.pos.bo.custom;

import lk.ijse.hostel.pos.bo.SuperBO;
import lk.ijse.hostel.pos.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException;

    boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;

    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException;

    boolean existStudent(String id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

}
