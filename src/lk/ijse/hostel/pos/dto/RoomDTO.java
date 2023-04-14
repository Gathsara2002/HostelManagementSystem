/**
 * @author : Gathsara
 * created : 4/14/2023 -- 7:57 PM
 **/

package lk.ijse.hostel.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String room_type_id;
    private String type;
    private String key_money;
    private int qty;
}
