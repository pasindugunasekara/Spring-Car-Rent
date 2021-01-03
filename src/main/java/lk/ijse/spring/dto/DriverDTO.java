package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private String d_id;
    private String d_name;
    private String d_email;
    private String d_pw;
    private String d_address;
    private int d_contact;
    private String d_licean_no;
    private String d_licen_p1;
    private String d_licen_p2;
    private Date registerd_date;


}
