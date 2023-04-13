/**
 * @author : Gathsara
 * created : 4/13/2023 -- 11:05 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "student")
public class Student {

    @Id
    private String student_id;
    @Column
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;

    @OneToMany(mappedBy = "student_id",fetch = FetchType.EAGER)
    private List<Reservation> studentList=new ArrayList();
}
