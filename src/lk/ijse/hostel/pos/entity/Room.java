/**
 * @author : Gathsara
 * created : 4/13/2023 -- 11:11 AM
 **/

package lk.ijse.hostel.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "room")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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

    public Room(String room_type_id, String type, String key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }
}
