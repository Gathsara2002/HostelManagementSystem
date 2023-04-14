/**
 * @author : Gathsara
 * created : 4/13/2023 -- 11:09 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservation")
public class Reservation {
    @Id
    private String res_id;
    private LocalDate date;
    private String status;
    private double payment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id", referencedColumnName = "Student_Id")
    private Student student_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_Type_id")
    private Room room_type_id;
}
