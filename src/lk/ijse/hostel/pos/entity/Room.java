/**
 * @author : Gathsara
 * created : 4/13/2023 -- 11:11 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "room")
public class Room {
    @Id
    private String room_type_id;
    @Column
    private String type;
    @Column
    private String key_money;
    @Column
    private int qty;

    @OneToMany(mappedBy = "room_type_id", fetch = FetchType.EAGER)
    private List<Reservation> roomDetails = new ArrayList<>();
}
