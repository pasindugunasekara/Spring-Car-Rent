package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.VehicalTypeDTO;

import java.util.List;

public interface VehicalTypeServices {

    void SaveVehicalType(VehicalTypeDTO dto);
    void updateVehicalType(VehicalTypeDTO dto);
    VehicalTypeDTO searchVehicalType(String vehical_type_id);
    void deleteVehicalType(String vehical_type_id);
    List<VehicalTypeDTO> getAllVehicalTyper();
}
