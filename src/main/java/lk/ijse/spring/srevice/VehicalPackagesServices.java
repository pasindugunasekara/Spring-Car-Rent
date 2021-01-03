package lk.ijse.spring.srevice;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.VehicalPackageDTO;

import java.util.List;

public interface VehicalPackagesServices {

    void SaveVehicalPackage(VehicalPackageDTO dto);
    VehicalPackageDTO searchVehicalPackages(String package_id);
    List<VehicalPackageDTO> getAllPackages();
}
