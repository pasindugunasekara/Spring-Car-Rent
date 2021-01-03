package lk.ijse.spring.srevice.impl;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.VehicalPackageDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.entity.VehicalPackages;
import lk.ijse.spring.repo.VehicalPackagesRepo;
import lk.ijse.spring.srevice.VehicalPackagesServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicalPackagesServicesImpl implements VehicalPackagesServices {

    @Autowired
    VehicalPackagesRepo vehicalPackagesRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void SaveVehicalPackage(VehicalPackageDTO dto) {
        if (!vehicalPackagesRepo.existsById(dto.getPackage_id())){
            VehicalPackages u = mapper.map(dto, VehicalPackages.class);
            vehicalPackagesRepo.save(u);
        }else {
            throw new RuntimeException("Package Allready exist");
        }
    }

    @Override
    public VehicalPackageDTO searchVehicalPackages(String package_id) {
        Optional<VehicalPackages> vehicalPackages = vehicalPackagesRepo.findById(package_id);
        if (vehicalPackages.isPresent()){
            return mapper.map(vehicalPackages.get(), VehicalPackageDTO.class);
        }else {
            throw new  RuntimeException("No vehicalPackage For "+package_id);
        }
    }

    @Override
    public List<VehicalPackageDTO> getAllPackages() {
        List<VehicalPackages> all = vehicalPackagesRepo.findAll();
        return mapper.map(all,new TypeToken<List<VehicalPackageDTO>>(){}.getType());
    }
}
