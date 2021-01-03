package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lose_damage_wDTO {

    private String lose_damage_w_id;
    private String lose_damage_w_pic;
    private double payment_amount;
    private double deduct_amount;
    private String status;


}
