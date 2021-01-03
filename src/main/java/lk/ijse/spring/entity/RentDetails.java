package lk.ijse.spring.entity;

import javax.persistence.*;

@Entity
public class RentDetails {
    @Id
    private String rent_details_id;
    private int milage;
    private String drive_requred;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rent_id", referencedColumnName = "rent_id",nullable = false)
    private Rent rent;

    @OneToOne(fetch= FetchType.EAGER, optional=false ,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lose_damage_w_id")
    private Lose_damage_waiver lose_damage_w_id;

}
