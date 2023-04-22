/**
 * @author : Gathsara
 * created : 4/22/2023 -- 12:00 PM
 **/

package lk.ijse.hostel.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomDTO {
    private String room_type_Id;
    private String type;
    private String key_money;
    private int qty;
    private String student_Id;
    private String name;
    private String address;
    private String contact_no;
    private LocalDate dob;
    private String gender;
    private String res_id;
    private LocalDate date;
    private String status;
    private double payment;

    public CustomDTO(String res_id, String student_Id, String room_type_Id, String name, LocalDate date, String key_money, double payment, String status) {
        this.res_id = res_id;
        this.student_Id = student_Id;
        this.room_type_Id = room_type_Id;
        this.name = name;
        this.date = date;
        this.key_money = key_money;
        this.payment = payment;
        this.status = status;
    }
}



