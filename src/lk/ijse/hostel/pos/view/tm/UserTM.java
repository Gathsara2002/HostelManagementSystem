/**
 * @author : Gathsara
 * created : 4/15/2023 -- 4:00 PM
 **/

package lk.ijse.hostel.pos.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTM {
    private String userName;
    private String name;
    private String address;
    private String contact_no;
    private String Password;
}
