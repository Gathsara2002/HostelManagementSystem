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

        Query query = session.createQuery("SELECT reservation .res_id, reservation .student_id.student_id, reservation .room_type_id.room_type_id,reservation .student_id.name,reservation .date,reservation .payment,room .key_money, reservation .status FROM room INNER JOIN reservation ON room .room_type_id = reservation .room_type_id.room_type_id ");
        List list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
