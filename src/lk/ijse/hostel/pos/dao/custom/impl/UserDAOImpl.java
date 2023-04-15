/**
 * @author : Gathsara
 * created : 4/15/2023 -- 3:19 PM
 **/

package lk.ijse.hostel.pos.dao.custom.impl;

import lk.ijse.hostel.pos.dao.custom.UserDAO;
import lk.ijse.hostel.pos.entity.User;
import lk.ijse.hostel.pos.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<User> userList;
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM user ");
        userList = (ArrayList<User>) query.list();
        transaction.commit();
        session.close();
        return userList;
    }

    @Override
    public boolean save(User user) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User user) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //use lazy fetching
        User user = session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
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
