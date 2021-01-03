package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private String payment_id;
    private String method_type;
    private String payment_date;
    private String amount;
    private String rent_id;


}
