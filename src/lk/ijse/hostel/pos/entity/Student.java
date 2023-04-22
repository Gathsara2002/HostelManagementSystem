/**
 * @author : Gathsara
 * created : 4/13/2023 -- 11:05 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

    @Id
    private String student_id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contact_no;
    @Column
    private LocalDate dob;
    @Column
    private String gender;

    @OneToMany(mappedBy = "student_id",fetch = FetchType.EAGER)
    private List<Reservation> studentList=new ArrayList();

    public Student(String student_id, String name, String address, String contact_no, LocalDate dob, String gender) {
        this.student_id = student_id;
        this.name = name;
        this.address = address;
        this.contact_no = contact_no;
        this.dob = dob;
        this.gender = gender;
    }
}
