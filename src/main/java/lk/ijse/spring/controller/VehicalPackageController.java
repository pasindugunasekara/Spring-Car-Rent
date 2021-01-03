package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.VehicalPackageDTO;
import lk.ijse.spring.srevice.VehicalPackagesServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/vehicalpackage")
public class VehicalPackageController {

    @Autowired
    VehicalPackagesServices vehicalPackagesServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addVehicalPackage(@RequestBody VehicalPackageDTO dto){
        vehicalPackagesServices.SaveVehicalPackage(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{package_id}")
    public ResponseEntity searchVehicalPackage(@PathVariable String package_id){
        VehicalPackageDTO vehicalPackageDTO = vehicalPackagesServices.searchVehicalPackages(package_id);
        return new ResponseEntity(new StandardResponce(200,"Success",vehicalPackageDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllVehicalPackage(){
        List<VehicalPackageDTO> allvehicalpackage = vehicalPackagesServices.getAllPackages();
        return new ResponseEntity(new StandardResponce(200,"Success",allvehicalpackage) ,HttpStatus.OK);
    }
}
