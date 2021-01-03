package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @Column(nullable = false , unique = true)
    private String user_id;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private String email;
    private String password;
    private String licen_id;
    private String licen_pic;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<Rent> rents= new ArrayList<>();

    public User(String user_id, String name, String nic, String address, String contact, String email,
                String password, String licen_id ,String licen_pic) {
        this.user_id = user_id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.licen_id = licen_id;
        this.licen_pic = licen_pic;
    }
}
