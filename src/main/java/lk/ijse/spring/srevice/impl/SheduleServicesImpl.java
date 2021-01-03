package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.SheduleDTO;
import lk.ijse.spring.entity.*;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.repo.SheduleRepo;
import lk.ijse.spring.srevice.SheduleServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SheduleServicesImpl implements SheduleServices {

    @Autowired
    SheduleRepo sheduleRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    DriverRepo driverRepo;

    @Override
    public void SaveShedule(SheduleDTO dto) {
        if (!sheduleRepo.existsById(dto.getShedule_id())){

            updateAndSave(dto,dto.getD_id());
//            Shedule s = mapper.map(dto, Shedule.class);
//            sheduleRepo.save(s);
        }else {
            throw new RuntimeException("shedule Allready exist");
        }
    }

    @Override
    public void updateShedule(SheduleDTO dto) {
        if (sheduleRepo.existsById(dto.getShedule_id())) {

            updateAndSave(dto,dto.getD_id());

//                Rent r = mapper.map(dto, Rent.class);
//            rentRepo.save(r);
        }else {
            throw new RuntimeException("No Such a shedule for update");
        }
    }

    @Override
    public SheduleDTO searchShedule(String shedule_id) {
        Optional<Shedule> shedule = sheduleRepo.findById(shedule_id);
        if (shedule.isPresent()){
            return mapper.map(shedule.get(), SheduleDTO.class);
        }else {
            throw new  RuntimeException("No shedule For "+shedule_id);
        }
    }

    @Override
    public void deleteShedule(String shedule_id) {
        if (sheduleRepo.existsById(shedule_id)){
            sheduleRepo.deleteById(shedule_id);
        }else {
            throw new  RuntimeException("No shedule For Delete RentID: "+shedule_id);
        }
    }

    @Override
    public List<SheduleDTO> getAllShedule() {
        List<Shedule> all = sheduleRepo.findAll();

        List<SheduleDTO> list = new ArrayList<>();
        for (Shedule ss: all){
            list.add(new SheduleDTO(ss.getShedule_id(),
                    ss.getStart_date(),
                    ss.getEnd_date(),
                    ss.getDriver().getD_address()));
        }
        return list;
    }

    private void updateAndSave(SheduleDTO dto, String shedule_id) {
        if (driverRepo.existsById(dto.getD_id())) {
            Driver one = driverRepo.getOne(dto.getD_id());
            Shedule shedule = new Shedule(dto.getShedule_id(),
                    dto.getStart_date(),
                    dto.getEnd_date(),
            one);

            sheduleRepo.save(shedule);
        } else {
            throw new RuntimeException("This Shedule ID isn't Exist !");

        }

    }

}
