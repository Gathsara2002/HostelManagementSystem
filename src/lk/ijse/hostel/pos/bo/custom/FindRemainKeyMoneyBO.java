/**
 * @author : Gathsara
 * created : 4/22/2023 -- 12:26 PM
 **/

package lk.ijse.hostel.pos.bo.custom;

import lk.ijse.hostel.pos.bo.SuperBO;
import lk.ijse.hostel.pos.dto.CustomDTO;

import java.util.ArrayList;

public interface FindRemainKeyMoneyBO extends SuperBO {
    ArrayList<CustomDTO> getRemainKeyMoney() throws Exception;
}
