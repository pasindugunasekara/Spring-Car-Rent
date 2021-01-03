package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.UserDTO;

import java.util.List;

public interface RentServices {

    void SaveRent(RentDTO dto);
    void updateRent(RentDTO dto);
    RentDTO searchRent(String rent_id);
    void deleteRent(String rent_id);
    List<RentDTO> getAllRent();
}
