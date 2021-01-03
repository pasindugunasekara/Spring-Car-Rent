package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.srevice.DriverServices;
import lk.ijse.spring.util.StandardResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/driver")
public class DriverController {

    @Autowired
    DriverServices driverServices;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addDriver(@RequestBody DriverDTO dto){
        driverServices.SaveDriver(dto);
        StandardResponce responce = new StandardResponce(200, "Success", null);
        return new ResponseEntity(responce, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"D_id"})
    public ResponseEntity deleteDriver(@RequestParam String D_id){
        driverServices.deleteDriver(D_id);
        return new ResponseEntity(new  StandardResponce(200,"Success",null), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto){
        driverServices.updateDriver(dto);
        return new ResponseEntity(new StandardResponce(200,"Success",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{D_id}")
    public ResponseEntity searchDriver(@PathVariable String D_id){
        DriverDTO driverDTO = driverServices.serchDriver(D_id);
        return new ResponseEntity(new StandardResponce(200,"Success",driverDTO) ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriver(){
        List<DriverDTO> allDriver = driverServices.getAllDriver();
        return new ResponseEntity(new StandardResponce(200,"Success",allDriver) ,HttpStatus.OK);
    }

}
