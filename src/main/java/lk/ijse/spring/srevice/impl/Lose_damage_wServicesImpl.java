package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.Lose_damage_wDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Lose_damage_waiver;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.Lose_damage_wRepo;
import lk.ijse.spring.srevice.Lose_damage_wServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Lose_damage_wServicesImpl implements Lose_damage_wServices {

    @Autowired
    Lose_damage_wRepo lose_damage_wRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void SaveLoseDamageW(Lose_damage_wDTO dto) {
        if (!lose_damage_wRepo.existsById(dto.getLose_damage_w_id())){
            Lose_damage_waiver l = mapper.map(dto, Lose_damage_waiver.class);
            lose_damage_wRepo.save(l);
        }else {
            throw new RuntimeException("Lose damage waiver Allready exist");
        }
    }

    @Override
    public void updateLoseDamageW(Lose_damage_wDTO dto) {
        if (lose_damage_wRepo.existsById(dto.getLose_damage_w_id())) {
            Lose_damage_waiver lo = mapper.map(dto, Lose_damage_waiver.class);
            lose_damage_wRepo.save(lo);
        }else {
            throw new RuntimeException("No Such a Lose damage waiver for update");
        }
    }

    @Override
    public Lose_damage_wDTO searchLoseDamageW(String lose_damage_w_id) {
        Optional<Lose_damage_waiver> lose_damage_waiver = lose_damage_wRepo.findById(lose_damage_w_id);
        if (lose_damage_waiver.isPresent()){
            return mapper.map(lose_damage_waiver.get(), Lose_damage_wDTO.class);
        }else {
            throw new  RuntimeException("No losedamage waiver For "+lose_damage_w_id);
        }
    }

    @Override
    public void deleteLoseDamageW(String lose_damage_w_id) {
        if (lose_damage_wRepo.existsById(lose_damage_w_id)){
            lose_damage_wRepo.deleteById(lose_damage_w_id);
        }else {
            throw new  RuntimeException("No losedamage waiver For Delete UserID: "+lose_damage_w_id);
        }
    }

    @Override
    public List<Lose_damage_wDTO> getAllLoseDamageW() {
        List<Lose_damage_waiver> all = lose_damage_wRepo.findAll();
        return mapper.map(all,new TypeToken<List<Lose_damage_wDTO>>(){}.getType());
    }
}
