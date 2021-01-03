package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Lose_damage_waiver {
    @Id
    private String lose_damage_w_id;
    private String lose_damage_w_pic;
    private double payment_amount;
    private double deduct_amount;
    private String status;

    @OneToOne(mappedBy = "lose_damage_w_id" ,cascade = CascadeType.ALL)
    private RentDetails rentDetails;
}
