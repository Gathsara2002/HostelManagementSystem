/**
 * @author : Gathsara
 * created : 4/15/2023 -- 3:02 PM
 **/

package lk.ijse.hostel.pos.dao.custom.impl;

import lk.ijse.hostel.pos.dao.custom.RoomDAO;
import lk.ijse.hostel.pos.entity.Room;
import lk.ijse.hostel.pos.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Room> roomList;
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM room");
        roomList = (ArrayList<Room>) query.list();
        transaction.commit();
        session.close();
        return roomList;
    }

    @Override
    public boolean save(Room room) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room room) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //use lazy fetching
        Room room = session.get(Room.class, id);
        session.delete(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, id);
        transaction.commit();
        session.close();
        return room;
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
