/**
 * @author : Gathsara
 * created : 4/15/2023 -- 3:10 PM
 **/

package lk.ijse.hostel.pos.dao.custom.impl;

import lk.ijse.hostel.pos.dao.custom.ReservationDAO;
import lk.ijse.hostel.pos.entity.Reservation;
import lk.ijse.hostel.pos.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> reservationList;
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM reservation ");
        reservationList = (ArrayList<Reservation>) query.list();
        transaction.commit();
        session.close();
        return reservationList;
    }

    @Override
    public boolean save(Reservation reservation) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation reservation) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //use lazy fetching
        Reservation reservation = session.get(Reservation.class, id);
        session.delete(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reservation search(String id) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Reservation reservation = session.get(Reservation.class, id);
        transaction.commit();
        session.close();
        return reservation;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("SELECT res_id FROM reservation ORDER BY res_id DESC LIMIT BY 1");
        String newId = (String) query.uniqueResult();
        transaction.commit();
        session.close();

        if (newId != null) {
            int x = Integer.parseInt(newId.replace("RES-", "")) + 1;
            return String.format("RES-%03d", x);
        }
        return "RES-001";
    }
}
