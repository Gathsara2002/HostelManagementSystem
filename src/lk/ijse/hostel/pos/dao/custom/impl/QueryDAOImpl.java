/**
 * @author : Gathsara
 * created : 4/22/2023 -- 12:06 PM
 **/

package lk.ijse.hostel.pos.dao.custom.impl;

import lk.ijse.hostel.pos.dao.custom.QueryDAO;
import lk.ijse.hostel.pos.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List getRemainKeyMoney() throws Exception {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT res.res_id,res.student_id.student_id,res.room_type_id.room_type_id,res.student_id.name,res.date,res.room_type_id.key_money,res.payment,res.status" +
                " FROM reservation res INNER JOIN room  r ON res.room_type_id.room_type_id=r.room_type_id ORDER BY res.res_id");
        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
