/**
 * @author : Gathsara
 * created : 4/14/2023 -- 8:03 PM
 **/

package lk.ijse.hostel.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String name;
    private String address;
    private String contact_no;
    private String Password;
}
