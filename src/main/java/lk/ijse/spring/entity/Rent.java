package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rent {
    @Id
    private String rent_id;
    private Date get_date;
    private Date return_date;
    private int no_of_cars;
    private String Status;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToOne(mappedBy = "rent", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(mappedBy = "rent", cascade = CascadeType.ALL)
    private RentDetails rentDetails;

    public Rent(String rent_id, Date get_date, Date return_date, int no_of_cars, String status,
                 User one) {
        this.rent_id=rent_id;
        this.get_date=get_date;
        this.return_date=return_date;
        this.no_of_cars=no_of_cars;
        this.Status=status;
        this.user=one;
    }
}
