package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicalDTO {
    private String vehicalId;
    private String colure;
    private String available;
    private String sidepic1;
    private String backvpic2;
    private String frontpic3;
    private String vehical_type_id;
    private String package_id;
}
