package lk.ijse.spring.srevice.impl;


import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.VehicalPackageDTO;
import lk.ijse.spring.dto.VehicalTypeDTO;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.entity.VehicalPackages;
import lk.ijse.spring.entity.VehicalType;
import lk.ijse.spring.repo.VehicalPackagesRepo;
import lk.ijse.spring.repo.VehicalTypeRepo;
import lk.ijse.spring.srevice.VehicalTypeServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicalTypeServicesImpl implements VehicalTypeServices {

    @Autowired
    VehicalTypeRepo vehicalTyperepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    VehicalPackagesRepo vehicalPackagesRepo;

    @Override
    public void SaveVehicalType(VehicalTypeDTO dto) {
        if (!vehicalTyperepo.existsById(dto.getVehical_type_id())){

            updateAndSave(dto,dto.getPackage_id());

        }else {
            throw new RuntimeException("Vehical Type  Allready exist");
        }
    }

    @Override
    public void updateVehicalType(VehicalTypeDTO dto) {
        if (vehicalTyperepo.existsById(dto.getVehical_type_id())) {

            updateAndSave(dto,dto.getPackage_id());

        }else {
            throw new RuntimeException("No Such a Vehical Type for update");
        }
    }

    @Override
    public VehicalTypeDTO searchVehicalType(String vehical_type_id) {
        Optional<VehicalType> vehicaltype = vehicalTyperepo.findById(vehical_type_id);
        if (vehicaltype.isPresent()){
            return mapper.map(vehicaltype.get(), VehicalTypeDTO.class);
        }else {
            throw new  RuntimeException("No Vehical Type For "+vehical_type_id);
        }
    }

    @Override
    public void deleteVehicalType(String vehical_type_id) {
        if (vehicalTyperepo.existsById(vehical_type_id)){
            vehicalTyperepo.deleteById(vehical_type_id);
        }else {
            throw new  RuntimeException("No Vehicaltype For Delete Vehical Type ID: "+vehical_type_id);
        }
    }

    @Override
    public List<VehicalTypeDTO> getAllVehicalTyper() {
        List<VehicalType> all = vehicalTyperepo.findAll();
//        return mapper.map(all,new TypeToken<List<RentDTO>>(){}.getType());

        List<VehicalTypeDTO> list = new ArrayList<>();
        for (VehicalType ss: all){
            list.add(new VehicalTypeDTO(ss.getVehical_type_id(),
                    ss.getBrand_name(),
                    ss.getTransmisson_type(),
                    ss.getNo_of_passengers(),
                    ss.getFuel_type(),
                    ss.getPrice_for_km(),
                    ss.getPrice_for_extra_km(),
                    ss.getFee_for_km_month(),
                    ss.getPrice_for_km_day(),
                    ss.getDaily_rate(),
                    ss.getMounthly_rate(),
                    ss.getVehicalPackages().getPackage_id()));
        }
        return list;
    }

    private void updateAndSave(VehicalTypeDTO dto, String vehical_type_id) {
        if (vehicalPackagesRepo.existsById(dto.getPackage_id())) {
            VehicalPackages one = vehicalPackagesRepo.getOne(dto.getPackage_id());
            VehicalType vehicalType = new VehicalType(
                    dto.getVehical_type_id(),
                    dto.getBrand_name(),
                    dto.getTransmisson_type(),
                    dto.getNo_of_passengers(),
                    dto.getFuel_type(),
                    dto.getPrice_for_km(),
                    dto.getPrice_for_extra_km(),
                    dto.getFee_for_km_month(),
                    dto.getPrice_for_km_day(),
                    dto.getDaily_rate(),
                    dto.getMounthly_rate(),

                    one);

            vehicalTyperepo.save(vehicalType);
        } else {
            throw new RuntimeException("This Vehical Type ID isn't Exist !");

        }

    }

}
