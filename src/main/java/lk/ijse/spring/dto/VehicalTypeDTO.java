package lk.ijse.spring.dto;

import lk.ijse.spring.entity.User;
import lk.ijse.spring.entity.VehicalPackages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicalTypeDTO {
    private String vehical_type_id;
    private String package_id;
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


    public VehicalTypeDTO(String fuel_type, String vehical_type_id, String brand_name, String transmisson_type,
                          String no_of_passengers, String price_for_km, String price_for_extra_km, String fee_for_km_month,
                          String price_for_km_day, String daily_rate, String mounthly_rate, String package_id) {
        this.vehical_type_id=vehical_type_id;
        this.brand_name=brand_name;
        this.transmisson_type=transmisson_type;
        this.no_of_passengers=no_of_passengers;
        this.price_for_km=price_for_km;
        this.price_for_extra_km=price_for_extra_km;
        this.fuel_type=fuel_type;
        this.fee_for_km_month=fee_for_km_month;
        this.price_for_km_day=price_for_km_day;
        this.mounthly_rate=mounthly_rate;
        this.daily_rate=daily_rate;
        this.package_id=package_id;


    }
}
