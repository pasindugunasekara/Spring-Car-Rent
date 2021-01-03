package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.predicate.PredicateImplementor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class VehicalType {
    @Id
    private String vehical_type_id;
    private String brand_name;
    private String transmisson_type;
    private String no_of_passengers;
    private String fuel_type;
    private String price_for_km;
    private String price_for_extra_km;
    private String fee_for_km_month;
    private String price_for_km_day;
    private String daily_rate;
    private String mounthly_rate;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "package_id", referencedColumnName = "package_id", nullable = false)
    private VehicalPackages vehicalPackages;

    public VehicalType(String vehical_type_id, String brand_name, String transmisson_type, String no_of_passengers,
                       String fuel_type, String price_for_km, String price_for_extra_km, String fee_for_km_month, String price_for_km_day, String daily_rate, String mounthly_rate, VehicalPackages vehicalPackages) {
        this.vehical_type_id = vehical_type_id;
        this.brand_name = brand_name;
        this.transmisson_type = transmisson_type;
        this.no_of_passengers = no_of_passengers;
        this.fuel_type = fuel_type;
        this.price_for_km = price_for_km;
        this.price_for_extra_km = price_for_extra_km;
        this.fee_for_km_month = fee_for_km_month;
        this.price_for_km_day = price_for_km_day;
        this.daily_rate = daily_rate;
        this.mounthly_rate = mounthly_rate;
        this.vehicalPackages = vehicalPackages;
    }
}
