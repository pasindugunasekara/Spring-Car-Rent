package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VehicalPackages {
    @Id
    private String package_id;
    private String package_name;
    private double price;

    @OneToMany(mappedBy = "vehicalPackages" ,cascade = CascadeType.ALL)
    private List<VehicalType> vehicalTypes= new ArrayList<>();
}
