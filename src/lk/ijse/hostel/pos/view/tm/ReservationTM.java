/**
 * @author : Gathsara
 * created : 4/15/2023 -- 4:01 PM
 **/

package lk.ijse.hostel.pos.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationTM {
    private String res_id;
    private LocalDate date;
    private String status;
    private double payment;
    private String student_id;
    private String room_type_id;
}
