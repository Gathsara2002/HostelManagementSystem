/**
 * @author : Gathsara
 * created : 4/15/2023 -- 2:28 PM
 **/

package lk.ijse.hostel.pos.dao.impl;

import lk.ijse.hostel.pos.dao.custom.StudentDAO;
import lk.ijse.hostel.pos.entity.Student;
import lk.ijse.hostel.pos.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<Student> studentList;
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM student");
        studentList = (ArrayList<Student>) query.list();
        transaction.commit();
        session.close();
        return studentList;
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //use lazy fetching
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
        return true;
    }
}
