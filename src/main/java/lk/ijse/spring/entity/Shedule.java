package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Shedule {
    @Id
    private String shedule_id;
    private Date start_date;
    private Date end_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "D_id",referencedColumnName = "D_id",nullable = false)
    private Driver driver;


}
