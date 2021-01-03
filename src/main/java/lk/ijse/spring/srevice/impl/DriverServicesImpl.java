package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.srevice.DriverServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServicesImpl implements DriverServices {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void SaveDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getD_id())){
            Driver d = mapper.map(dto, Driver.class);
            driverRepo.save(d);
        }else {
            throw new RuntimeException("Driver Allready exist");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getD_id())) {
            Driver d = mapper.map(dto, Driver.class);
            driverRepo.save(d);
        }else {
            throw new RuntimeException("No Such a Driver for update");
        }
    }

    @Override
    public DriverDTO serchDriver(String D_id) {
        Optional<Driver> driver = driverRepo.findById(D_id);
        if (driver.isPresent()){
            return mapper.map(driver.get(), DriverDTO.class);
        }else {
            throw new  RuntimeException("No Driver For "+D_id);
        }
    }

    @Override
    public void deleteDriver(String D_id) {
        if (driverRepo.existsById(D_id)){
            driverRepo.deleteById(D_id);
        }else {
            throw new  RuntimeException("No Driver For Delete DriverID: "+D_id);
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all,new TypeToken<List<DriverDTO>>(){}.getType());
    }
}
