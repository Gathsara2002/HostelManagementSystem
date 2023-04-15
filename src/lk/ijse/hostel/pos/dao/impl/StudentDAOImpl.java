/**
 * @author : Gathsara
 * created : 4/15/2023 -- 2:28 PM
 **/

package lk.ijse.hostel.pos.dao.impl;

import lk.ijse.hostel.pos.dao.custom.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements Student {
    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
