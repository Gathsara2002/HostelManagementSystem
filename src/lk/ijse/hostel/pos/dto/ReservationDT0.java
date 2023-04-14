/**
 * @author : Gathsara
 * created : 4/14/2023 -- 7:54 PM
 **/

package lk.ijse.hostel.pos.dto;

import lk.ijse.hostel.pos.entity.Room;
import lk.ijse.hostel.pos.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDT0 {
    private String res_id;
    private LocalDate date;
    private String status;
    private double payment;
    private String student_id;
    private String room_type_id;
}
