package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Driver {
    @Id
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

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Shedule> shedules = new ArrayList<>();

    public Driver(String d_id, String d_name, String d_email, String d_pw, String d_address, int d_contact, String d_licean_no,
                  String d_licen_p1, String d_licen_p2, Date registerd_date, List<Shedule> shedules) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_email = d_email;
        this.d_pw = d_pw;
        this.d_address = d_address;
        this.d_contact = d_contact;
        this.d_licean_no = d_licean_no;
        this.d_licen_p1 = d_licen_p1;
        this.d_licen_p2 = d_licen_p2;
        this.registerd_date = registerd_date;
        this.shedules = shedules;
    }
}
