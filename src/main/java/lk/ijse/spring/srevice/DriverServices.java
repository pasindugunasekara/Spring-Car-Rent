package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;

import java.util.List;

public interface DriverServices {

    void SaveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    DriverDTO serchDriver(String D_id);
    void deleteDriver(String D_id);
    List<DriverDTO> getAllDriver();
}
