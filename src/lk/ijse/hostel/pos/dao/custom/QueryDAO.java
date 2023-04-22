/**
 * @author : Gathsara
 * created : 4/22/2023 -- 12:00 PM
 **/

package lk.ijse.hostel.pos.dao.custom;

import lk.ijse.hostel.pos.dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {

    List<Object[]> getRemainKeyMoney() throws Exception;
}
