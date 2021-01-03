package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDTO {

    private String rent_id;
    private String user_id;
    private Date get_date;
    private Date return_date;
    private int no_of_cars;
    private String Status;

    public RentDTO(String rent_id, Date get_date, Date return_date, int no_of_cars, String status, String user_id) {
        this.rent_id=rent_id;
        this.get_date=get_date;
        this.return_date=return_date;
        this.no_of_cars=no_of_cars;
        this.user_id=user_id;
        this.Status=status;
    }
}
