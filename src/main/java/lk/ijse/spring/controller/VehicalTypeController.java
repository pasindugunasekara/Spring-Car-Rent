package lk.ijse.spring.controller;


import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.VehicalTypeDTO;
import lk.ijse.spring.entity.VehicalType;
import lk.ijse.spring.srevice.RentServices;
import lk.ijse.spring.srevice.VehicalTypeServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/vehicaltype")
public class VehicalTypeController {

    @Autowired
    VehicalTypeServices vehicalTypeServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addVehicalType(@RequestBody VehicalTypeDTO dto){
        vehicalTypeServices.SaveVehicalType(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"vehical_type_id"})
    public ResponseEntity deleteVehicalType(@RequestParam String vehical_type_id){
        vehicalTypeServices.deleteVehicalType(vehical_type_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateVehicalType(@RequestBody VehicalTypeDTO dto){
        vehicalTypeServices.updateVehicalType(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{vehical_type_id}")
    public ResponseEntity searchVehicalType(@PathVariable String vehical_type_id ){
        VehicalTypeDTO vehicaltypeDTO = vehicalTypeServices.searchVehicalType(vehical_type_id);
        return new ResponseEntity(new StandardResponce(200,"Success",vehicaltypeDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllVehicalType(){
        List<VehicalTypeDTO> allVehicalType = vehicalTypeServices.getAllVehicalTyper();
        return new ResponseEntity(new StandardResponce(200,"Success",allVehicalType) ,HttpStatus.OK);
    }

}
