/**
 * @author : Gathsara
 * created : 4/13/2023 -- 10:43 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "user")
public class User {

    @Id
    private String userName;
    @Column
    private String name;
    private String address;
    private String contact_no;
    private String Password;
}