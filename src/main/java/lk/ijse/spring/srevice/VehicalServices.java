package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.VehicalDTO;

import java.util.List;

public interface VehicalServices {
    void SaveVehical(VehicalDTO dto);
    void updateVehical(VehicalDTO dto);
    VehicalDTO searchVehical(String vehicalId);
    void deleteVehical(String vehicalId);
    List<VehicalDTO> getAllVehical();
}
