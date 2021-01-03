package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.SheduleDTO;
import lk.ijse.spring.dto.UserDTO;

import java.util.List;

public interface SheduleServices {

    void SaveShedule(SheduleDTO dto);
    void updateShedule(SheduleDTO dto);
    SheduleDTO searchShedule(String shedule_id);
    void deleteShedule(String shedule_id);
    List<SheduleDTO> getAllShedule();
}
