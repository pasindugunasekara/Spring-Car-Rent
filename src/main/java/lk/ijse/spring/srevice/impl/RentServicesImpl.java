package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.RentRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.srevice.RentServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentServicesImpl implements RentServices {

    @Autowired
    RentRepo rentRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserRepo repo;

    @Override
    public void SaveRent(RentDTO dto) {
            if (!rentRepo.existsById(dto.getRent_id())){

                updateAndSave(dto,dto.getUser_id());
//                Rent u = mapper.map(dto, Rent.class);
//                rentRepo.save(u);
            }else {
                throw new RuntimeException("Rent  Allready exist");
            }
    }

    @Override
    public void updateRent(RentDTO dto) {
           if (rentRepo.existsById(dto.getRent_id())) {

                updateAndSave(dto,dto.getUser_id());

//                Rent r = mapper.map(dto, Rent.class);
//            rentRepo.save(r);
            }else {
                throw new RuntimeException("No Such a Rent for update");
            }
    }

    @Override
    public RentDTO searchRent(String rent_id) {
        Optional<Rent> rent = rentRepo.findById(rent_id);
        if (rent.isPresent()){
            return mapper.map(rent.get(),RentDTO.class);
        }else {
            throw new  RuntimeException("No Rent For "+rent_id);
        }
    }

    @Override
    public void deleteRent(String rent_id) {
        if (rentRepo.existsById(rent_id)){
            rentRepo.deleteById(rent_id);
        }else {
            throw new  RuntimeException("No Rent For Delete RentID: "+rent_id);
        }
    }

    @Override
    public List<RentDTO> getAllRent() {
        List<Rent> all = rentRepo.findAll();
//        return mapper.map(all,new TypeToken<List<RentDTO>>(){}.getType());

        List<RentDTO> list = new ArrayList<>();
        for (Rent ss: all){
            list.add(new RentDTO(ss.getRent_id(),
                    ss.getGet_date(),
                    ss.getReturn_date(),
                    ss.getNo_of_cars(),
                    ss.getStatus(),
                    ss.getUser().getUser_id()));
        }
        return list;
    }



    private void updateAndSave(RentDTO dto, String rent_id) {
        if (repo.existsById(dto.getUser_id())) {
            User one = repo.getOne(dto.getUser_id());
            Rent rent = new Rent(
                    dto.getRent_id(),
                    dto.getGet_date(),
                    dto.getReturn_date(),
                    dto.getNo_of_cars(),
                    dto.getStatus(),

            one);

            rentRepo.save(rent);
        } else {
            throw new RuntimeException("This Customer ID isn't Exist !");

        }

    }
}
