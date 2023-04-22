/**
 * @author : Gathsara
 * created : 4/13/2023 -- 11:09 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reservation")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reservation {
    @Id
    private String res_id;
    @Column
    private LocalDate date;
    @Column
    private String status;
    @Column
    private double payment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id", referencedColumnName = "Student_Id")
    private Student student_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id", referencedColumnName = "room_Type_id")
    private Room room_type_id;
}
