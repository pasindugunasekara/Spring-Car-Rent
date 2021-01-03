package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.Lose_damage_wDTO;
import lk.ijse.spring.dto.PaymentDTO;

import java.util.List;

public interface Lose_damage_wServices {

    void SaveLoseDamageW(Lose_damage_wDTO dto);
    void updateLoseDamageW(Lose_damage_wDTO dto);
    Lose_damage_wDTO searchLoseDamageW(String lose_damage_w_id);
    void deleteLoseDamageW(String lose_damage_w_id);
    List<Lose_damage_wDTO> getAllLoseDamageW();
}
