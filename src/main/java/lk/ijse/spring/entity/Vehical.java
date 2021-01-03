package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehical {
    @Id
    private String vehicalId;
    private String colure;
    private String available;
    private String sidepic1;
    private String backvpic2;
    private String frontpic3;
}
