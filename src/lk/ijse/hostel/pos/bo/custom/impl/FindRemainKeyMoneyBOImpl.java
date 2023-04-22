/**
 * @author : Gathsara
 * created : 4/22/2023 -- 12:27 PM
 **/

package lk.ijse.hostel.pos.bo.custom.impl;

import lk.ijse.hostel.pos.bo.custom.FindRemainKeyMoneyBO;
import lk.ijse.hostel.pos.dao.DAOFactory;
import lk.ijse.hostel.pos.dao.custom.QueryDAO;
import lk.ijse.hostel.pos.dto.CustomDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FindRemainKeyMoneyBOImpl implements FindRemainKeyMoneyBO {

    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public ArrayList<CustomDTO> getRemainKeyMoney() throws Exception {
        List<Object[]> remainKeyMoney = queryDAO.getRemainKeyMoney();
        ArrayList<CustomDTO> list = new ArrayList<>();

        for (Object[] o : remainKeyMoney) {
            list.add(new CustomDTO((String) o[0], (String) o[1], (String) o[2], (String) o[3], (LocalDate) o[4],
                    (String) o[5], (double) o[6], (String) o[7]));
        }
        return list;
    }
}
