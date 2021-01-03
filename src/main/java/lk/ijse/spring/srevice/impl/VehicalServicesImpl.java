package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.VehicalDTO;
import lk.ijse.spring.repo.VehicalRepo;
import lk.ijse.spring.srevice.VehicalServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehicalServicesImpl implements VehicalServices {

    @Autowired
    VehicalRepo vehicalRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void SaveVehical(VehicalDTO dto) {

    }

    @Override
    public void updateVehical(VehicalDTO dto) {

    }

    @Override
    public VehicalDTO searchVehical(String vehicalId) {
        return null;
    }

    @Override
    public void deleteVehical(String vehicalId) {

    }

    @Override
    public List<VehicalDTO> getAllVehical() {
        return null;
    }
}